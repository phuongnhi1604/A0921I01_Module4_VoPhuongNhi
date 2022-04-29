<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 4/29/2022
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tờ khai y tế</title>
</head>
<body>
<h3 style="text-align: center">TỜ KHAI Y TẾ</h3>
<h4 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h4>
<h5 style="text-align: center; color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h5>
<form action="${pageContext.request.contextPath}/declaration/create" method="post" modelAttribute="declaration">
    <table>
        <tr>
            <td>ID</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="id"></form:input>
            </td>
        </tr>
        <tr>
            <td>Họ tên (ghi chữ IN HOA)</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="name"></form:input>
            </td>
        </tr>
        <tr>
            <td>Năm sinh</td>
            <td>Giói tính</td>
            <td>Quốc tịch</td>
        </tr>
        <tr>
            <td><form:select path="birthday_year" items="birthday_years"></form:select></td>
            <td><form:select path="gender" items="genders"></form:select></td>
            <td><form:select path="nationality" items="nationalities"></form:select></td>
        </tr>
        <tr>
            <td colspan="2">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="cmnd"></form:input>
            </td>
        </tr>
        <tr>
            <td>Thông tin đi lại</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="2"><form:radiobuttons path="vehicle" items="vehicles"></form:radiobuttons></td>
            <td></td>
        </tr>
        <tr>
            <td>Số hiệu phương tiện</td>
            <td>Số ghế</td>
            <td></td>
        </tr>
        <tr>
            <td><form:input path="number_vehicle"></form:input></td>
            <td><form:input path="number_chair"></form:input></td>
        </tr>
        <tr>
            <td colspan="2">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</td>
            <td></td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input path="city_visited"></form:input>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Gửi">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
