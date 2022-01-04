<%--
  Created by IntelliJ IDEA.
  User: 马晨龙
  Date: 2021/12/27
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/usera/addorupdateuser" enctype="multipart/form-data" method="post">
            <input type="hidden" name="id" value="${ua.id}">
   用户名： <input type="text"  name="username" value="${ua.username}"><br>
    年龄： <input type="text"  name="age" value="${ua.age}"><br>
    余额： <input type="text"  name="money" value="${ua.money}"><br>
    头像： <input type="file"  name="pic" ><img src="${pageContext.request.contextPath}/${ua.photo}"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
