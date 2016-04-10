<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/semantic.min.css">
<script src="${pageContext.request.contextPath}/js/semantic.min.js"></script>
</head>
<body>
<div style="margin:50px auto;width:50%;">
<h4 class="ui horizontal divider header"> 管理员登陆 </h4>
<form class="ui form" action="login.action" method="post">
  <div class="field">
    <label>用户名</label>
    <input type="text"  placeholder="用户名" name="username">
  </div>
  <div class="field">
    <label>密码</label>
    <input type="password" placeholder="密码" name="password">
  </div>
  <button type="submit" class="ui button" type="submit">Submit</button>
</form>
</div>
</body>
</html>