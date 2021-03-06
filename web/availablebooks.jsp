<%-- 
    Document   : availablebooks
    Created on : Mar 16, 2017, 11:54:31 PM
    Author     : koss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available eBooks</title>
    </head>
    <body>
        <div style="overflow-x:auto;">

            <sql:setDataSource var="snapshot" driver="org.apache.derby.jdbc.ClientDriver"
                               url="jdbc:derby://localhost:1527/EBOOKSDB"
                               user="kossT"  password="1411"/>

            <sql:query dataSource="${snapshot}" var="result">
                SELECT * FROM AUTHORS INNER JOIN EBOOK_AUT
                ON AUTHORS.AUTHOR_ID = EBOOK_AUT.AUTHOR_ID INNER JOIN 
                EBOOKS ON EBOOK_AUT.ISSN = EBOOKS.ISSN
                INNER JOIN CATEGORY ON EBOOKS.CATEGORY = CATEGORY.NAME
            </sql:query>
            

            <h2>Available eBooks:</h2>
            <br>
            <table>
                <tr>
                    <th>ISSN</th>
                    <th>Category</th>
                    <th>Title</th>
                    <th>Number of pages</th>
                    <th>Author's name</th>
                    <th>Author's surname</th>
                    <th>Price</th>
                    <th>Rating</th>                    
                </tr>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><c:out value="${row.ISSN}"/></td>
                        <td><c:out value="${row.CATEGORY}"/></td>
                        <td><c:out value="${row.TITLE}"/></td>
                        <td><c:out value="${row.NUMBER_OF_PAGES}"/></td>
                        <td><c:out value="${row.NAME}"/></td>
                        <td><c:out value="${row.SURNAME}"/></td>
                        <td><c:out value="${row.PRICE}"/></td>
                        <td><c:out value="${row.RATING}"/></td>
                    </tr> 
                </c:forEach>
            </table>
        </div>
    </body>
</html>
