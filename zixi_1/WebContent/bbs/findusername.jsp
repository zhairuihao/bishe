<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script type="text/javascript" src="../js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<script  type="text/javascript">
function changeSource()
{
var username = document.getElementById("username").value;
//前台js将参数值转为统一资源标示符
username = encodeURI(encodeURI(username));
username = encodeURI(encodeURI(username));
document.getElementById("frame1").src="findusername_a.action?username="+username;
}
</script>

</head>

<body>
<div class="nav-top">
	<span>论坛后台管理系统</span>
    <div class="nav-topright">
    	<p>=。=</p>
        <span>您好：管理员${sessionScope.user_admin.username }</span><span><a href="doin.action">注销</a></span>
    </div>
</div>
<div class="nav-down">
	<div class="leftmenu1">
        <div class="menu-oc"><img src="../images/menu-all.png" /></div>
    	<ul>
        	<li>
            	<a class="a_list a_list1">全局设置</a>
                <div class="menu_list menu_list_first">
                	<a class="lista_first" href="#">基本设置</a>
                    <a href="#">其他设置</a>
                    <a href="#">界面风格</a>
                    <a href="#">系统工具</a>
                </div>
            </li>
            <li>
            	<a class="a_list a_list2">用户管理</a>
                <div class="menu_list">
                	<a href="lookuser.jsp" >用户查看</a>
                	<a href="findusername.action" >用户更新</a>                  
                </div>
            </li>
            <li>
            	<a class="a_list a_list3">栏目管理</a>
                <div class="menu_list">
                	<a href="lookitem.jsp">查看栏目</a>
                    <a href="additem.jsp">添加栏目</a>                  
                </div>
            </li>
             <li>
            	<a class="a_list a_list3">子栏目管理</a>
                <div class="menu_list">
                	<a href="looksubitem.jsp">查看子栏目</a>
                    <a href="addsubitem.jsp">添加子栏目</a>                  
                </div>
            </li>
        </ul>
    </div>
    <div class="leftmenu2">
    	<div class="menu-oc1"><img src="../images/menu-all.png" /></div>
        <ul>
        	<li>
            	<a class="j_a_list j_a_list1"></a>
                <div class="j_menu_list j_menu_list_first">
                	<span class="sp1"><i></i>全局设置</span>
                	<a class="j_lista_first" href="#">基本设置</a>
                    <a href="#">其他设置</a>
                    <a href="#">界面风格</a>
                    <a href="#">系统工具</a>
                </div>
            </li>
            <li>
            	<a class="j_a_list j_a_list2"></a>
                <div class="j_menu_list">
                	<span class="sp2"><i></i>用户管理</span>
                	<a href="lookuser.jsp" >用户查看</a>
                	<a href="findusername.action" >用户更新</a>           
                </div>
            </li>
            <li>
            	<a class="j_a_list j_a_list3"></a>
                <div class="j_menu_list">
                	<span class="sp3"><i></i>栏目管理</span>
                	<a href="lookitem.jsp">查看栏目</a>
                    <a href="additem.jsp">添加栏目</a> 
                </div>
            </li>
             <li>
            	<a class="j_a_list j_a_list3"></a>
                <div class="j_menu_list">
                   <span class="sp3"><i></i>子栏目管理</span>
                	<a href="looksubitem.jsp">查看子栏目</a>
                    <a href="addsubitem.jsp">添加子栏目</a>                  
                </div>
            </li>
        </ul>
        
    </div>
    <div class="rightcon">
    	<div class="right_con">
        	<p style="text-align:left; margin-top:50px" id="p1">欢迎进入后台管理>>用户更新>></p>
            <p align="right" id="p2">
                选择用户：
            <select name="username" id="username" onchange="changeSource()">
            <c:forEach items="${sessionScope.userlist }" var="user" varStatus="users">
            <option value="${user.username}">${user.username}</option>
            </c:forEach>
            </select>
            </p>
                <iframe id="frame1" src="findusername_a.action?username=user" height="430px"  width="100%"
            frameborder="0">></iframe>
        </div>
    </div>
</div>
<div style="text-align:center;">
  版权所有@卡死大三大四的
</div>

</body>
</html>