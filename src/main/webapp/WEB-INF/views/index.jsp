<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Index of Library</title>
</head>
<body>

<p><span style="color: #0000ff;"><strong>${message}</strong></span></p>
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
      <!-- Add book button -->
      <form action = /book/add method = "GET">
        <input type = "submit" value = "Add book"/>
      </form>
    </td>
  </tr>
  <tr style="height: 18px;">
    <td style="text-align: center;" colspan="2">
      <!-- Find book by title button -->
      <form action = /book/search method = "GET">
        <input type = "submit" value = "Find book by title"/>
      </form>
    </td>
  </tr>
  <tr style="height: 18px;">
    <td style="text-align: center;" colspan="2">
      <!-- Show all books button -->
      <form action = /book/all method = "GET">
        <input type = "submit" value = "Show all books"/>
      </form>
    </td>
  </tr>
  <tr style="height: 18px;">
    <td style="text-align: center;" colspan="2">
      <!-- Show all rents button -->
      <form action = /rent/all-rents method = "GET">
        <input type = "submit" value = "Show all rents"/>
      </form>
    </td>
  </tr>
  <tr style="height: 18px;">
    <td style="text-align: center;" colspan="2">
      <!-- Show user rents button -->
      <form action = /rent/user-rents method = "GET">
        <input type = "submit" value = "Show user's rents"/>
      </form>
    </td>
  </tr>
  <tr style="height: 18px;">
    <td style="text-align: center;" colspan="2">
      <!-- Show all books rented by user button -->
      <form action = /rent/rented-users-books method = "GET">
        <input type = "submit" value = "Show user's rented books"/>
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
  <tr>
    <td style="text-align: center;" colspan="2">
      <!-- Inject Demo Data -->
      <form action = /inject/data method = "GET">
        <input type = "submit" value = "Inject Data"/>
      </form>
    </td>
  </tr>
  </tbody>
</table>
</body>
</html>
