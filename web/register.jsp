<%-- 
    Document   : register
    Created on : Mar 29, 2017, 9:11:55 PM
    Author     : koss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./CSS/newcss.css">  
        <title>Registration</title>
        <script>
            window.location.hash = "no-back-button";
            window.location.hash = "Again-No-back-button";//again because google chrome don't insert first hash into history
            window.onhashchange = function () {
                window.location.hash = "no-back-button";
            };
            if (${subscribed == 'true'}) {
                alert("Username already in use! Please choose a different one! ");
            }
            if (${unfilled == 'true'}) {
                alert("Please fill both username and password! ");
            }
        </script> 
    </head>
    <body>        
        <div>            
            <form action="RegistrationServlet" method="post">                
                <table>
                    <thead>
                        <tr>
                            <th colspan="2">Enter Information Here</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Username</td>
                            <td><input type="text" name="user" value="" /></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="pass" value="" /></td>
                        </tr>                    
                        <tr>
                            <td><input type="submit" value="Submit" /></td>
                            <td><input type="reset" value="Reset" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">Already registered! <a href="index.jsp">Login Here</a></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>