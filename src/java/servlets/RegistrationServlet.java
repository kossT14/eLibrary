/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author koss
 */
public class RegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // read username and password sent from JSP
        String usr = request.getParameter("user");
        String pass = request.getParameter("pass");
        // Try to create a connection and test if specidied user exists
        // Set connection parameters to DB
        ResultSet rs = null;
        Statement stm = null;
        PreparedStatement pstm;
        Connection con = null;
        String user = "kossT";
        String password = "1411";
        String url = "jdbc:derby://localhost:1527/EBOOKSDB;create=true;";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        try {
            Class driverClass = Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            stm = con.createStatement();
            String query = "SELECT USERNAME FROM USERS WHERE USERNAME = '" + usr + "'";
            rs = stm.executeQuery(query);
            boolean rsHasRows = rs.next();
            if ((!rsHasRows) && (!("".equalsIgnoreCase(usr)))
                    && (!("".equalsIgnoreCase(pass)))) {
                // new username provided does not exist so it will be added to DB
                int id;
                String query1 = "SELECT MAX(USER_ID) AS MAXID FROM USERS";
                rs = stm.executeQuery(query1);
                boolean resultSetHasRows = rs.next();
                boolean noOperation = false;
                if (resultSetHasRows) {
                    // create new ID as MAXID + 1
                    int maxid = rs.getInt(1);
                    id = maxid + 1;

                } else {
                    id = 1;
                }
                // if nothing bad happen until now
                if (!noOperation) {
                    // realize the insert
                    //call stored procedure to insert a new person
                    String DML = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
                    pstm = con.prepareStatement(DML);
                    pstm.setInt(1, id);
                    pstm.setString(2, usr);
                    pstm.setString(3, pass);
                    pstm.setString(4, "user");
                    pstm.execute();
                    // save username as actualUser variable
                    request.getSession().setAttribute("actualUser", usr);
                    // save its role as actualUserRole
                    request.getSession().setAttribute("actualUserRole", rs.getString("ROLE"));
                    // create a variable to hold the authenticated user
                    request.getSession().setAttribute("validUser", true);
                    // delegate to JSP
                    request.getRequestDispatcher("./userPage.jsp").forward(request, response);
                }
            } else {
                if (("".equalsIgnoreCase(usr)) || ("".equalsIgnoreCase(pass))) {
                    // username or password not specified, redirect to register.jsp
                    request.setAttribute("unfilled", true);
                } else {
                    // specified username already exists, redirect to register.jsp
                    request.setAttribute("subscribed", true);
                }
                //request.getSession().setAttribute("validUser", false);
                request.getRequestDispatcher("./register.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Register new user";
    }// </editor-fold>

}
