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

    public static User login(User user) {

        //preparing some objects for connection 
        Statement stm;

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
                user.setRole(rs.getString("role"));
                System.out.println("Welcome " + username + "!");
                user.setValid(true);
            }
        } catch (SQLException ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //some exception handling
        finally {
            ConnectionManager.shutdown(con);
        }
        return user;
    }

    public static User registerNewUser(User user) {

        //preparing some objects for connection 
        Statement stm = null;
        String username = user.getUsername();

        String searchQuery = "select * from users where username='"
                + username + "'";

        try {
            //connect to DB 
            con = ConnectionManager.getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery(searchQuery);
            boolean rsHasRows = rs.next();

            /* if user does not exist and username field is filled-up
            set the isValid variable to true*/
            if ( (!rsHasRows) && ( !("".equals(username)) ) ) {
                System.out.println("Specified username available!");
                user.setValid(true);
            } //if name already exists, set the isValid variable to false
            else if (rsHasRows) {
                System.out.println("Specified username already exists! "
                        + "Please choose a different one!");
                user.setValid(false);
            } else{
                // username field is empty
                System.out.println("Username field is empty!");
                user.setValid(false);
            }
        } catch (SQLException ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } 
        finally {
            ConnectionManager.shutdown(con);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    System.out.println("Error closing statement!");
                }
            }
        }
        return user;
    }
}
