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
<%--<jsp:include page="../index/index.jsp"></jsp:include>--%>
<div class="container" style="width:300px">
    <h3>Danh sách đội bóng</h3>
<form:form action="/doi_bong/add" method="post" modelAttribute="db">

    Tên:<form:input path="ten" cssClass="form-control" value="${db.ten}"/>
    <br>
    Trạng thái:
    <br>
    <form:radiobutton path="trangThai" value="1"/>còn hàng

    <form:radiobutton path="trangThai" value="0"/>hết hàng
    <br>
    <form:button  type="submit" class="btn btn-primary" style="margin-left: 100px" >Add</form:button>

</form:form>
</div>
<h6>Danh sách chất liệu</h6>
<table class="table" >
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Tên</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhsachdb}" var="db" varStatus="stt">
        <tr>

            <td>${stt.index+1}</td>
            <td>${db.ten}</td>
            <td>${db.trangThai==1? "còn hàng":"hết hàng"}</td>
            <td>
                <a class="btn btn-success" href="/doi_bong/view_update/${db.id}">Sửa</a>
                <a class="btn btn-danger" href="/doi_bong/delete/${db.id}">Xóa</a>


            </td>

        </tr>
    </c:forEach>

    </tbody>

</table>
<div class="container" style="width:300px">
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="/chat_lieu/hien_thi?pageNo=1">1</a></li>
        <li class="page-item"><a class="page-link" href="/chat_lieu/hien_thi?pageNo=2">2</a></li>
        <li class="page-item"><a class="page-link" href="/chat_lieu/hien_thi?pageNo=3">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
</nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>