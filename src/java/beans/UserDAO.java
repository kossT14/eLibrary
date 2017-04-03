/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author koss
 */
public class UserDAO {

    static Connection con = null;
    static ResultSet rs = null;

    public static UserBean login(UserBean user) {

        //preparing some objects for connection 
        Statement stm = null;

        String username = user.getUsername();
        String password = user.getPassword();
        String role = user.getRole();

        String searchQuery = "select * from users where username='"
                + username
                + "' AND password='"
                + password + "'";

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + username);
        System.out.println("Your password is " + password);
        System.out.println("Your role is " + role);
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB 
            con = ConnectionManager.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery(searchQuery);
            boolean rsHasRows = rs.next();

            // if user does not exist set the isValid variable to false
            if (!rsHasRows) {
                System.out.println("Sorry, you are not a registered user! Please sign up first!");
                user.setValid(false);
            } //if user exists set the isValid variable to true
            else if (rsHasRows) {
                System.out.println("Welcome " + username);
                user.setValid(true);
            }
        } catch (SQLException ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //some exception handling
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }

            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                }
                stm = null;
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }

                con = null;
            }
        }

        return user;

    }
}

