<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 4/23/2022
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h2>Calculator</h2>
  <form action="/calculator" method="post">
    <table>
      <tr>
        <td><input type="text" name="num1" /><br></td>
        <td><input type="text" name="num2" /><br></td>
      </tr>
      <tr>
        <td><input type = "submit" name="calculator" value = "Addition(+)"/></td>
        <td><input type = "submit" name="calculator" value = "Subtraction(-)"/></td>
        <td><input type = "submit" name="calculator" value = "Multiplication(*)"/></td>
        <td><input type = "submit" name="calculator" value = "Division(/)"/></td>
      </tr>
    </table>
  </form>
  </body>
</html>
