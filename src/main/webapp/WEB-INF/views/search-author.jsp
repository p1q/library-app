<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Book Search By Author</title>
</head>
<body>

<!-- Title -->
<h3>BOOK SEARCH BY AUTHOR</h3>

<!-- Book Search Form -->
<form action = "/book/found-author" method = "POST">
    <table border = "3">

        <tr>
            <td><b>Enter an author:</b></td>
            <td><input type = "text" name = "searchString" size = "20"/></td>
        </tr>

        <tr>
            <td colspan = "2"><input type = "submit" value = "Search"/></td>
        </tr>
    </table>
</form>
<!-- End of item adding form -->

<br />
<!-- Return to main page button -->
<form action = / method = "GET">
    <input type = "submit" value = "BACK TO HOME"/>
</form>

</body>
</html>
