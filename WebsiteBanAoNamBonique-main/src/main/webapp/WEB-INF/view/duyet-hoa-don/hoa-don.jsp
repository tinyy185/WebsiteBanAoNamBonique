<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Static Navigation - SB Admin</title>
    <link href="../../../bootrap/css/styles.css" rel="stylesheet"/>
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
            class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
        <div class="input-group">
            <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..."
                   aria-describedby="btnNavbarSearch"/>
            <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
        </div>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#!">Settings</a></li>
                <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                <li>
                    <hr class="dropdown-divider"/>
                </li>
                <li><a class="dropdown-item" href="/login">Logout</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Core</div>
                    <a class="nav-link" href="/hoa-don">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Dashboard
                    </a>
                    <div class="sb-sidenav-menu-heading">Interface</div>
                    <div class="collapse" id="collapsePages" aria-labelledby="headingTwo"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                               data-bs-target="#pagesCollapseAuth" aria-expanded="false"
                               aria-controls="pagesCollapseAuth">
                                Hóa đơn
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                        </nav>
                    </div>

                    <a class="nav-link" href="/hoa-don">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Duyệt hóa đơn
                    </a>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                Start Bootstrap
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Quản lí hóa đơn</h1>
                <ol class="breadcrumb mb-4">
                    <%--                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>--%>
                    <li class="breadcrumb-item active">Hiển Thị</li>
                </ol>
                <div class="container-fluid">

                    <div class="row">
                        <div class="col-1"></div>
                        <div class="col-10">

                            <form >
                                <div>
                                    <label class="form-label">Tìm kếm</label>
                                    <input type="text" class="form-control" placeholder="Tìm kiếm" name="diaChiOrSdt"
                                           value="${param.diaChiOrSdt}">
                                    <br>
                                    <button type="submit" class="btn btn-success">Search</button>
                                    <br>
                                </div>
                            </form>
                            <br>
                            <c:if test="${not empty successMessage}">
                                <div class="alert alert-success">
                                        ${successMessage}
                                </div>

                            </c:if>

                                <div class="row justify-content-center">
                                    <div class="col-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <table class="table  table-sm table-hover ">
                                                    <thead>
                                                    <tr>
                                                        <th scope="col">TÊN</th>
                                                        <th scope="col">SDT</th>
                                                        <th scope="col">ĐỊA CHỈ</th>
                                                        <th scope="col">NGÀY ĐẶT</th>
                                                        <th scope="col">NGÀY NHẬN</th>
                                                        <th scope="col">TỔNG TIỀN</th>
                                                        <th scope="col">TRẠNG THÁI</th>
                                                        <th scope="col">CHỨC NĂNG</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${hoaDon}" var="hd">
                                                        <tr>
                                                            <td>${hd.userId.userName}</td>
                                                            <td>${hd.sdt}</td>
                                                            <td>${hd.diaChi}</td>
                                                            <td>${hd.ngayDat}</td>
                                                            <td>${hd.ngayKhachNhan == null ? "Chưa nhận hàng": hd.ngayKhachNhan}</td>
                                                            <td>${hd.tongTien}</td>
                                                            <td>${hd.idTT.ten}</td>
                                                            <td>
                                                                <a href="/hoa-don/duyet/${hd.id}" class="btn btn-danger ${hd.idTT.ten eq 'Đã nhận hàng' ? 'disabled' : ''}">Xác nhận</a>
                                                                <a href="/hoa-don/da-nhan/${hd.id}" class="btn btn-warning ${hd.idTT.ten eq 'Chờ xác nhận' ? 'disabled' : ''}">Đã nhận hàng</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                        </div>
                    </div>
                    <div class="col-1"></div>
                </div>
            </div>
        </main>

        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; Your Website 2023</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>


<style>

    .form-container {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f9f9f9;
    }

    .form-container label {
        display: block;
        margin-bottom: 10px;
    }

    .form-container input[type="text"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-bottom: 10px;
    }

    .form-container button[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .form-container button[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="../../../bootrap/js/scripts.js"></script>
</body>
</html>
