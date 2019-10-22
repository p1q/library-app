<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show Book Info</title>
</head>
<body>

<table border="5">
    <tbody>
    <tr>
        <td style="text-align: center;" colspan="2">
            <h3><span style="color: #0000ff;"><strong>BOOK INFO</strong></span></h3>
        </td>
    </tr>
    <tr>
        <td><strong>ID</strong></td>
        <td>${book.bookId}</td>
    </tr>
    <tr>
        <td><strong>Title</strong></td>
        <td>${book.title}</td>
    </tr>
    <tr>
        <td><strong>Authors</strong></td>
        <td>${book.authors.toString()}</td>
    </tr>
    <tr>
        <td><strong>Year</strong></td>
        <td>${book.year}</td>
    </tr>
    <tr>
        <td><strong>Price</strong></td>
        <td>${book.price}</td>
    </tr>
    <tr>
        <td><strong>Available for Rent</strong></td>
        <td>${active}</td>
    </tr>
    </tbody>
</table>

<br />
<!-- Return to main page button -->
<form action =/ method="GET">
    <input type="submit" value="BACK TO HOME"/>
</form>

</body>
</html>
