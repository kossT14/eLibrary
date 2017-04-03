/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author koss
 */
public class ConnectionManager {

    static Connection con;
    static String url;

    public static Connection getConnection() {

        try {
            String user = "kossT";
            String password = "1411";
            url = "jdbc:derby://localhost:1527/EBOOKSDB;create=true;";
            String driver = "org.apache.derby.jdbc.ClientDriver";

            Class.forName(driver);

            try {
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
}
