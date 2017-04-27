<%-- 
    Document   : adminPage
    Created on : Mar 18, 2017, 9:13:12 AM
    Author     : koss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Admin page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./CSS/newcss.css">  
        <script src="http://code.jquery.com/jquery-1.4.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#home").click(function () {
                    $('#result').load('homeLoggedIn.jsp');
                });

                $("#addnewebook").click(function () {
                    $('#result').load('addnewebook.jsp');
                });

                $("#addnewauthor").click(function () {
                    $('#result').load('addnewauthor.jsp');
                });

                $("#addrating").click(function () {
                    $('#result').load('addrating.jsp');
                });

                $("#updatetitle").click(function () {
                    $('#result').load('updatetitle.jsp');
                });

                $("#updateprice").click(function () {
                    $('#result').load('updateprice.jsp');
                });

                $("#updateauthordetails").click(function () {
                    $('#result').load('updateauthordetails.jsp');
                });

                $("#removebook").click(function () {
                    $('#result').load('removebook.jsp');
                });

                $("#removeauthor").click(function () {
                    $('#result').load('removeauthor.jsp');
                });

                $("#availablebooks").click(function () {
                    $('#result').load('availablebooks.jsp');
                });

                $("#availableauthors").click(function () {
                    $('#result').load('availableauthors.jsp');
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
                    <h4><a href="#">Add</a></h4>
                    <ul>
                        <li><a id="addnewebook" href="#">Add new eBook</a></li>
                        <li><a id="addnewauthor" href="#">Add new author</a></li>
                        <li><a id="addrating" href="#">Add rating</a></li>                        
                    </ul>                    
                </div>

                <div class="menu-item">
                    <h4><a href="#">Update</a></h4>
                    <ul>
                        <li><a id="updatetitle" href="#">Update eBook title</a></li>
                        <li><a id="updateprice" href="#">Update eBook price</a></li>
                        <li><a id="updateauthordetails" href="#">Update author details</a></li>                      
                    </ul>                    
                </div>

                <div class="menu-item">
                    <h4><a href="#">Delete</a></h4>
                    <ul>
                        <li><a id="removebook" href="#">Remove eBook</a></li>
                        <li><a id="removeauthor" href="#">Remove author</a></li>
                    </ul>                    
                </div>

                <div class="menu-item">
                    <h4><a href="#">Display</a></h4>
                    <ul>
                        <li><a id="availablebooks" href="#">Available eBooks</a></li>
                        <li><a id="availableauthors" href="#">Available authors</a></li>
                    </ul>
                </div>

                <div class="menu-item">
                    <h4><a href="./manageAccounts.jsp">Manage accounts</a></h4>                    
                </div>

                <div class="menu-item">
                    <%session.invalidate();%>
                    <h4><a href="./index.jsp">Log out</a></h4>
                </div>
            </nav>

            <article id="result" >               

                <h2>
                    eBooks vs Print &#8211; The Reasons Why Digital is Better
                </h2> 
                <h5>
                    <a href="http://goodereader.com/blog/electronic-readers/the-main-reasons-why-ebooks-are-better-than-print">Article source here</a>
                </h5>

                <p>Over the course of the last decade, eBooks have become second nature to savvy readers. 
                    Not only can you purchase them in your pajamas, 
                    but they are more economical viable than new releases that come out only in hardcover.
                    One of the big questions that readers always ask, is what are the direct benefits of reading digitally? 
                    Is there a big difference between reading in print and an eBook?
                    Today, we look the big reasons why buying an eBook makes a ton of sense.</p>
                <p><strong>Table of Contents</strong> &#8211; One of the big benefits with an eBook is a clickable TOC.
                    It makes it really easy when reading an academic or textbook to be able to quickly go to the exact 
                    page that you want, with minimal fuss.</p>
                <p><strong>Cloud Syncing</strong> &#8211; If you have a smartphone, tablet or e-reader in the household
                    and often read the same book on many different devices, cloud syncing makes things really easy. 
                    Amazon and other vendors have the ability to monitor the last page read. This insures that you will pick up 
                    exactly where you left off on a book you were reading when you were going to sleep on your e-reader
                    and then pick up where you left off on the subway with your smartphone.</p>
                <img src="./IMG/ebookvsprintbook.jpg" alt="eBooks vs. print book" style="float:right;width:640px;height:323px;">
                <p><strong>Highlights and Annotations </strong>&#8211; Writing your own notes or making highlights is ridiculously 
                    simple with an e-reader or e-reading app. Anything you do with an eBook is also synced to the cloud,
                    insuring any change will follow you, no matter what device you are on. This is especially beneficial with digital 
                    textbooks that you rent for a few weeks or a semester. The title may not be in your library anymore, 
                    after the loan period is up, but any note you make are yours to keep and is stored perpetually in the cloud.</p>
                <p>Some companies have really taken the note taking features on hardware to new and exciting levels. The Sony Digital Paper 
                    is a 13.3 inch reader, that is billed as a replacement for read paper. Instead of exclusively typing on touchscreen keyboard, 
                    like most smartphone, you use the pen to quickly draw your notes out save them as an independent file. The Galaxy Note line
                    of phones is also super solid for note taking because of the accompanied Stylus.</p>
                <p><strong>Dictionaries and Translations</strong> &#8211; When reading fiction or non-fiction title,
                    inevitability you will be unsure on the exact meaning of a word. It might be something you never heard before,
                    or may use idioms from another country. Many of the top e-readers by Amazon, Barnes and Noble, and Kobo all have dictionaries
                    pre-loaded on their devices, with the options to download additional ones, for free. If you buy an English Kindle, 
                    but want to load in a German dictionary, no problem. I also really like some of the translation software on the new Kindle Voyage,
                    you can click on a word or body of text and translate it from the language its in, to over 15 ones. Oh, 
                    you can also get diverted to Wikipedia and Google to look up a specific word too!</p>
                <p><strong>Fonts </strong>&#8211; If you have a vision deficiency and love to read, going to your bookstores 
                    large print section used to be your only option. These large font titles are really expensive too, often costing two or
                    three times that of a paperback and they are normally just available in hardcover. The benefits of eBooks is being able
                    to adjust the font on a title to your own personal preference. If you don&#8217;t like the default font eBook comes with, 
                    you can switch that too. Most e-readers and e-reading apps often have six fonts you can switch to, but Kobo goes one step 
                    further by allowing users to load in any font they want, allowing for more flexibily and control.</p>
                <p><strong>You can Loan an eBook out, and always get it back</strong> &#8211; I have six big book shelves full of books, but 
                    used to have more. I have loaned a ton of books over the years to friends who really dug what I was reading or wanted to 
                    see what all the fuss was about. I am also not ashamed to say, there were times I gave an awesome book to a girl I was sweet on,
                    only to never get them back. Amazon and Barnes and Noble developed eBook lending programs that allow you to loan an eBook
                    to a friend, one time, for up to two weeks. The only problem, is that your friend, also needs the same e-reader as you do. 
                    Many European companies sell digital books with watermarks, which makes it infinity easier to give out a copy of your book,
                    while still preserving ownership of the original.</p>
                <p>Many people in their social circle of friends are the only one with an e-reader, such as a Kindle or Nook. This makes loaning
                    out titles impossible and borrowing books super hard. A number of eBook loaning services have been developed over the years 
                    that connect readers with each other, who don&#8217;t know one another in real life. Lendle and eBook Fling are the two most popular.</p>
                <p><strong>Buy eBooks in your Pajamas</strong> &#8211; The one aspect of eBooks that I really like is being able to buy a title at any time.
                    There has been many cases where I complete an amazing book and want to see what else the author has written. 
                    In many cases at the end of the book, you can click on a series of links to bring you to whatever online bookstore
                    the author recommends to find additional titles. If the book you just read was apart of a series, you can immediately buy the next one.</p>
                <p>eBook pre-orders are proving to be fairly popular on iBooks, Kindle, Nook, Kobo or Google. You can have a book immediately sent
                    to your device at midnight, on the day of the release. Its like when new movies come out, and you can see it hours in advance 
                    if you checkout the midnight showing, its the exact same thing with digital books.</p>
                <p><strong>Fan fiction</strong> &#8211; If you grew up loving My Little Pony, GI.Joe, Harry Potter or boy bands,
                    there is fan-fiction for that. Millions of stories are available to read for free, on WattPad, Kindle Worlds or fanfiction.net.
                    Some fanfic authors have transcended their humble beginnings, such as Anna Todd and landed publishing and movie deals.
                    Incidentally, her book about a One Direction signer has had billions of reads.</p>
                <p>Fan Fiction normally flies under the radar in the standard eBook conversation, but some of the websites like WattPad do gangbuster business.
                    Readers spend two billion hours a day reading free books on their site and social media elements allow authors to converse directly 
                    with their fans to help them become better writers. Fans will frequently offer advice on serialized novels, on what they want to see, 
                    or to help in the direction of the plot. Its interactive, which is why so many people love it.</p>
                <p><strong>Beyond the Book/X-Ray</strong> &#8211; If you are like me, sometimes I find myself juggling many books at once.
                    I may begin a book and something I have been waiting for finally comes out, and I instantly switch and devour it.
                    When I come back to the original book I started, sometimes I feel lost. Sometimes names of minor characters can blur together, 
                    and I think &#8220;how was he again, whats going on?&#8221;</p>
                <p>To solve this situation Amazon developed X-Ray, which gives you a comprehensive list of all the major and minor characters 
                    in any given book. It also tells you about the locations, objects and how many times they are referrences throughout the book. 
                    No longer will readers be confused on a book they are reading, because they can easily access a small biography.</p>
                <p><strong>eBooks have less of a carbon footprint</strong> &#8211; There are 
                    <a href="http://www.theguardian.com/environment/2013/jan/06/should-i-buy-an-e-reader">higher environmental </a>costs involved
                    in manufacturing an e-reader unit, compared to a unit of paper, and there are also on-going operational effects. However, 
                    one e-reader can hold any number of eBooks, newspapers and magazines — which means that e-reader users 
                    purchase fewer printed publications. <a href="http://goodereader.com/blog/electronic-readers/are-e-readers-environmentally-friendly">
                        Producing a Kindle</a> creates the same CO2 as 30 books. So you need to read that number or more to offset the carbon emissions 
                    it takes to make it.</p>
                <p><strong>eBooks Allow you to be Anonymous</strong> &#8211; Our taste in books no longer have to be a guilty pleasure. 
                    The entire 50 Shades of Grey phenomenon showed us that many women were reading the eBook on their smartphone, tablet or e-reader
                    on public transit and they weren&#8217;t advertising what they were reading like they would a print book.
                    The social stigma of reading trashy romance, fantasy or erotica have been firmly removed with the advent of portable e-readers. 
                    Not advertising what you are reading may remove some of the public transportation flirting, but it allows you to immerse yourself 
                    in a book you love, without attracting too much attention.</p>
                <p><strong>eBooks are Cheaper</strong> &#8211; Many readers cite the price of <a href="http://goodereader.com/blog/tag/ebooks/">
                        eBooks</a> as one of the primarily aspects of why they choose to read digitally. A new report by
                    <a href="http://www.mintel.com/press-centre/technology-press-centre/e-book-boom-sparks-growth-in-brits-reading-but-what-will-the-next-chapter-bring">
                        Books and e-Books UK 2014</a> is trying to quantify the parallel between cheaper books and reading more.  Their data suggests
                    26% of consumers who have bought an eBook in the last year are reading more than they used to, because eBooks cost less
                    than paperbacks, a figure that rises to 38% of 16 to 24-year-olds.</p>

            </article>

        </div>
        <footer>
            <h4>
                Copyright &copy; kossT
            </h4>    
        </footer>
    </body>
</html>
