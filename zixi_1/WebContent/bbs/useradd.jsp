<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<title>注册</title>
</head>
<body>
	<div style="width: 35%; margin: 0 auto; overflow: hidden;">
		<!-- 表单验证 -->
		<div class="column">
			<h2 class="ui blue image header">
				<img
					src="${pageContext.request.contextPath}/images/login-out/tototo.gif"
					class="image">
				<div class="content">Sign-Up to your account....</div>
			</h2>
			<form class="ui large form" action="useradd.action" method="post">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i> <input type="text" name="username"
								placeholder="username">
						</div>
					</div>
					
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> 
							<input class="date_picker" type="text" name="birthd" placeholder="Birth" >
						</div>
					</div>
					
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i>
							<input type="password" id="pwd" name="password" placeholder="Password">
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="password" id="pwdtw"
								name="passwordtw" placeholder="Repeat Password">
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<div class="ui radio checkbox">
								<input type="radio" name="sex" value="1"> <label>male</label>		
							</div>
							<div class="ui radio checkbox">	
								<input type="radio" name="sex" value="2"> <label>female</label>
							</div>
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="text" name="age"
								placeholder="Age">
						</div>
					</div>
					<div class="ui fluid large blue submit button">Sign</div>
				</div>
				<div class="ui error message"></div>
			</form>
			<div class="ui message">
				New to us? <a href="userlogin.jsp">Login in</a>
			</div>
		</div>
	</div>
</body>
</html>