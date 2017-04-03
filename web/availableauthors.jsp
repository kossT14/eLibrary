<%-- 
    Document   : availableauthors
    Created on : Mar 17, 2017, 4:30:51 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <div style="overflow-x:auto;">
            
            <sql:setDataSource var="snapshot" driver="org.apache.derby.jdbc.ClientDriver"
                               url="jdbc:derby://localhost:1527/EBOOKSDB"
                               user="kossT"  password="1411"/>

            <sql:query dataSource="${snapshot}" var="result">
                SELECT * from AUTHORS
            </sql:query>
                
            <h2>Available authors:</h2>
                <br>
                <table>
                    <tr>
                        <th>Selection</th>
                        <th>Author_ID</th>
                        <th>Name</th>
                        <th>Surname</th>
                    </tr>
                    <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><label><input type="checkbox" name="checkbox" value="value"></label></td>
                        <td><c:out value="${row.AUTHOR_ID}"/></td>
                        <td><c:out value="${row.NAME}"/></td>
                        <td><c:out value="${row.SURNAME}"/></td>                        
                    </tr> 
                    </c:forEach>
            </table>
        </div>
    </body>
</html>




