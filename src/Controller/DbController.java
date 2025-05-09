package Controller;
/*
 * This class is responsible (should be responsible) for handling all the database operations.
 * However, lots of methods are not used in the project due to time limit.
 * These methods should be used in the tool panel.
 */

import java.sql.*;
import java.util.ArrayList;

public class DbController {

    public static Statement statement = null;

    public static Connection connection = null;

    public static DatabaseMetaData metaData = null;

    //The data base address
    private static String url = "jdbc:mariadb://3.147.76.80:3306";

    //Will create a connection to the database using given username and password
    public static boolean connectDB(String username, String password) {

        try {
            // Establishing a connection
            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();

            metaData = connection.getMetaData();

            System.out.println("Database connected successfully!");

        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    // Close the connection, but never used
    public static void closeConnection() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create a database, but never used
    public static void addDatabase(String databaseName) {
        try {
            statement.executeUpdate("CREATE DATABASE " + databaseName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove a database, but never used
    public static void removeDatabase(String databaseName) {
        try {
            statement.executeUpdate("DROP DATABASE " + databaseName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove a table, but never used
    public static void removeTable(String tableName) {
        try {
            statement.executeUpdate("DROP TABLE " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get the database names
    public static ArrayList<String> getDatabaseNames() {
        ArrayList<String> databases = new ArrayList<>();

        try {
            ResultSet resultSet = metaData.getCatalogs();

            while (resultSet.next()) {
                String databaseName = resultSet.getString(1);
                databases.add(databaseName);
            }

            resultSet.close();
        } catch (

        SQLException e) {
            e.printStackTrace();
        }

        return databases;
    }

    // Get the table names in a database
    public static ArrayList<String> getTableNames(String databaseName) {
        ArrayList<String> tables = new ArrayList<>();

        try {
            ResultSet resultSet = metaData.getTables(databaseName, null, null, new String[] { "TABLE" });

            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                tables.add(tableName);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tables;
    }

    // Select a database
    public static boolean useDatabase(String dbName) {
        try {
            statement.execute("USE " + dbName);
    
            System.out.println("Switched to database " + dbName + " successfully!");
    
            return true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            return false;
        }
    }
}
