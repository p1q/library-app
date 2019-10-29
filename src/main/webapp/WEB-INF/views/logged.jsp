<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login successful</title>
</head>
<body>

<h2><span style="color: #008000;">Login successful.</span></h2>
<p><strong>Username: ${username}</strong></p>
<p><strong>Roles: ${authorities}</strong></p>

<br />
<!-- Return to main page button -->
<form action = / method = "GET">
    <input type = "submit" value = "BACK TO HOME"/>
</form>

</body>
</html>
