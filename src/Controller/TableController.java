/*
 * This class is responsible for creating and loading tables from CSV files.
 */

package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.opencsv.CSVReader;

import Application.Application;

public class TableController {

    private static CSVReader csvReader;

    // Create a table from a CSV file with the columns
    public static void createTable(String name, String path) {

        try {
            csvReader = new CSVReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }

        try {
            csvReader = new CSVReader(new FileReader(path));
            String[] headers = csvReader.readNext();
            String[] firstDataRow = csvReader.readNext();

            String query = "CREATE TABLE " + Application.currentDb + "." + name + " (";
            for (int i = 0; i < headers.length; i++) {
                String column = headers[i];
                String value = firstDataRow[i];
                String dataType = "VARCHAR(255)"; // default data type

                if (value.matches("^\\d+$")) {
                    dataType = "INT";
                } else if (value.matches("^\\d+\\.\\d+$")) {
                    dataType = "FLOAT";
                } else if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                    dataType = "TINYINT(1)";
                }


                query += column + " " + dataType + ", ";
            }
            query = query.substring(0, query.length() - 2) + ")";
            System.out.println(query);
            DbController.statement.executeUpdate(query);

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (Exception e) {
            System.err.println("CSV Reading Error");
        }
    }

    // Load the values into the empty table
    public static void loadTable(String tableName, String filePath) {
        try {
            csvReader = new CSVReader(new FileReader(filePath));
            csvReader.skip(1);
            String[] row;
            while ((row = csvReader.readNext()) != null) {
                StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
    
                for (String value : row) {
                    if (value.equalsIgnoreCase("true")) {
                        query.append("1, ");
                    } else if (value.equalsIgnoreCase("false")) {
                        query.append("0, ");
                    } else {
                        query.append("'").append(value.replace("'", "''")).append("', ");
                    }
                }

    
                query = new StringBuilder(query.substring(0, query.length() - 2) + ")");
                System.out.println(query);
                DbController.statement.executeUpdate(query.toString());
            }
    
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (Exception e) {
            System.err.println("CSV Reading Error");
        }
    }

    // Export an existing table to a CSV file
    public static void exportTableToCSV(String tableName, String outputPath) {
    try (
        Statement stmt = DbController.connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + tableName);
        PrintWriter writer = new PrintWriter(new FileWriter(outputPath))
    ) {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Write header
        for (int i = 1; i <= columnCount; i++) {
            writer.print(metaData.getColumnName(i));
            if (i < columnCount) writer.print(",");
        }
        writer.println();

        // Write rows
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                writer.print(value != null ? value.toString() : "");
                if (i < columnCount) writer.print(",");
            }
            writer.println();
        }

        System.out.println("Exported table '" + tableName + "' to: " + outputPath);
    } catch (Exception e) {
        System.err.println("Failed to export table to CSV");
        e.printStackTrace();
    }
}

}