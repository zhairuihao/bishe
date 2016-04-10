<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/plug/semantic.min.css">
<script src="${pageContext.request.contextPath}/plug/semantic.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.6.min.js"></script>
</head>
<body bgcolor="#939EAD" style="font-family: 微软雅黑; font-size: 12px">

	<div class="con" style="background-color: #fff;">
		<h1 align="left" style="background-color: black; color: white">${subitemName }</h1>
		<c:if test="${!empty sessionScope.allTopics }">
			<table border="0" cellpadding="0" cellspacing="0" width="100%" id="x">
				<tr height="50px">
					<th width="10%">&nbsp;</th>
					<th width="50%">标题</th>
					<th width="20%">作者</th>
					<th width="20%">回复/查看</th>
				</tr>
				<c:forEach items="${sessionScope.allTopics }" var="alt"
					varStatus="all">
					<tr height="60px">
						<td width="10%">&nbsp;</td>
						<td width="50%"><a
							href="showtopic_re.action?topicId=${alt.topicId}&currentPage=1&subitemId=${sessionScope.subitem.subitemId}">${alt.title}</a></td>
						<td width="30%" align="center">${alt.user.username}<br>${alt.date}</td>
						<td width="30%" align="center">${fn:length(alt.replay)}/${alt.hasread}</td>
					</tr>

				</c:forEach>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td width="10%">共${sessionScope.page.totalPage }页</td>
					<td width="10%"><a
						href="showtopic.action?subitemId=${subitem.subitemId}&currentPage=1">首页</a></td>
					<c:if test="${sessionScope.page.currentPage>1 }">
						<td width="10%"><a
							href="showtopic.action?subitemId=${subitem.subitemId}&currentPage=${sessionScope.page.currentPage-1}">上一页</a></td>
					</c:if>
					<c:if
						test="${sessionScope.page.currentPage<sessionScope.page.totalPage }">
						<td width="10%"><a
							href="showtopic.action?subitemId=${subitem.subitemId}&currentPage=${sessionScope.page.currentPage+1}">下一页</a></td>
					</c:if>
					<td width="10%"><a
						href="showtopic.action?subitemId=${subitem.subitemId}&currentPage=${sessionScope.page.totalPage}">尾页</a></td>
					<td width="40%"></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${empty sessionScope.allTopics }">
			<h2>没有任何内容 快去发帖吧！</h2>
		</c:if>
	</div>

	<div style="margin-top: 50px;">
		<form action="topicadd.action" method="post">
			<table width="100%">
				<tbody>
					<tr>
						<td
							style="width: 160px; height: auto; : # F3F3F3; overflow: hidden; border-right: 1px solid #FFF;">
							<div></div>
							<div></div>
							<p>
								<strong>主题</strong>
							</p>
							<dl style="margin: 5px 10px 5px 20px;">
								<dt style="float: left;"></dt>
								<dd></dd>
							</dl>
						</td>
						<td valign="top"><input type="text" name="title" value="标题" /><br>
							<select name="subitemId">
								<c:forEach items="${sessionScope.subitems1 }" var="sub"
									varStatus="vs">
									<option value="${sub.subitemId }">${sub.subitemName }</option>
								</c:forEach>
						</select> <br> <textarea rows="10" cols="100" name="content"></textarea>
							<input type="submit" value="发表新帖" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>