/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author koss
 */
public class ConnectionManager {

    // jdbc Connection
    private static Connection conn = null;
    private static Statement stm = null;
    private static ResultSet rs = null;
    private static final String[] TABLES = {"EBOOKS", "CATEGORY", "AUTHORS", "USERS", "RATINGS", "EBOOK_AUT", "USER_ISSN"};

    public static Connection getConnection() {
        try {
            String user = "kossT";
            String password = "1411";
            String url = "jdbc:derby://localhost:1527/EBOOKSDB;create=true;";
            String driver = "org.apache.derby.jdbc.ClientDriver";

            Class.forName(driver);

            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return conn;
    }

    public static void createDB(Connection con) {
        for (String table : TABLES) {
            if (!checkIfTableCreated(con, table)) {
                createTable(con, table);
            }
        }
        if (con != null) {
            shutdown(con);
        }
    }

    static boolean checkIfTableCreated(Connection con, String table) {
        boolean alreadyCreated = false;
        try {
            rs = con.getMetaData().getTables(null, null, table, null);
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                if ((tableName != null) && (tableName.equalsIgnoreCase(table))) {
                    alreadyCreated = true;
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return alreadyCreated;
    }

    static void createTable(Connection con, String table) {
        try {
            stm = con.createStatement();
            switch (table) {
                case "EBOOKS":
                    stm.execute("CREATE TABLE EBOOKS ("
                            + "ISSN VARCHAR(16) NOT NULL, "
                            + "TITLE VARCHAR(64) NOT NULL, "
                            + "CATEGORY VARCHAR(24) NOT NULL, "
                            + "NUMBER_OF_PAGES INTEGER NOT NULL, "
                            + "RATING DOUBLE NOT NULL, "
                            + "PRICE DOUBLE NOT NULL, "
                            + "PRIMARY KEY (ISSN))");
                    break;
                case "CATEGORY":
                    stm.execute("CREATE TABLE CATEGORY ("
                            + "ID INTEGER NOT NULL, "
                            + "NAME VARCHAR(32) NOT NULL, "
                            + "PRIMARY KEY (ID))");
                    stm.execute("INSERT INTO CATEGORY (ID, NAME) VALUES "
                            + "(1, 'Technical'), "
                            + "(2, 'Novel'), "
                            + "(3, 'Art Album')");
                    break;
                case "AUTHORS":
                    stm.execute("CREATE TABLE AUTHORS ("
                            + "AUTHOR_ID INTEGER NOT NULL, "
                            + "NAME VARCHAR(32) NOT NULL, "
                            + "SURNAME VARCHAR(32) NOT NULL, "
                            + "PRIMARY KEY (AUTHOR_ID))");
                    break;
                case "EBOOK_AUT":
                    stm.execute("CREATE TABLE EBOOK_AUT ("
                            + "ISSN VARCHAR(16) NOT NULL, "
                            + "AUTHOR_ID INTEGER NOT NULL, "
                            + "PRIMARY KEY (ISSN))");
                    break;
                case "USERS":
                    stm.execute("CREATE TABLE USERS ("
                            + "USER_ID INTEGER NOT NULL, "
                            + "USERNAME VARCHAR(16) NOT NULL, "
                            + "PASSWORD VARCHAR(32) NOT NULL, "
                            + "ROLE VARCHAR(16) NOT NULL, "
                            + "PRIMARY KEY (USER_ID))");
                    break;
                case "USER_ISSN":
                    stm.execute("CREATE TABLE USER_ISSN ("
                            + "USER_ID INTEGER NOT NULL, "
                            + "ISSN VARCHAR(16) NOT NULL, "
                            + "PRIMARY KEY (USER_ID))");
                    break;
                case "RATINGS":
                    stm.execute("CREATE TABLE RATINGS ("
                            + "USER_ID INTEGER NOT NULL, "
                            + "RATING DOUBLE NOT NULL, "
                            + "DESCRIPTION VARCHAR(255) NOT NULL, "
                            + "PRIMARY KEY (USER_ID))");
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Error creating table " + table);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    System.out.println("Error closing statement!");
                }
            }
        }
    }

    public static void shutdown(Connection con) {
        /*if (rset != null) {
            try {
                rset.close();
            } catch (SQLException e) {
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println("Error closing statement!");
            }
        }*/
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error when trying to close connection!");
            }
        }
    }

}
