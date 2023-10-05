<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

    <title>Existing Login Form a Flat Responsive Widget Template :: W3layouts</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords"
          content="Existing Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <link href="../../../css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="../../../css/style.css" type="text/css" media="all">
    <link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
</head>
<body>

<h1 style="font-weight: bold">Bán Quần Áo</h1>

<div class="w3layoutscontaineragileits">
    <h2>Đăng kí tài khoản</h2>

    		<c:if test="${not empty successMessage}">
    			<div class="alert alert-success">
    					${successMessage}
    			</div>
    		</c:if>

    <form:form method="post" action="/dang-ky">
        <div class="form-sub-w3ls">
            <input type="text" name="ten" placeholder="Họ và tên"><br>
            <div class="icon-agile">
                <i class="fa fa-user" aria-hidden="true"></i>
            </div>
        </div>
        <div class="form-sub-w3ls">
            <input type="text" name="email" placeholder="Email"/> <br>
            <div class="icon-agile">
                <i class="fa fa-envelope-o" aria-hidden="true"></i>
            </div>
        </div>
        <div class="form-sub-w3ls">
            <input type="text" name="matKhau" class="form-control" placeholder="Mật khẩu"/> <br>

            <div class="icon-agile">
                <i class="fa fa-unlock-alt" aria-hidden="true"></i>
            </div>
        </div>

        <div class="login-check">
            <label class="checkbox" style="color:white;"><input type="checkbox" name="checkbox" checked="">I Accept Terms &
                Conditions</label>
        </div>
        <div class="submit-w3l">
            <button type="submit" class="btn btn-primary">Đăng kí tài khoản</button>
            <br>
            <p> Quay lại về đăng nhập <span>→</span> <a href="/login">Bấm vào đây ! </a></p>
        </div>
        <br>
    </form:form>
</div>

<div id="small-dialog1" class="mfp-hide">
    <div class="contact-form1">
        <div class="contact-w3-agileits">


        </div>
    </div>
</div>
<!-- //for register popup -->

<div class="w3footeragile">
    <p> &copy; 2017 Existing Login Form. All Rights Reserved | Design by <a href="http://w3layouts.com" target="_blank">W3layouts</a>
    </p>
</div>

<script>
    // Function to validate the form
    function validateForm(event) {
        const email = document.getElementById('email').value;
        const password = document.getElementById('matKhau').value;

        // You can add your validation logic here
        if (email === "" || password === "") {
            alert("Email and password are required fields.");
            event.preventDefault(); // Prevent form submission
        }
    }

    // Add an event listener to the form
    const loginForm = document.getElementById('loginForm');
    loginForm.addEventListener('submit', validateForm);
</script>
<script type="text/javascript" src="../../../js/jquery-2.1.4.min.js"></script>

<!-- pop-up-box-js-file -->
<script src="../../../js/jquery.magnific-popup.js" type="text/javascript"></script>
<!--//pop-up-box-js-file -->
<script>
    $(document).ready(function () {
        $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
            type: 'inline',
            fixedContentPos: false,
            fixedBgPos: true,
            overflowY: 'auto',
            closeBtnInside: true,
            preloader: false,
            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-zoom-in'
        });

    });
</script>

</body>
<!-- //Body -->

</html>