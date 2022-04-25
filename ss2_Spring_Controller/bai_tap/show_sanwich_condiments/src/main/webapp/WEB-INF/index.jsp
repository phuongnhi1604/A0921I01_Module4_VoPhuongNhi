<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 4/23/2022
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
  </head>
  <body>
  <h2>Sandwich Condiments</h2>
  <form action="/save" method="get">
    <table border="1">
      <tr>
        <td style="background-color: green"><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
        <td style="background-color: chocolate"><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
        <td style="background-color: blueviolet"><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
        <td style="background-color: yellow"><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
      </tr>
    </table>
    <input style="margin-top: 10px" type="submit" value="Order">
  </form>
  </body>
</html>
