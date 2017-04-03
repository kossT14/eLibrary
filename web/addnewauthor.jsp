<%-- 
    Document   : addnewauthor
    Created on : Mar 20, 2017, 3:00:14 PM
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
        <div>
            <form action="/action_page.php">
                <fieldset>
                    <legend>Author information:</legend>
                    ID:<br>
                    <input type="text" name="id" placeholder="autogenerated">
                    <br><br>
                    Name:<br>
                    <input type="text" name="name" placeholder="Please input author's name" required>
                    <br><br>
                    Surname:<br>
                    <input type="text" name="surname" placeholder="Please input author's surname" required>
                    <br><br>
                </fieldset>
            </form>
            <form action="/action_page.php">
                <fieldset>
                    <legend>eBook information:</legend>
                    ISBN:<br>
                    <input type="text" name="isbn" placeholder="autogenerated">
                    <br><br>
                    Category:
                    <select name="cars">
                        <option value="Technical">Technical</option>
                        <option value="Novel">Novel</option>
                        <option value="Art album">Art album</option>
                    </select>
                    <br><br>
                    Title:<br>
                    <input type="text" name="title" placeholder="Please input eBook title" autofocus required>
                    <br><br>
                    Number of pages:<br>
                    <input type="text" name="noofpages" placeholder="Please input number of pages" required>
                    <br><br>
                    Price:<br>
                    <input type="text" name="price" placeholder="Please input eBook price" required>
                    <br><br>
                </fieldset>
            </form>              
            <br><br>
            <input type="submit" value="Submit" onclick="alert('New record submitted!')">
            <input type="reset" value="Reset">
        </div>
    </body>
</html>