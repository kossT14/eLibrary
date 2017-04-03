<%-- 
    Document   : addrating
    Created on : Mar 20, 2017, 2:56:27 PM
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
                        <th style="color: red">Current rating</th>
                        <th style="color: red">New rating</th>
                        <th style="color: red">Current description</th>
                        <th style="color: red">New description</th>
                        <th>Price</th>
                        <th style="color: red">Submit change</th>
                    </tr>
                    <tr>
                        <td>ISBN</td>
                        <td>Title</td>
                        <td>Number of pages</td>
                        <td>Author(s)</td>
                        <td>Rating</td>
                        <td><label><input type="text" name="newrating" placeholder="input new rating"></label></td>
                        <td>Description</td>
                        <td><label><input type="text" name="newdescription" placeholder="input new description"></label></td>
                        <td>Price</td>
                        <td><input type="submit" value="Submit" onclick="alert('Rating updated!')"></td>
                    </tr> 
                    <tr>
                        <td>ISBN</td>
                        <td>Title</td>
                        <td>Number of pages</td>
                        <td>Author(s)</td>
                        <td>Rating</td>
                        <td><label><input type="text" name="newrating" placeholder="input new rating"></label></td>
                        <td>Description</td>
                        <td><label><input type="text" name="newdescription" placeholder="input new description"></label></td>
                        <td>Price</td>
                        <td><input type="submit" value="Submit" onclick="alert('Rating updated!')"></td>
                    </tr>
                    <tr>
                        <td>ISBN</td>
                        <td>Title</td>
                        <td>Number of pages</td>
                        <td>Author(s)</td>
                        <td>Rating</td>
                        <td><label><input type="text" name="newrating" placeholder="input new rating"></label></td>
                        <td>Description</td>
                        <td><label><input type="text" name="newdescription" placeholder="input new description"></label></td>
                        <td>Price</td>
                        <td><input type="submit" value="Submit" onclick="alert('Rating updated!')"></td>
                    </tr>
                </table>
        </div>
    </body>
</html>
