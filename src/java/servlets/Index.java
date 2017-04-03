/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class Index extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException if we encounter problems with DB
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        // read username and password sent from JSP
        String usr = request.getParameter("un");
        String pass = request.getParameter("pw");
        // Try to create a connection and test if specidied user exists
        // Set connection parameters to DB
        ResultSet rs = null;
        Statement stm = null;
        Connection con = null;
        String user = "kossT";
        String password = "1411";
        String url = "jdbc:derby://localhost:1527/EBOOKSDB;create=true;";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        try {
            Class driverClass = Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            stm = con.createStatement();
            String query = "SELECT USERNAME, PASSWORD, ROLE FROM USERS WHERE USERNAME = '" + usr + "' AND PASSWORD = '" + pass + "'";
            rs = stm.executeQuery(query);
            boolean resultSetHasRows = rs.next();
            if (resultSetHasRows) {
                // save username as actualUser variable
                request.getSession().setAttribute("actualUser", usr);
                // save its role as actualUserRole
                request.getSession().setAttribute("actualUserRole", rs.getString("ROLE"));
                // create a variable to hold the authenticated user
                request.getSession().setAttribute("validUser", true);
                // delegate to JSP
                if (rs.getString("ROLE").equalsIgnoreCase("admin")) {
                    // go to admin page if an admin is logged on
                    request.getRequestDispatcher("./adminPage.jsp").forward(request, response);
                } else {
                    // otherwise go to user page (some menu features are disabled)
                    request.getRequestDispatcher("./userPage.jsp").forward(request, response);
                }
            } else {
                // set validation attribute to false to be sure security will not be broken
                request.getSession().setAttribute("validUser", false);
                // There is no user recorded with these username and password so we'll stay in this page
                request.getRequestDispatcher("./index.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet computes authentication and autorization process";
    }// </editor-fold>

}
