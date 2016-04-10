<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/plug/semantic.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/plug/date_choose/date_plug.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/chat/jquery-2.2.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/plug/date_choose/date_input.js"></script>
<script src="${pageContext.request.contextPath}/plug/semantic.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/valdate/info-valdate.js"
	charset="utf-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div style="width: 35%; margin: 0 auto; overflow: hidden;">
		<!-- 表单验证 -->
		<div class="column">
			<h2 class="ui blue image header">
				<img
					src="${pageContext.request.contextPath}/images/login-out/lvlvlv.gif"
					class="image">
				<div class="content">Log-in to your account....</div>
			</h2>
			<form class="ui large form" action="login_user.action" method="post">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i> <input type="text" name="username"
								placeholder="username">
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="password" id="pwd"
								name="password" placeholder="Password">
						</div>
					</div>
					<div class="ui fluid large blue submit button">Login</div>
				</div>
				<div class="ui error message"></div>
			</form>
			<div class="ui message">
				New to us? <a href="useradd.jsp">Sign Up</a>
			</div>
		</div>
	</div>
</body>
</html>