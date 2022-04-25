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
    <style type="text/css">
      .form {
        height:130px; width:450px;
        margin:0;
        padding:10px;
        border:1px #CCC solid;
      }
      .form input {
        padding:5px; margin:5px
      }
    </style>
  </head>
  <body>
  <h2>Calculator</h2>
  <form class="form" action="/calculator" method="post">
    <table border="1">
      <tr>
        <td><input type="text" name="num1" /><br></td>
        <td><input type="text" name="num2" /><br></td>
      </tr>
      <tr>
        <td><input type = "submit" name="calculator" value = "Addition(+)"/>
        <input type = "submit" name="calculator" value = "Subtraction(-)"/></td>
        <td><input type = "submit" name="calculator" value = "Multiplication(*)"/>
       <input type = "submit" name="calculator" value = "Division(/)"/></td>
      </tr>
    </table>
  </form>
  </body>
</html>
