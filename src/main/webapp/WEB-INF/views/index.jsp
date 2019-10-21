<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Index of Library</title>
</head>
<body>

<table border="5" >
  <tbody>
  <tr>
    <td style="text-align: center;" colspan="2">
      <h2><span style="text-decoration: underline; color: #0000ff;">
        <strong>MAIN MENU</strong></span></h2>
    </td>
  </tr>
  <tr>
    <td style="text-align: center;" colspan="2" >
      <strong>GENERAL FUNCTIONS</strong></td>
  </tr>
  <tr>
    <td style="text-align: center;" colspan="2">
      <!-- Add registration button -->
      <form action = register method = "GET">
        <input type = "submit" value = "Register"/>
      </form>
    </td>
  </tr>
  <tr style="height: 18px;">
    <td style="text-align: center;" colspan="2">
      <!-- Show all items button -->
      <form action = /show-all-books method = "GET">
        <input type = "submit" value = "Show all books"/>
      </form>
    </td>
  </tr>
  <tr style="height: 18px;">
    <td style="text-align: center;" colspan="2">
      <!-- Login button -->
      <form action = login method = "GET">
        <input type = "submit" value = "Login"/>
      </form>
    </td>
  </tr>
  <tr>
    <td style="text-align: center;" colspan="2">
      <!-- Logout button -->
      <form action = logout method = "GET">
        <input type = "submit" value = "Logout"/>
      </form>
    </td>
  </tr>
  </tbody>
</table>
</body>
</html>
