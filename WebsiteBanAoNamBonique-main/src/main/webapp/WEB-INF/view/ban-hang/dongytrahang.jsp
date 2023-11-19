<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Hóa Đơn Chi Tiết</title>
</head>
<body>
<style>
    /* Định dạng hộp biểu mẫu */
    form {
        width: 300px;
        margin: 0 auto;
    }

    /* Định dạng nhãn */
    label {
        display: block;
        font-weight: bold;
        margin-top: 10px;
    }

    /* Định dạng trường nhập số lượng */
    input[type="number"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-bottom: 10px;
    }

    /* Định dạng nút gửi */
    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    /* Định dạng nút gửi khi di chuột qua */
    input[type="submit"]:hover {
        background-color: #0056b3;
    }

</style>
<h1>Cập Nhật Hóa Đơn Chi Tiết</h1>

<%-- Hiển thị thông báo nếu có --%>
<c:if test="${not empty message}">
    <div style="color: green">${message}</div>
</c:if>

<%-- Hiển thị thông báo lỗi nếu có --%>
<c:if test="${not empty error}">
    <div style="color: red">${error}</div>
</c:if>

<form method="post" action="/tra-hang-kiemtra">
    <input type="text" name="hoadonchitietId" value="${hd.id}">
    <input type="number" name="quantityToSubtract" value="${hd.soLuongTra}" ><br>
    <input type="hidden" name="trangThai" value="3">
    <input type="submit" value="Đồng ý trả hàng">
</form>





<%--<form method="post" action="/update-hoadon-chitiet/${hd.id}">--%>
<%--     ID Hóa đơn--%>
<%--    <label for="hoadonchitietId">ID Hóa Đơn:</label>--%>
<%--    <input type="text" id="hoadonchitietId" name="hoadonchitietId" required><br>--%>

<%--    &lt;%&ndash; ID Chi tiết sản phẩm &ndash;%&gt;--%>
<%--    <label for="chitietsanphamId">ID Chi Tiết Sản Phẩm:</label>--%>
<%--    <input type="text" id="chitietsanphamId" name="chitietsanphamId" required><br>--%>

<%--    &lt;%&ndash; Số Lượng Trừ &ndash;%&gt;--%>
<%--    <label for="quantityToSubtract">Số Lượng Trừ:</label>--%>
<%--    <input type="text" id="quantityToSubtract" name="quantityToSubtract" required><br>--%>

<%--    &lt;%&ndash; Nút Submit &ndash;%&gt;--%>
<%--    <input type="submit" value="Cập Nhật">--%>
<%--</form>--%>
</body>
</html>
