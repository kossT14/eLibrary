<%-- 
    Document   : eBooksStoreMainPage.jsp
    Author     : kossT
    Copyright  : kossT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main page</title>
        <link rel="stylesheet" type="text/css" href="./css/eBooksStoreCSS.css">
    </head>
    <body>
        <c:out value="To the main page!"></c:out>
        <%-- test if a valid user is logged in --%>
        <c:choose>
            <c:when test="${validUser == true}"> <%-- if a valid user is logged then display page --%>
                <%@ include file="./eBooksStoreMenu.jsp" %>
            </c:when>
            <c:otherwise> <%-- if no valid user then open Authentication and authorization that is index.jsp  page --%>
                <c:redirect url="./index.jsp"></c:redirect>
            </c:otherwise>
        </c:choose>
    </body>
</html>
