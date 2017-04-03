<%-- 
    Document   : updateauthordetails
    Created on : Mar 20, 2017, 3:03:15 PM
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
                    <th>Current name</th>
                    <th style="color: red">New name</th>
                    <th>Current surname</th>
                    <th style="color: red">New surname</th>
                    <th style="color: red">Submit change</th>
                </tr>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td><label><input type="text" name="newname" placeholder="input new name"></label></td>
                    <td>Surname</td>
                    <td><label><input type="text" name="newsurname" placeholder="input new surname"></label></td>
                    <td><input type="submit" value="Submit" onclick="alert('Author details updated!')"></td>
                </tr> 
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td><label><input type="text" name="newname" placeholder="input new name"></label></td>
                    <td>Surname</td>
                    <td><label><input type="text" name="newsurname" placeholder="input new surname"></label></td>
                    <td><input type="submit" value="Submit" onclick="alert('Author details updated!')"></td>
                </tr> 
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td><label><input type="text" name="newname" placeholder="input new name"></label></td>
                    <td>Surname</td>
                    <td><label><input type="text" name="newsurname" placeholder="input new surname"></label></td>
                    <td><input type="submit" value="Submit" onclick="alert('Author details updated!')"></td>
                </tr> 
            </table>
        </div>
    </body>
</html>
