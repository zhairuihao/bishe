<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
<script type="text/javascript" src="../js/ajax1.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<style type="text/css">
@charset "UTF-8";
.zebra caption{
	font-size:20px;
	font-weight:normal;
	background:url(../images/zebratable.png);
	background-repeat:no-repeat;
	background-position: 130px center;
	padding-top: 20px;
	height:50px;
	}
#container{
	padding-top:20px;
	width:500px;
	margin:0 auto;
}

table {
    border-collapse: collapse;
    border-spacing: 0;
	width:100%;
	-webkit-box-shadow:  0px 2px 1px 5px rgba(242, 242, 242, 0.1);
    box-shadow:  0px 2px 1px 5px rgba(242, 242, 242, 0.1);
}

.zebra {
    border: 1px solid #555;
}
.zebra input{
width: 150px;
}
.zebra td {
  
    border-top: 1px solid #555;
    padding: 10px;
    text-align: left;    
}

.zebra th, .zebra th:hover {
    border-left: 1px solid #555;
	border-bottom: 1px solid #828282;
    padding: 20px;  
    background-color:#151515 !important;
    background-image: -webkit-gradient(linear, left top, left bottom, from(#151515), to(#404040)) !important;
    background-image: -webkit-linear-gradient(top, #151515, #404040) !important;
    background-image:    -moz-linear-gradient(top, #151515, #404040) !important;
    background-image:     -ms-linear-gradient(top, #151515, #404040) !important;
    background-image:      -o-linear-gradient(top, #151515, #404040) !important;
    background-image:         linear-gradient(top, #151515, #404040) !important;
	color:#fff !important;
	font-weight:normal;
}

.zebra tbody tr:nth-child(even) {
    background: #000 !important;
	color:#fff;
}


.zebra tr {
	background:#404040;
	color:#fff;
}
select{
width: 160px;
}
</style>
</head>
<body>

<div id="container">   
     <form action="updateuser.action" method="post" name="form1">
	<table class="zebra">
	<caption>用户更新</caption>
        <tbody>		
				<tr>
					<td>用户ID:</td>
					<td>${sessionScope.byusername.userId}</td>
				</tr>
				<tr>
				    <td>用户名:</td>
				    <td><input type="text" name="username" value="${sessionScope.byusername.username}"/></td>
				</tr>
				<tr>
				    <td>密码:</td>
				    <td><input type="text" name="password" value="${sessionScope.byusername.password}"/></td>	
				</tr>
				<tr>
				    <td>性别:</td>
				    <td>${sessionScope.byusername.sex}</td>		
				</tr>
				<tr>
				    <td>年龄:</td>
				    <td><input type="text" name="age" value="${sessionScope.byusername.age}"/></td>
				</tr>
				<tr>
				<td>出身日期:</td>
				<td><fmt:formatDate value="${sessionScope.byusername.birthd}"  pattern="yyyy年MM月dd日" /></td>
				</tr>
				<tr>
				    <td>积分:</td>
				    <td><input type="text" name="integral" value="${sessionScope.byusername.integral}"/>分</td>
				</tr>
				<tr>
					<td>权限:</td>
					<td>
						<select name="popedom">
							<option value="1">普通用户</option>
							<option value="2">子版主</option>
							<option value="3">版主</option>
							<option value="4">管理员</option>
						</select>
				    </td>				
				</tr>
				<tr><td></td><td><input type="submit" value="提交"/></td></tr>			
   </tbody>
	</table>
	</form>
</div>

</body>
</html>