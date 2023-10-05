<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

<title>Existing Login Form a Flat Responsive Widget Template :: W3layouts</title>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Existing Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Meta-Tags -->

<link href="../../../css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />

<!-- Style --> <link rel="stylesheet" href="../../../css/style.css" type="text/css" media="all">

<!-- Fonts -->
<link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
<!-- //Fonts -->

</head>

<body>
<h1>Bán Quần Áo</h1>


	<div class="w3layoutscontaineragileits">
	<h2>Đăng kí tài khoản</h2>

		<c:if test="${not empty successMessage}">
			<div class="alert alert-success">
					${successMessage}
			</div>
		</c:if>

		<form:form method="POST" action="/dang-ki/add">

			<div class="form-sub-w3ls">
				<form:input path="userName" class="form-control" placeholder="Username" />
				<br>
				<form:errors path="userName" cssClass="error-message"/>

				<div class="icon-agile">
					<i class="fa fa-user" aria-hidden="true"></i>
				</div>
			</div>
			<div class="form-sub-w3ls">
				<form:input path="email" class="form-control" placeholder="Email" />	<br>
				<form:errors path="email" cssClass="error-message"/>

				<div class="icon-agile">
					<i class="fa fa-envelope-o" aria-hidden="true"></i>
				</div>
			</div>
			<div class="form-sub-w3ls">
				<form:input path="encrytedPassword" class="form-control" placeholder="Pass" />	<br>
				<form:errors path="encrytedPassword" cssClass="error-message"/>

				<div class="icon-agile">
					<i class="fa fa-unlock-alt" aria-hidden="true"></i>
				</div>
			</div>

			<div class="login-check">
				<label class="checkbox"><input type="checkbox" name="checkbox" checked="">I Accept Terms & Conditions</label>
			</div>
			<div class="submit-w3l">
				<button type="submit" class="btn btn-primary">Đăng kí tài khoản</button>
				<br>
				<p> Quay lại về đăng nhập <span>→</span> <a href="/login">Bấm vào đây ! </a></p>

			</div>

			<br>

		</form:form>

	</div>

	
	<div class="w3footeragile">
		<p> &copy; 2017 Existing Login Form. All Rights Reserved | Design by <a href="http://w3layouts.com" target="_blank">W3layouts</a></p>
	</div>

	
	<script type="text/javascript" src="../../../js/jquery-2.1.4.min.js"></script>

	<!-- pop-up-box-js-file -->  
		<script src="../../../js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!--//pop-up-box-js-file -->
	<script>
		$(document).ready(function() {
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

</html>