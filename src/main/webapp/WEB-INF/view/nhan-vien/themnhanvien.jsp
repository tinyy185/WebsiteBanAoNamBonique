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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                <li><a class="dropdown-item" href="#!">Logout</a></li>
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
                    <a class="nav-link" href="/thong-ke/doanh-thu">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Dashboard
                    </a>
                    <div class="sb-sidenav-menu-heading">Interface</div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts"
                       aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                        Thuộc tính
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="/mau-sac">Màu Sắc</a>
                            <a class="nav-link" href="/loai-san-pham">Loại Sản Phẩm</a>
                            <a class="nav-link" href="/hang-san-xuat">Nhà Sản Xuất</a>
                        </nav>
                    </div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages"
                       aria-expanded="false" aria-controls="collapsePages">
                        <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                        Pages
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapsePages" aria-labelledby="headingTwo"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                               data-bs-target="#pagesCollapseAuth" aria-expanded="false"
                               aria-controls="pagesCollapseAuth">
                                Hóa đơn
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne"
                                 data-bs-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/hoa-don">Duyệt Hóa Đơn</a>
                                    <a class="nav-link" href="">Trả Hàng</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="" data-bs-toggle="collapse"
                               data-bs-target="#pagesCollapseError" aria-expanded="false"
                               aria-controls="pagesCollapseError">
                                Khuyến Mãi
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne"
                                 data-bs-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/khuyen-mai">Thêm khuyến mãi</a>
                                    <a class="nav-link" href="/nhan-vien">Quản lí nhân viên</a>
                                    <%--                                    <a class="nav-link" href="../../view1/500.html">500 Page</a>--%>
                                </nav>
                            </div>
                        </nav>
                    </div>
                    <div class="sb-sidenav-menu-heading">Addons</div>
                    <a class="nav-link" href="/thong-ke/bieu-do">
                        <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                        Biểu đồ
                    </a>
                    <a class="nav-link" href="/chi-tiet-san-pham">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Chi tiết sản phẩm
                    </a>
                    <a class="nav-link" href="/thong-ke/theo-ngay">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Thống kê
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
                <h1 class="mt-4">Nhân viên </h1>
                <ol class="breadcrumb mb-4">
                    <%--                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>--%>
                    <li class="breadcrumb-item active">Hiển thị</li>
                </ol>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-1"></div>


                        <center>

<%--                            <form method="POST" action="/nhan-vien/update/${nhanVien.userId}">--%>
<%--                                <label >Tên Usename:</label>--%>
<%--                                <input type="text" name="userName" value="${nhanVien.userName}"/>--%>
<%--                                <br>--%>

<%--                                <label >Email:</label>--%>
<%--                                <input type="text" name="email" value="${nhanVien.email}"/>--%>
<%--                                <br>--%>

<%--                                <button type="submit">Cập nhật</button>--%>
<%--                            </form>--%>


    <div class="container">
        <form:form method="POST" action="/nhan-vien/update/${nhanVien.id}" modelAttribute="nhanVien" >
            <div class="form-group">
                <label for="userName">Username</label>
                <form:input path="userName" class="form-control" placeholder="Username" />
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="email" class="form-control"  placeholder="Email" />
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="encrytedPassword" class="form-control"  placeholder="Mật khẩu" />
            </div>

            <button type="submit" class="btn btn-primary">Cập nhật tài khoản</button>
        </form:form>
    </div>




                        </center>


                    </div>




<%--                                                <table>--%>
<%--                                                    <thead>--%>
<%--                                                    <tr>--%>
<%--                                                        <th scope="col">#</th>--%>
<%--                                                        <th scope="col">Username</th>--%>
<%--                                                        <th scope="col">Password</th>--%>
<%--                                                        <th scope="col">Email</th>--%>
<%--                                                        <th scope="col">CCCD</th>--%>
<%--                                                        <th scope="col">Fullname</th>--%>
<%--                                                        <th scope="col">Birthdate</th>--%>
<%--                                                        <th scope="col">Gender</th>--%>
<%--                                                        <th scope="col">Address</th>--%>
<%--                                                        <th scope="col">QR Code Date</th>--%>
<%--                                                        <th scope="col">Status</th>--%>
<%--                                                        <th scope="col">Actions</th>--%>
<%--                                                    </tr>--%>
<%--                                                    </thead>--%>
<%--                                                    <tbody>--%>
<%--&lt;%&ndash;                                                    <c:forEach items="${listNhanVien}" var="nv" varStatus="i">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <th scope="row">${i.count}</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.userName}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.encrytedPassword}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.email}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.cccd}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.fullname}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.birthdate}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.gender}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.addresses}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.qrcodedate}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td>${nv.trangThai.id == 1 ? "Hoạt động" : "Ngừng hoạt động"}</td>&ndash;%&gt;--%>

<%--&lt;%&ndash;                                                        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                    </c:forEach>&ndash;%&gt;--%>
<%--                                                    </tbody>--%>
<%--                                                </table>--%>



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
<script>
    const video = document.getElementById('video');
    const output = document.getElementById('output');


    let isWebcamOn = false;
    let videoElement = document.getElementById("video");

    // Hàm bật/tắt webcam
    function toggleWebcam() {
        if (isWebcamOn) {
            // Tắt webcam
            stopWebcam();
        } else {
            // Bật webcam
            startWebcam();
        }
    }

    // Hàm bật webcam
    function startWebcam() {
        navigator.mediaDevices.getUserMedia({ video: true })
            .then(function (stream) {
                videoElement.srcObject = stream;
                isWebcamOn = true;
            })
            .catch(function (error) {
                console.error("Không thể kết nối đến webcam: ", error);
                isWebcamOn = false;
            });
    }

    // Hàm tắt webcam
    function stopWebcam() {
        let stream = videoElement.srcObject;
        if (stream) {
            let tracks = stream.getTracks();
            tracks.forEach(function (track) {
                track.stop();
            });
            videoElement.srcObject = null;
            isWebcamOn = false;
        }
    }

    // Hàm chụp ảnh từ webcam
    function capture() {
        // Kiểm tra nếu webcam đang tắt, thì bật nó trước khi chụp ảnh
        if (!isWebcamOn) {
            startWebcam();
        }

        // Tạo canvas để lưu trữ ảnh từ video
        const canvas = document.createElement('canvas');
        canvas.width = video.videoWidth;
        canvas.height = video.videoHeight;
        const ctx = canvas.getContext('2d');


        // Vẽ frame hiện tại từ video lên canvas
        ctx.drawImage(video, 0, 0, canvas.width, canvas.height);

        // Chuyển canvas thành file image và gửi lên server
        canvas.toBlob((blob) => {
            const formData = new FormData();
            formData.append('file', blob, 'qrcode.png');

            fetch('/decode', {
                method: 'POST',
                body: formData,
            })
                .then(response => response.json())
                .then(data => {
                    if (data.text) {
                        output.textContent = 'Kết quả đọc mã QR: ' + data.text;
                    } else {
                        output.textContent = 'Không tìm thấy mã QR hoặc lỗi đọc mã.';
                    }
                })
                .catch(error => {
                    output.textContent = 'Đã có lỗi xảy ra khi gửi yêu cầu lên server.';
                });
        }, 'image/png');
    }


    function addToSql() {

        // Lấy dữ liệu từ thẻ <div>

        const outputDiv = document.getElementById('output');
        const qrData = outputDiv.textContent.split(': ')[1];

        // Tạo đối tượng JSON từ dữ liệu
        const qrCodeDataObj = {
            cccd: qrData.split('|')[0],
            code: qrData.split('|')[1],
            fullname: qrData.split('|')[2],
            birthdate: qrData.split('|')[3],
            gender: qrData.split('|')[4],
            addresses: qrData.split('|')[5],
            qrcodedate: qrData.split('|')[6]
        };

        fetch('/addToSql', {
            method: 'POST',
            body: JSON.stringify(qrCodeDataObj),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(data => {
                if (data.success === "true") {
                    // Nếu thành công, tải lại trang
                    window.location.reload();
                } else {
                    // Xử lý lỗi nếu cần thiết
                    // ...
                }
            })
            .catch(error => {
                // Xử lý lỗi nếu cần thiết
                // ...
            });
    }
  stopWebcam();

</script>

<script src="../../../bootrap/js/scripts.js"></script>
</body>
</html>
