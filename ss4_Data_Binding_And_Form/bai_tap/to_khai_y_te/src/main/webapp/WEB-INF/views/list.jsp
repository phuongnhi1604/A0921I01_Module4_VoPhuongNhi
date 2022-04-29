<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 4/29/2022
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Danh sách tờ khai</h3>
<a href="/declaration/create">Tạo tờ khai</a>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Họ tên</td>
        <td>Năm sinh</td>
        <td>Giới tính</td>
        <td>Quốc tịch</td>
        <td>Số hộ chiếu/CMND</td>
        <td>Thông tin đi lại</td>
        <td>Số hiệu phương tiện</td>
        <td>Số ghế</td>
        <td>Tỉnh/Thành phố đã đi</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${declarations}" var="declaration">
        <tr>
            <td>${declaration.id}</td>
            <td>${declaration.name}</td>
            <td>${declaration.birthday_year}</td>
            <td>${declaration.gender}</td>
            <td>${declaration.nationality}</td>
            <td>${declaration.cmnd}</td>
            <td>${declaration.vehicle}</td>
            <td>${declaration.number_vehicle}</td>
            <td>${declaration.number_chair}</td>
            <td>${declaration.city_visited}</td>
            <td><a href="/declaration/view/${declaration.id}">View</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
