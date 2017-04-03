<%-- 
    Document   : removeauthor
    Created on : Mar 20, 2017, 3:01:16 PM
    Author     : koss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="overflow-x:auto;">
            <h2>Available authors:</h2>
                <br>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th style="color: red">Selection</th>
                        <th style="color: red">Submit change</th>
                    </tr>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Surname</td>
                        <td><label><input type="checkbox" name="checkbox" value="value"></label></td>
                        <td><input type="submit" value="Remove" onclick="alert('Author removed!')"></td>
                    </tr> 
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Surname</td>
                        <td><label><input type="checkbox" name="checkbox" value="value"></label></td>
                        <td><input type="submit" value="Remove" onclick="alert('Author removed!')"></td>
                    </tr>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Surname</td>
                        <td><label><input type="checkbox" name="checkbox" value="value"></label></td>
                        <td><input type="submit" value="Remove" onclick="alert('Author removed!')"></td>
                    </tr>
            </table>
        </div>
    </body>
</html>
