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

    <h3>them chi tiet san pham</h3>
    <form:form action="/chi_tiet_sp/add" method="post" modelAttribute="ctsp">

<%--        id:<form:input path="id" cssClass="form-control" value="${ctsp.id}" readonly="true"/>--%>
<%--        <br>--%>

        Sản phẩm: <form:select cssClass="form-select" path="idSanPham" value="${ctsp.idSanPham.ten}">
        <c:forEach items="${danhsachsp}" var="sp">
            <form:option value="${sp.id}">${sp.ten}</form:option>
        </c:forEach>
    </form:select>
        <br>
        Hãng:  <form:select cssClass="form-select" path="idHang" value="${ctsp.idHang.ten}">
            <c:forEach items="${danhsachhang}" var="hang">
                <form:option value="${hang.id}">${hang.ten}</form:option>
            </c:forEach>
        </form:select>
        <br>

         màu sắc: <form:select cssClass="form-select" path="idMauSac" value="${ctsp.idMauSac.ten}">
        <c:forEach items="${danhsachms}" var="ms">
            <form:option value="${ms.id}">${ms.ten}</form:option>
        </c:forEach>
    </form:select>
        <br>
       Kích cỡ: <form:select cssClass="form-select" path="idKichCo" value="${ctsp.idKichCo.ten}">
        <c:forEach items="${danhsachkc}" var="kc">
            <form:option value="${kc.id}">${kc.ten}</form:option>
        </c:forEach>
    </form:select>
        <br>
       Chất liệu: <form:select cssClass="form-select" path="idChatLieu" value="${ctsp.idChatLieu.ten}">
        <c:forEach items="${danhsachcl}" var="cl">
            <form:option value="${cl.id}">${cl.ten}</form:option>
        </c:forEach>
    </form:select>
        <br>
       Loại: <form:select cssClass="form-select" path="idLoai" value="${ctsp.idLoai.ten}">
        <c:forEach items="${danhsachloai}" var="loai">
            <form:option value="${loai.id}">${loai.ten}</form:option>
        </c:forEach>
    </form:select>
        <br>
        Tên cầu thủ: <form:select cssClass="form-select" path="idTenCauThu" value="${ctsp.idTenCauThu.ten}">
        <c:forEach items="${danhsachtct}" var="tct">
            <form:option value="${tct.id}">${tct.ten}</form:option>
        </c:forEach>
    </form:select>
        <br>
        Đội bóng: <form:select cssClass="form-select" path="IdDoiBong" value="${ctsp.idDoiBong.ten}">
        <c:forEach items="${danhsachdb}" var="db">
            <form:option value="${db.id}">${db.ten}</form:option>
        </c:forEach>
    </form:select>
        <br>
       Số áo: <form:select cssClass="form-select" path="IdSoAo" value="${ctsp.idSoAo.ten}">
        <c:forEach items="${danhsachsa}" var="sa">
            <form:option value="${sa.id}">${sa.ten}</form:option>
        </c:forEach>
    </form:select>
        <br>
       ảnh: <form:select cssClass="form-select" path="idAnh" value="${ctsp.idAnh.ten}">
        <c:forEach items="${danhsachanh}" var="anh">
            <form:option value="${anh.id}">${anh.ten}</form:option>
        </c:forEach>
    </form:select>
       Tên:<form:input path="ten" cssClass="form-control" value="${ctsp.ten}"/>
        <br>
        Giá:<form:input path="gia" cssClass="form-control" value="${ctsp.gia}"/>
        <br>
        Số lượng tồn:<form:input path="soLuongTon" cssClass="form-control" value="${ctsp.soLuongTon}"/>
        <form:errors path="soLuongTon"/>
        <br>
        giá nhập:<form:input path="ngayNhap" cssClass="form-control" value="${ctsp.ngayNhap}"/>
        <form:errors path="ngayNhap"/>
        <br>
        <form:radiobutton path="trangThai" value="1"/>còn hàng

        <form:radiobutton path="trangThai" value="0"/>hết hàng
        <br>
        <form:button  type="submit" class="btn btn-primary" style="margin-left: 100px" >Add</form:button>

    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>