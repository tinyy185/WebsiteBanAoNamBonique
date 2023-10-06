<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<form:form action="/khach_hang/add" method="post" modelAttribute="kh">

    <br>
    Tên:<form:input path="ten" cssClass="form-control" value="${kh.ten}"/>
    <br>
    Tên đệm:<form:input path="tenDem" cssClass="form-control" value="${kh.tenDem}"/>
    <br>
    Họ:<form:input path="ho" cssClass="form-control" value="${kh.ho}"/>
    <br>
    Giới tính:
    <form:radiobutton path="gioiTinh" value="true"/>Nam
    <form:radiobutton path="gioiTinh" value="false"/>Nữ
    <br>
    Số điện thoại:<form:input path="soDienThoai" cssClass="form-control" value="${kh.soDienThoai}"/>
    <br>
    Địa chỉ :<form:input path="diaChi" cssClass="form-control" value="${kh.diaChi}"/>
    <br>
    email:<form:input path="email" cssClass="form-control" value="${kh.email}"/>

    Mật khẩu:<form:input path="matKhau" cssClass="form-control" value="${kh.matKhau}"/>
    <br>
    Trạng thái:
    <form:radiobutton path="trangThai" value="1"/>hoạt động
    <form:radiobutton path="trangThai" value="0"/>Không hoạt động
    <br>
    <form:button class="btn btn-primary" type="submit">add</form:button>
</form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>