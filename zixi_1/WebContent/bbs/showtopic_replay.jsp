<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#939EAD" style="font-family: 微软雅黑; font-size: 12px">



	<div style="background-color: #fff;">
		<h1 align="left" style="background-color: black; color: white">${sessionScope.topic.title}</h1>
		<table width="100%">
			<tbody>
				<tr>
					<td
						style="width: 160px; height: auto; : # F3F3F3; overflow: hidden; border-right: 1px solid #FFF;">
						<div>${sessionScope.topic.user.username}</div>
						<div>
							<img src="${pageContext.request.contextPath}/images/head_01.jpg" />
						</div>
						<p>
							<strong>权限 <c:if
									test="${sessionScope.topic.user.popedom==1}">普通用户</c:if> <c:if
									test="${sessionScope.topic.user.popedom==2}">子版主</c:if> <c:if
									test="${sessionScope.topic.user.popedom==3}">版主</c:if> <c:if
									test="${sessionScope.topic.user.popedom==4}">管理员</c:if>
							</strong>
						</p>
						<dl style="margin: 5px 10px 5px 20px;">
							<dt style="float: left;">ID:</dt>
							<dd>${sessionScope.topic.user.userId}</dd>
							<dt style="float: left;">积分:</dt>
							<dd>${sessionScope.topic.user.integral}</dd>
							<dt style="float: left;">性别:</dt>
							<dd>${sessionScope.topic.user.sex}</dd>
						</dl>
					</td>
					<td valign="top">

						<div
							style="overflow: hidden; margin-bottom: 10px; padding: 10px 0; height: 16px; border-bottom: 1px dashed #CDCDCD;">
							<strong>发表于${sessionScope.topic.date}</strong>
						</div>

						<div>
							<strong> ${sessionScope.topic.title}</strong><br>
							${sessionScope.topic.content}
						</div>

					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<c:forEach items="${sessionScope.replay }" var="re" varStatus="replay">
		<div>
			<table width="100%">
				<tbody>
					<tr>
						<td
							style="width: 160px; height: auto; : # F3F3F3; overflow: hidden; border-right: 1px solid #FFF;">
							<div>${re.manageruser.username}</div>
							<div>
								<img src="${pageContext.request.contextPath}/images/head_01.jpg" />
							</div>
							<p>
								<strong>权限 <c:if test="${re.manageruser.popedom==1}">普通用户</c:if>
									<c:if test="${re.manageruser.popedom==2}">子版主</c:if> <c:if
										test="${re.manageruser.popedom==3}">版主</c:if> <c:if
										test="${re.manageruser.popedom==4}">管理员</c:if>
								</strong>
							</p>
							<dl style="margin: 5px 10px 5px 20px;">
								<dt style="float: left;">ID:</dt>
								<dd>${re.manageruser.userId}</dd>
								<dt style="float: left;">积分:</dt>
								<dd>${re.manageruser.integral}</dd>
								<dt style="float: left;">性别:</dt>
								<dd>${re.manageruser.sex}</dd>
							</dl>
						</td>
						<td valign="top">

							<div
								style="overflow: hidden; margin-bottom: 10px; padding: 10px 0; height: 16px; border-bottom: 1px dashed #CDCDCD;">
								<strong>发表于${re.date}</strong><strong style="float: right;">${replay.index+1}#</strong>
							</div>

							<div>${re.content}</div>

						</td>
					</tr>
					<tr>
					<td><button>回复</button></td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:forEach>
	<!--翻页条 -->

	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td width="10%">共${sessionScope.page.totalPage }页</td>
			<td width="10%"><a
				href="showtopic_re.action?topicId=${topic.topicId}&currentPage=1">首页</a></td>
			<c:if test="${sessionScope.page.currentPage>1 }">
				<td width="10%"><a
					href="showtopic_re.action?topicId=${topic.topicId}&currentPage=${sessionScope.page.currentPage-1}">上一页</a></td>
			</c:if>
			<c:if
				test="${sessionScope.page.currentPage<sessionScope.page.totalPage }">
				<td width="10%"><a
					href="showtopic_re.action?topicId=${topic.topicId}&currentPage=${sessionScope.page.currentPage+1}">下一页</a></td>
			</c:if>
			<td width="10%"><a
				href="showtopic_re.action?topicId=${topic.topicId}&currentPage=${sessionScope.page.totalPage}">尾页</a></td>
			<td width="40%"></td>
			<th><a href="#">￥￥￥￥￥￥</a></th>
		</tr>
	</table>

	<div style="margin-top: 50px;">
		<form action="replayadd.action" method="post">
			<table width="100%">
				<tbody>
					<tr>
						<td
							style="width: 160px; height: auto; : # F3F3F3; overflow: hidden; border-right: 1px solid #FFF;">
							<div></div>
							<div></div>
							<p>
								<strong>评论</strong>
							</p>
							<dl style="margin: 5px 10px 5px 20px;">
								<dt style="float: left;"></dt>
								<dd></dd>
							</dl>
						</td>
						<td valign="top"><textarea rows="10" cols="100"
								name="content"></textarea> <input type="submit" value="发表回复" />

						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>


</body>
</html>