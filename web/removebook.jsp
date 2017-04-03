<%-- 
    Document   : removebook
    Created on : Mar 20, 2017, 3:02:08 PM
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
            <h2>Available eBooks:</h2>
            <br>
            <table>
                <tr>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Number of pages</th>
                    <th>Author(s)</th>
                    <th>Rating</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th style="color: red">Selection</th>
                    <th style="color: red">Submit change</th>
                </tr>
                <tr>
                    <td>ISBN</td>
                    <td>Title</td>
                    <td>Number of pages</td>
                    <td>Author(s)</td>
                    <td>Rating</td>
                    <td>Description</td>
                    <td>Price</td>
                    <td><label><input type="checkbox" name="checkbox" value="value"></label></td>
                    <td><input type="submit" value="Remove" onclick="alert('eBook removed!')"></td>
                </tr> 
                <tr>
                    <td>ISBN</td>
                    <td>Title</td>
                    <td>Number of pages</td>
                    <td>Author(s)</td>
                    <td>Rating</td>
                    <td>Description</td>
                    <td>Price</td>
                    <td><label><input type="checkbox" name="checkbox" value="value"></label></td>
                    <td><input type="submit" value="Remove" onclick="alert('eBook removed!')"></td>
                </tr>
                <tr>
                    <td>ISBN</td>
                    <td>Title</td>
                    <td>Number of pages</td>
                    <td>Author(s)</td>
                    <td>Rating</td>
                    <td>Description</td>
                    <td>Price</td>
                    <td><label><input type="checkbox" name="checkbox" value="value"></label></td>
                    <td><input type="submit" value="Remove" onclick="alert('eBook removed!')"></td>
                </tr>
            </table>
        </div>
    </body>
</html>
