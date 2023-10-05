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
<h3>Khách hàng</h3>
<%--<jsp:include page="../index/index.jsp"></jsp:include>--%>
<%--<div class="container" style="width: 300px">--%>
<%--<form:form action="/khach_hang/add" method="post" modelAttribute="kh">--%>

<%--    <br>--%>
<%--    Tên:<form:input path="ten" cssClass="form-control" value="${kh.ten}"/>--%>
<%--    <br>--%>
<%--    Tên đệm:<form:input path="tenDem" cssClass="form-control" value="${kh.tenDem}"/>--%>
<%--    <br>--%>
<%--    Họ:<form:input path="ho" cssClass="form-control" value="${kh.ho}"/>--%>
<%--    <br>--%>
<%--    Giới tính:--%>
<%--    <form:radiobutton path="gioiTinh" value="true"/>Nam--%>
<%--    <form:radiobutton path="gioiTinh" value="false"/>Nữ--%>
<%--    <br>--%>
<%--    Số điện thoại:<form:input path="soDienThoai" cssClass="form-control" value="${kh.soDienThoai}"/>--%>
<%--    <br>--%>
<%--    Địa chỉ :<form:input path="diaChi" cssClass="form-control" value="${kh.diaChi}"/>--%>
<%--    <br>--%>
<%--    email:<form:input path="email" cssClass="form-control" value="${kh.email}"/>--%>

<%--    Mật khẩu:<form:input path="matKhau" cssClass="form-control" value="${kh.matKhau}"/>--%>
<%--    <br>--%>
<%--    Trạng thái:--%>
<%--    <form:radiobutton path="trangThai" value="1"/>hoạt động--%>
<%--    <form:radiobutton path="trangThai" value="0"/>Không hoạt động--%>
<%--    <br>--%>
<%--    <form:button class="btn btn-primary" type="submit">add</form:button>--%>
<%--</form:form>--%>
<%--</div>--%>
<div>
    <a href="/view_add" class="btn btn-primary">Thêm Khách Hàng</a>
</div>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Id</th>
        <th scope="col">Tên</th>
        <th scope="col">Tên Đệm</th>
        <th scope="col">Họ</th>
        <th scope="col">Giới tính</th>
        <th scope="col">SĐT</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Email</th>
        <th scope="col">Mật Khẩu</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${danhsachkh}" var="kh" varStatus="stt">
    <tr>
        <td>${stt.index+1}</td>
        <td>${kh.id}</td>
        <td>${kh.ten}</td>
        <td>${kh.tenDem}</td>
        <td>${kh.ho}</td>
        <td>${kh.gioiTinh==true? "Nam":"Nữ"}</td>
        <td>${kh.soDienThoai}</td>
        <td>${kh.diaChi}</td>
        <td>${kh.email}</td>
        <td>${kh.matKhau}</td>
        <td>${kh.trangThai==1? "hoạt động":"Không hoạt động"}</td>
        <td>
            <a class="btn btn-primary" href="/khach_hang/view_update/${kh.id}">Sửa</a>
            <a class="btn btn-primary" href="/khach_hang/delete/${kh.id}">Xóa</a>
        </td>
    </tr>
</c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="/khach_hang/hien_thi?pageNo=1">1</a></li>
        <li class="page-item"><a class="page-link" href="/khach_hang/hien_thi?pageNo=2">2</a></li>
        <li class="page-item"><a class="page-link" href="/khach_hang/hien_thi?pageNo=3">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>