<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/chat/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/plug/semantic.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/chat/jquery-2.2.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/plug/semantic.min.js"></script>
<script type="text/javascript"
	src="http://localhost:3000/socket.io/socket.io.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/plug/date_choose/date_input.js"></script>
<script
	src="${pageContext.request.contextPath}/js/valdate/info-valdate.js"
	charset="utf-8"></script>
<style type="text/css">
	/*折叠菜单*/
	.rh-list {
		color: red;
		font-size: 3em;
	}
    .index-content .rh-list .content .column .list {
        cursor: pointer;
    }
    
    .index-content .rh-list .content .column .list:hover {
        background-color: #F5F5F5;
    }
</style>
<title>Insert title here</title>

</head>
<body bgcolor="#939EAD" style="font-family: 微软雅黑; font-size: 12px">
	<!-- 导航1.. -->
	<div class="ui stackable container menu">
		<div class="item">
			<i class="block big layout icon"></i>
		</div>
		<a class="item">Features</a>
	    <a class="item">Testimonials</a> 
	    <a class="item">Sign-in</a>
	    <a class="right item" id="version-info">
	     <i class="info big circle icon"></i>   
	    </a>
		<div class="right item">
			<c:if test="${!empty sessionScope.user_admin}">
				<div class="ui basic button">
					<a href="doin.action">注销</a>
				</div>
				<div class="ui basic button">${sessionScope.user_admin.username}</div>
				
				<div class="ui basic button mesgcount" id="mesgcount">CHAT</div>
				<div class="ui large modal chat">
					<div id="chatbox">
						<div
							style="background: #3d3d3d; height: 28px; width: 100%; font-size: 12px;">
							<div style="line-height: 28px; color: #fff;">
								<span style="text-align: left; margin-left: 10px;">Websocket多人聊天室</span>
								<span style="float: right; margin-right: 10px;"><span
									id="showusername"></span> | <a href="javascript:;"
									onclick="CHAT.logout()" style="color: #fff;">退出</a></span>
							</div>
						</div>
						<div id="doc">
							<div id="chat">
								<div id="message" class="message">
									<div class="online_member" id="onlinecount"></div>
								</div>
								<div class="input-box">
									<div class="input">
										<input type="text" maxlength="140"
											placeholder="请输入聊天内容，按Enter发送" id="content" name="content">
									</div>
									<div class="action">
										<button type="button" id="mjr_send" onclick="CHAT.submit();">提交</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${empty sessionScope.user_admin}">
				<div class="ui basic button">您好：游客</div>
				<div class="ui basic button">
					<a href="userlogin.jsp">登陆</a>
				</div>
			</c:if>
		</div>

		<!-- 弹出层 -->
		    <div class="ui modal version-info">
		        <i class="close icon"></i>
		        <div class="header">
		            IAM VSERSION INFO!
		        </div>
		        <div class="image content">
		            <div class="ui medium image">
		                <!--  <img src="/images/avatar/large/chris.jpg"> -->
		            </div>
		            <div class="description">
		                <div class="ui header">We've auto-chosen a profile image for you.</div>
		                <p>We've grabbed the following image from the <a href="https://www.gravatar.com" target="_blank">gravatar</a> image associated with your registered e-mail address.</p>
		                <p>Is it okay to use this photo?</p>
		            </div>
		        </div>
		    </div>
	</div>

  <!-- 折叠菜单 -->
    <div class="index-content" style="width:80%;margin: 0 auto;min-height:700px;">
    <!-- 导航2 -->
	<div class="ui big breadcrumb">
		<a class="active section">Home</a> <i class="right chevron icon divider"></i>
	</div>
       <c:forEach items="${sessionScope.a_subitem}" var="item" varStatus="uus">
        <div class="ui fluid accordion rh-list">
            <div class="title">
                <div class="ui celled list">
                    <div class="item">
                        <i class="ui dropdown icon" style="margin-top:2%"></i>
                        <img class="ui avatar image" src="img/head.gif">
                        <div class="content">
                            <div class="header">${item.key.itemName } (${fn:length(item.value)})</div>
                            <div style="font-size:12px">${item.key.itemDescript }</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content">
                <div class="ui four column grid">
                 <c:forEach items="${item.value}" var="subitem" varStatus="uuss">
                    <a href="showtopic.action?subitemId=${subitem.subitemId}&currentPage=1">
                    <div class="column">
                        <div class="ui massive horizontal list">
                            <div class="item">
                                <img class="ui avatar image" src="img/tototo.gif">
                                
                                <div class="content">
                                    <div class="header">${subitem.subitemName}</div>帖子数量：${fn:length(subitem.topic)}
                                </div>
                            </div>
                        </div>
                    </div>
                    </a>
                   </c:forEach>
                </div>
            </div>
         </div>
         </c:forEach>
    </div>
<!-- 折叠菜单over  -->

	<c:forEach items="${sessionScope.a_subitem}" var="item" varStatus="uus">
		<div class="mainbox"
			style="border: 2px solid #ccc; background-color: #fff; margin: 20px auto; width: 960px;">
			<h1 align="left"
				style="padding: 0; margin: 0; background-color: black; color: white">${item.key.itemName }</h1>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr height="50px">
					<td width="10%">&nbsp;</td>
					<td width="78%">${item.key.itemDescript }</td>
					<td width="15%"><span class="moder"><strong>栏目版主：</strong>${item.key.manager.username}</span></td>
				</tr>
			</table>


			<table border="0" cellpadding="0" cellspacing="0" width="100%">

				<tbody>

					<tr>
						<c:forEach items="${item.value}" var="subitem" varStatus="uuss">
							<td align="left">

								<div class="box" style="width: 50px; height: 50px; float: left;">
									<a
										href="showtopic.action?subitemId=${subitem.subitemId}&currentPage=1"><img
										src="../images/img_01.png" /></a>
								</div>
								<dl>
									<dt>
										<a
											href="showtopic.action?subitemId=${subitem.subitemId}&currentPage=1">${subitem.subitemName}</a>
									</dt>
									<dd>帖子数量：${fn:length(subitem.topic)}</dd>
								</dl>
							</td>

						</c:forEach>
					</tr>

				</tbody>

			</table>

		</div>
	</c:forEach>
	<script>
		var username = "${sessionScope.user_admin.username}";
		var userage = "${sessionScope.user_admin.age}";
		var usersex = "${sessionScope.user_admin.sex}";
		var integral = "${sessionScope.user_admin.integral}";
		var userbirth = "${sessionScope.user_admin.birthd}";
		var userid = "${sessionScope.user_admin.userId}";
		/*点击弹窗*/
        $('#version-info').click(function() {
            //alert('message')
            $('.version-info').modal('show');
        });
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/chat/client.js"></script>
</body>
</html>