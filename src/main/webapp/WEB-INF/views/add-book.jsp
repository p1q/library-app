<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Book</title>
</head>
<body>
<div>${errorMsg}</div>

<h3>ADD BOOK:</h3>

<form action="/book/add" method="POST">
    <table>
        <tr>
            <td>Title*</td>
            <td><input value="${title}" name="title"/></td>
        </tr>
        <tr>
            <td>Year*</td>
            <td><input value="${year}" name="year" type="number" step="1" min="0"/></td>
        </tr>
        <tr>
            <td>Price*</td>
            <td><input value="${price}" name="price" type="number" step="0.01" min="0"/></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>Author's name*</td>
            <td><input value="${name1}" name="name"/></td>
        </tr>
        <tr>
            <td>Author's surname*</td>
            <td><input value="${surname1}" name="surname"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Add book</button><br>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </td>
        </tr>

    </table>
</form>

<br />
<!-- Return to main page button -->
<form action = / method = "GET">
    <input type = "submit" value = "BACK TO HOME"/>
</form>

</body>
</html>
