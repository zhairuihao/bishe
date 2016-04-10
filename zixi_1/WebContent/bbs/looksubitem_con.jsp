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
	width:960px;
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

.zebra td {
    border-left: 1px solid #555;
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

.zebra tr:hover *{
    background: #eeeeee;
	color:#000;
}

.zebra tr {
	background:#404040;
	color:#fff;
}

</style>
</head>
<body>

<div id="container">   

	<table class="zebra">
	<caption>浏览子栏目</caption>
		<thead>
        	<tr>
				<th>子栏目ID</th>
				<th>子栏目名</th>
				<th>子栏目介绍</th>
				<th>子栏目版主</th>
				<th>删除子栏目</th>				
            </tr>
		</thead>
        <tbody>
				<c:forEach items="${sessionScope.allsubitems}"  var="items" varStatus="uuser">
				
				<tr>
				<td>${items.subitemId}</td>
				<td>${items.subitemName}</td>							
				<td>${items.itemDescription}</td>
				<td>${items.manager.username}</td>
				<td><a href="deletesubitem.action?subitemId=${items.subitemId}&d_delete=${items.d_delete}&itemId=${items.itemId}">
				<c:if test="${items.d_delete==0}">恢复</c:if>
				<c:if test="${items.d_delete==1}">删除</c:if>
				</a></td>
				</tr>
				
				</c:forEach>      
   </tbody>
	</table>
</div>

</body>
</html>