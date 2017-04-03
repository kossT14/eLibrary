<%-- 
    Document   : homeNotLoggedIn
    Created on : Mar 31, 2017, 11:15:41 PM
    Author     : koss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> e L i b r a r y</title>
        <link rel="stylesheet" type="text/css" href="./CSS/newcss.css">  
    </head>
    <body>
        <article id="result" >

            <h3> Login details: </h3>

            <form action="LoginServlet" method="post">
                <table>
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="un"></td>
                    </tr> 
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="pw"></td>
                    </tr> 
                    <tr>
                        <td><input type="reset" value="Reset" /></td>
                        <td><input type="submit" name="authenticationpage_authenticate" value="Login"></td>                            
                    </tr>
                    <tr>
                        <td colspan="2">Not yet registered! <a href="register.jsp">Register here!</a></td>
                    </tr>
                </table>
            </form>

            <img src="./IMG/devices.png" alt="eBooks" style="padding-left: 4em; width: available; height: available;">

        </article>
    </body>
</html>
