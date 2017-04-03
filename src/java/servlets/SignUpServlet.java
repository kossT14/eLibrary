/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ConnectionManager;
import beans.UserBean;
import beans.UserDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class SignUpServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = ConnectionManager.getConnection();
        PreparedStatement pstm = null;
        // read username and password sent from JSP
        try {
            UserBean newUser = new UserBean();
            newUser.setUsername(request.getParameter("uuser"));
            newUser.setPassword(request.getParameter("upass"));
            newUser.setRole("user");

            newUser = UserDAO.registerNewUser(newUser);
            if (newUser.isValid()) {
                con.setAutoCommit(false);
                String DML = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
                pstm = con.prepareStatement(DML);
                pstm.setInt(1, newUser.getUserId());
                pstm.setString(2, newUser.getUsername());
                pstm.setString(3, newUser.getPassword());
                pstm.setString(4, newUser.getRole());
                pstm.executeUpdate();
                con.commit();
                // save username as actualUser variable
                request.getSession().setAttribute("actualUser", newUser);
                // save its role as actualUserRole
                request.getSession().setAttribute("actualUserRole", newUser.getRole());
                // create a variable to hold the authenticated user
                request.getSession().setAttribute("validUser", true);
                // delegate to JSP
                request.getRequestDispatcher("./userPage.jsp").forward(request, response);
            } else {
                if (("".equals(newUser.getUsername()))
                        || ("".equals(newUser.getPassword()))) {
                    // username or password not specified, redirect to register.jsp
                    request.setAttribute("unfilled", true);
                } else {
                    // specified username already exists, redirect to register.jsp
                    request.setAttribute("subscribed", true);
                }
                request.getSession().setAttribute("validUser", false);
                request.getRequestDispatcher("./register.jsp").forward(request, response);
            }

        } catch (IOException theException) {
            System.out.println(theException);
        } catch (SQLException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionManager.shutdown(con);
            con.rollback();
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    System.out.println("Error closing statement!");
                }
            }
            con.setAutoCommit(true);
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
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
