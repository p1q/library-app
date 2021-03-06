<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show All Books</title>
</head>
<body>

<div><span style="color: #ff0000;"><strong>${errorMsg}</strong></span></div>
<h3>ALL BOOKS LIST:</h3>

<table border="3">

    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Authors</th>
        <th>Year</th>
        <th>Price</th>
        <th>BOOK INFO</th>
        <th>RENT BOOK</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>
                <c:out value="${book.bookId}" />
            </td>
            <td>
                <c:out value="${book.title}" />
            </td>
            <td>
                <c:out value="${book.authors.toString()}" />
            </td>
            <td>
                <c:out value="${book.year}" />
            </td>
            <td>
                <c:out value="${book.price}" />
            </td>
            <td style="text-align: center;">
                <a href="/book/${book.bookId}">
                    <span style="color: #0000ff;"><strong>INFO</strong></span></a>
            </td>
            <td style="text-align: center;">
                <a href="/rent/rentbook?bookId=${book.bookId}">
                    <span style="color: #0000ff;"><strong>RENT</strong></span></a>
            </td>
        </tr>
    </c:forEach>

</table>

<br />
<!-- Return to main page button -->
<form action =/ method="GET">
    <input type="submit" value="BACK TO HOME"/>
</form>

</body>
</html>
