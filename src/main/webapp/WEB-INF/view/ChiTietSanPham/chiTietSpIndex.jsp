<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body >
<%--<jsp:include page="../index/index.jsp"></jsp:include>--%>
<div class="container" style="width:300px">
    <h4 >chi tiet san pham</h4>
</div>

<div class="container">
    <a class="btn btn-primary" href="/View_add"> them chi tiet san pham</a>
</div>

<h6>danh sach chi tiet san pham</h6>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Sản phẩm</th>
        <th scope="col">Hãng</th>
        <th scope="col">Màu sắc</th>
        <th scope="col">Kích cỡ</th>
        <th scope="col">Chất liệu</th>
        <th scope="col">Loại</th>
        <th scope="col">Tên cầu thủ</th>
        <th scope="col">Đội bóng</th>
        <th scope="col">Số áo</th>
        <th scope="col">ảnh</th>
        <th scope="col">Tên</th>
        <th scope="col">Giá</th>
        <th scope="col">số lượng tồn</th>
        <th scope="col">giá nhập</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${danhsach}" var="ctsp" varStatus="stt">
            <tr>
                <td>${stt.index+1}</td>
                <td>${ctsp.idSanPham.ten}</td>
                <td>${ctsp.idHang.ten}</td>
                <td>${ctsp.idMauSac.ten}</td>
                <td>${ctsp.idKichCo.ten}</td>
                <td>${ctsp.idChatLieu.ten}</td>
                <td>${ctsp.idLoai.ten}</td>
                <td>${ctsp.idTenCauThu.ten}</td>
                <td>${ctsp.idDoiBong.ten}</td>
                <td>${ctsp.idSoAo.ten}</td>
                <td>${ctsp.idAnh.ten}</td>
                <td>${ctsp.ten}</td>
                <td>${ctsp.gia}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.gianhap}</td>
                <td>${ctsp.trangThai==1? "còn hàng":"hết hàng"}</td>
                <td>
                    <a class="btn btn-warning" href="/chi_tiet_sp/detail/${ctsp.id}">detail</a>
                    <a class="btn btn-success" href="/chi_tiet_sp/detail/${ctsp.id}">sua</a>
                    <a class="btn btn-danger" href="/chi_tiet_sp/delete/${ctsp.id}">xoa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>
<div class="container" style="width:300px">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/chi_tiet_sp/hien_thi?pageNo=1">1</a></li>
            <li class="page-item"><a class="page-link" href="/chi_tiet_sp/hien_thi?pageNo=2">2</a></li>
            <li class="page-item"><a class="page-link" href="/chi_tiet_sp/hien_thi?pageNo=3">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>