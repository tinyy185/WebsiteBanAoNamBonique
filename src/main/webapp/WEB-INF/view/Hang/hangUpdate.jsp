<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

<div class="container" style="width:300px">
    <h3>Sửa Hạng</h3>
    <form:form action="/hang/update" method="post" modelAttribute="hang">
        Tên:<form:input path="id" cssClass="form-control" value="${hang.id}" readonly="true"/>
        <br>
        Tên:<form:input path="ten" cssClass="form-control" value="${hang.ten}"/>
        <br>
        Trạng thái:
        <form:radiobutton path="trangThai" value="1"/>hoạt động
        <form:radiobutton path="trangThai" value="0"/>Không hoạt động
        <br>
        <form:button  type="submit" class="btn btn-primary" style="margin-left: 100px" >Update</form:button>

    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>