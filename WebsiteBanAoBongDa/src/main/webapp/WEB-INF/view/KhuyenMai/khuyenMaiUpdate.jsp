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
<form:form action="/khuyen_mai/update" method="post" modelAttribute="km">
    id:<form:input cssClass="form-controller" path="id" value="${km.id}" readonly="true"/>
    <br>
    Mã<form:input path="ma" cssClass="form-control" value="${km.ma}"/>
    <br>
    Tên:<form:input path="ten" cssClass="form-control" value="${km.ten}"/>
    <br>
    Chiết khấu:<form:input path="chietKhau"  cssClass="form-control" value="${km.chietKhau}"/>
    <br>

    Ngày bắt đầu:<form:input path="ngayBatDau" cssClass="form-control" value="${km.ngayBatDau}"/>
    <br>
    Ngày kết thúc:<form:input path="ngayKetThuc" cssClass="form-control" value="${km.ngayKetThuc}"/>
    <br>
    Trạng thái:
    <form:radiobutton path="trangThai" value="1"/>Áp dụng
    <form:radiobutton path="trangThai" value="0"/>Không áp dụng
    <br>
    <br>
    <form:button class="btn btn-primary" type="submit">update</form:button>
</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>