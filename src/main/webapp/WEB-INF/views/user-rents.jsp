<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show All User's Active Rents</title>
</head>
<body>
<h3>ALL YOUR ACTIVE RENTS LIST:</h3>

<table border="3">

    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Book</th>
        <th>Status</th>
        <th>RETURN BOOK</th>
    </tr>
    <c:forEach var="rent" items="${rents}">
        <tr>
            <td>
                <c:out value="${rent.rentId}" />
            </td>
            <td>
                <c:out value="${rent.rentDate}" />
            </td>
            <td>
                <c:out value="${rent.book.toString()}" />
            </td>
            <td>
                <c:out value="${rent.active ? 'ACTIVE' : 'RETURNED'}" />
            </td>
            <td style="text-align: center;">
                <a href="/rent/returnbook?bookId=${rent.book.bookId}">
                    <span style="color: #0000ff;"><strong>RETURN</strong></span></a>
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
