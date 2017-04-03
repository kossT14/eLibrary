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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author koss
 */
public class LoginServlet extends HttpServlet {

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
        try {
            UserBean user = new UserBean();
            user.setUsername(request.getParameter("un"));
            user.setPassword(request.getParameter("pw"));

            user = UserDAO.login(user);

            if (user.isValid()) {
                // save username as actualUser variable
                request.getSession().setAttribute("actualUser", user);
                // save its role as actualUserRole
                request.getSession().setAttribute("actualUserRole", user.getRole());
                // create a variable to hold the authenticated user
                request.getSession().setAttribute("validUser", true);
                if (user.getRole().equalsIgnoreCase("admin")) {
                    // go to admin page if an admin is logged on
                    request.getRequestDispatcher("./adminPage.jsp").forward(request, response);
                } else {
                    // otherwise go to user page (some menu features are disabled)
                    request.getRequestDispatcher("./userPage.jsp").forward(request, response);
                }
            } else {
                response.sendRedirect("./index.jsp"); //error page 
            }
        } catch (IOException theException) {
            System.out.println(theException);
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
        return "Login servlet!";
    }// </editor-fold>

}
