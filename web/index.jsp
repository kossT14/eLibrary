<%-- 
    Document   : index
    Created on : Mar 18, 2017, 9:13:12 AM
    Author     : koss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> e L i b r a r y</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./CSS/newcss.css">  
        <script src="http://code.jquery.com/jquery-1.4.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#home").click(function () {
                    $('#result').load('homeNotLoggedIn.jsp');
                });

                $("#availablebooks").click(function () {
                    $('#result').load('availablebooks.jsp');
                });

                $("#availableauthors").click(function () {
                    $('#result').load('availableauthors.jsp');
                });

                $("#history").click(function () {
                    $('#result').load('history.html');
                });

                $("#owners").click(function () {
                    $('#result').load('owners.html');
                });

                $("#phone").click(function () {
                    $('#result').load('phone.html');
                });

                $("#email").click(function () {
                    $('#result').load('email.html');
                });
            });
        </script>        

        <script>
            function myFunction() {
                document.getElementById("panel").style.display = "block";
            }
        </script>

        <script>
            window.location.hash = "no-back-button";
            window.location.hash = "Again-No-back-button";//again because google chrome don't insert first hash into history
            window.onhashchange = function () {
                window.location.hash = "no-back-button";
            };
        </script> 

    </head>
    <body>    
        <div style="overflow-x:auto" class="container">

            <header>
                <h1>Electronic Library</h1>
            </header>

            <nav>
                <div class="menu-item alpha">
                    <h4><a id="home" href="#">Home</a></h4>
                </div>

                <div class="menu-item">
                    <h4><a href="#">View</a></h4>
                    <ul>
                        <li><a id="availablebooks" href="#">Available eBooks</a></li>
                        <li><a id="availableauthors" href="#">Available authors</a></li>
                    </ul>
                </div>

                <div class="menu-item">
                    <h4><a href="#">About</a></h4>
                    <ul>
                        <li><a id="history" href="#">History</a></li>
                        <li><a id="owners" href="#">Meet The Owners</a></li>
                    </ul>
                </div>

                <div class="menu-item">
                    <h4><a href="#">Contact</a></h4>
                    <ul>
                        <li><a id="phone" href="#">Phone</a></li>
                        <li><a id="email" href="#">Email</a></li>
                    </ul>
                </div>
            </nav>

            <article id="article" >
                <form action="LoginServlet" method="post">
                    <fieldset style="border-spacing: 0 ">
                        <h3>
                            Log in details:
                        </h3>
                        Username:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Password:<br>
                        <input type="text" name="un" placeholder="enter username here" required>&emsp;

                        <input type="text" name="pw" placeholder="enter password here" required>
                        <br><br>
                        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;
                        <input type="reset" value="Reset" />
                        &emsp;
                        <input type="submit" name="authenticationpage_authenticate" value="Login">
                        <br><br>
                        Not yet registered? <a href="signUp.jsp">Register here!</a><br>
                    </fieldset>
                </form>

                <img src="./IMG/devices.png" alt="eBooks" style="padding-left: 4em; width: available; height: available;">

            </article>

        </div>
        <footer>
            <h4>
                Copyright &copy; kossT
            </h4>    
        </footer>
    </body>
</html>
