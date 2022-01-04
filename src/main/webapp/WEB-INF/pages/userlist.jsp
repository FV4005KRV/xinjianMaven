<%--
  Created by IntelliJ IDEA.
  User: 马晨龙
  Date: 2021/12/25
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <script >
        function del(id) {
            if (window.confirm("要删除吗")){
                window.location.href = "${pageContext.request.contextPath}/usera/del/"+id;
            }
        }
    </script>
</head>
<body>

<table border="1" width="800" cellspacing="0" align="center" style="margin-top: 50px">
    <thead>
    <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>年龄</th>
        <th>部门</th>
        <th>余额</th>
        <th>头像</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach var="u" items="${pv.list}">
    <tr>
        <td>${u.id}</td>
        <td>${u.username}</td>
        <td>${u.age}</td>
        <td>研发部</td>
        <td>${u.money}</td>
        <td><img src="${pageContext.request.contextPath}/${u.photo}" height="50px" width="40px"></td>
        <td><a href="${pageContext.request.contextPath}/usera/up/${u.id}">修改</a> <a href="javascript:del('${u.id}')">删除</a></td>
    </tr>
    </c:forEach>
    <tr>
        <td colspan="7">
             <a href="${pageContext.request.contextPath}/usera/list?pn=1">首页</a>|<a href="${pageContext.request.contextPath}/usera/list?pn=${pv.prePage}">上一页</a>|
            <c:forEach items="${pv.navigatepageNums}" var="num">
                <c:if test="${num==pv.pageNum}">
                    【${num}】
                </c:if>
                <c:if test="${num!=pv.pageNum}">
                    <a href="${pageContext.request.contextPath}/usera/list?pn=${num}">${num}</a>
                </c:if>
            </c:forEach>
            |<a href="${pageContext.request.contextPath}/usera/list?pn=${pv.nextPage}">下一页</a>|<a  href="${pageContext.request.contextPath}/usera/list?pn=${pv.pages}">尾页</a>|总页数：${pv.pages}
        </td>
    </tr>
    <a href="addui">添加</a>
</table>
</body>
</html>
