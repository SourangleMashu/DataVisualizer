/*
 * This class is responsible for creating and loading tables from CSV files.
 */

package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;

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

                if (value.matches("\\d+")) {
                    dataType = "INT";
                } else if (value.matches("\\d+\\.\\d+")) {
                    dataType = "FLOAT";
                } else if (value.matches("true|false")) {
                    dataType = "BOOLEAN";
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
                    query.append("'").append(value.replace("'", "''")).append("', ");
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
}