/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Author;
import beans.ConnectionManager;
import beans.Ebook;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gheor
 */
public class AddNewEbookAndAuthorServlet extends HttpServlet {

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
        PreparedStatement pstm1, pstm2, pstm3;

        Ebook newEbook = new Ebook();
        newEbook.setISSN(request.getParameter("eb_issn"));
        newEbook.setTitle(request.getParameter("eb_title"));
        newEbook.setNoOfPages(Integer.parseInt(request.getParameter("eb_noofpages")));
        newEbook.setPrice(Double.parseDouble(request.getParameter("eb_price")));
        newEbook.setCategory(request.getParameter("eb_category"));

        Author newAuthor = new Author();
        newAuthor.setAuthorId(Integer.parseInt(request.getParameter("author_id")));
        newAuthor.setName(request.getParameter("author_name"));
        newAuthor.setSurname(request.getParameter("author_surname")); 
        
        Map<String, String> book_errors = newEbook.validate(newEbook);
        Map<String, String> aut_errors = newAuthor.validate(newAuthor);
        if (book_errors.isEmpty() && aut_errors.isEmpty()) {
            con.setAutoCommit(false);
            String DML1 = "INSERT INTO EBOOKS VALUES (?, ?, ?, ?, ?, ?)";
            pstm1 = con.prepareStatement(DML1);
            pstm1.setString(1, newEbook.getISSN());
            pstm1.setString(2, newEbook.getTitle());
            pstm1.setString(3, newEbook.getCategory());
            pstm1.setInt(4, newEbook.getNoOfPages());
            pstm1.setDouble(5, newEbook.getRating());
            pstm1.setDouble(6, newEbook.getPrice());
            pstm1.executeUpdate();
            con.commit();

            con.setAutoCommit(false);
            String DML2 = "INSERT INTO AUTHORS VALUES (?, ?, ?)";
            pstm2 = con.prepareStatement(DML2);
            pstm2.setInt(1, newAuthor.getAuthorId());
            pstm2.setString(2, newAuthor.getName());
            pstm2.setString(3, newAuthor.getSurname());
            pstm2.executeUpdate();
            con.commit();

            con.setAutoCommit(false);
            String DML3 = "INSERT INTO EBOOK_AUT VALUES (?, ?)";
            pstm3 = con.prepareStatement(DML3);
            pstm3.setString(1, newEbook.getISSN());
            pstm3.setInt(2, newAuthor.getAuthorId());
            pstm3.executeUpdate();
            con.commit();
                              
            request.getRequestDispatcher("./adminPage.jsp").forward(request, response);
        } else {
            for (Map.Entry<String, String> error : book_errors.entrySet()) {
                request.setAttribute(error.getKey(), error.getValue());
            }
            for (Map.Entry<String, String> error : aut_errors.entrySet()) {
                request.setAttribute(error.getKey(), error.getValue());
            }
            String referrer1 = request.getParameter("add_book");
            String referrer2 = request.getParameter("add_author");
            if (referrer1.equalsIgnoreCase("add_book")) {
                request.getRequestDispatcher("./addnewebook.jsp").forward(request, response); //return to add new eBook page
            } else {
                if (referrer2.equalsIgnoreCase("add_author")) {
                    request.getRequestDispatcher("./addnewauthor.jsp").forward(request, response); //return to add new author page
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
            Logger.getLogger(AddNewEbookAndAuthorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddNewEbookAndAuthorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet serves eBooksSoreAdminEBooks.JSP page";
    }// </editor-fold>

}
