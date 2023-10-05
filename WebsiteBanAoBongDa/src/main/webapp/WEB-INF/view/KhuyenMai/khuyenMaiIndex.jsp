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
<h3>Khuyến Mãi</h3>

<div>
    <a href="/khuyen_mai/view_add" class="btn btn-primary">Thêm Khuyến Mãi</a>
</div>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Id</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Chiết khấu</th>
        <th scope="col">Ngày bắt đầu</th>
        <th scope="col">Ngày kết thúc</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${danhsachkm}" var="km" varStatus="stt">
    <tr>
        <td>${stt.index+1}</td>
        <td>${km.id}</td>
        <td>${km.ma}</td>
        <td>${km.ten}</td>
        <td>${km.chietKhau}</td>
        <td>${km.ngayBatDau}</td>
        <td>${km.ngayKetThuc}</td>
        <td>${km.trangThai==1? "Áp dụng":"Không áp dụng"}</td>
        <td>
            <a class="btn btn-primary" href="/khuyen_mai/view_update/${km.id}">Sửa</a>
            <a class="btn btn-primary" href="/khuyen_mai/delete/${km.id}">Xóa</a>
        </td>
    </tr>
</c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="/khuyen_mai/hien_thi?pageNo=1">1</a></li>
        <li class="page-item"><a class="page-link" href="/khuyen_mai/hien_thi?pageNo=2">2</a></li>
        <li class="page-item"><a class="page-link" href="/khuyen_mai/hien_thi?pageNo=3">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>