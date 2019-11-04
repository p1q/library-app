<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Registration failed</title>
</head>
<body>

<h2><span style="color: #ff0000;">Registration failed!</span></h2>
<h4>Please fix these errors:</h4>

<ul style="list-style-type: disc;">
    <c:forEach var="error" items="${errors}">
        <li>
            <c:out value="${error}" />
        </li>
    </c:forEach>
</ul>

<br />
<!-- Return to main page button -->
<form action = / method = "GET">
    <input type = "submit" value = "BACK TO HOME"/>
</form>

</body>
</html>
