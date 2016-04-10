<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style type="text/css">
td .errorMessage{
color:red;
}
</style>
</head>
<body>
<div style="color:red;">
  <s:actionmessage/>
</div>
<h2>添加信息</h2>
<s:form action="useradd.action" method="post" name="form1">
<s:textfield label="用户名" name="username"></s:textfield>
<s:password label="密码" name="password"></s:password>
<s:radio label="性别" name="sex" list="%{#{'1':'男','0':'女'}}" value="1" ></s:radio> 
<s:textfield label="年龄" name="age"></s:textfield>
<s:textfield label="生日" name="birthd"></s:textfield>
<s:submit name="button1" value="提交"></s:submit>
</s:form>
</body>
</html>