<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="topicadd.action" method="post">
  <table>
    <tr><th>子栏目</th>
       <td>
          <select name="subitemId">
          <c:forEach  items="${sessionScope.subitems1 }" var="sub" varStatus="vs">
           <option value="${sub.subitemId }">${sub.subitemName }</option>
          </c:forEach>
          </select>
       </td>
    </tr>
    <tr><th>标题</th><td><input type="text"  name="title"/></td></tr>
    <tr><th>内容</th><td><textarea rows="10" cols="10" name="content"></textarea></td></tr>
    <tr><th><input type="submit" value="发表" /></th></tr>
  </table>
  </form>
</body>
</html>