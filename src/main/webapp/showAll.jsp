<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>所有的用户信息：</h1>

<c:forEach items="${requestScope.user}" var="user">
    ${user.userId}===
    ${user.name}===
    ${user.phone}===
    ${user.password}===
    ${user.sex}==
    ${user.dharmaName}==
    ${user.province}==
    ${user.city}==
    ${user.photo}==
    ${user.autogroaph}==
    <f:formatDate value="${user.registerTime}" pattern="yyyy-MM-dd HH:mm"/>
    <a href="${pageContext.request.contextPath}/cmfz_jsp/user/update.jsp?userId=${user.userId}">修改个人信息</a><br>
</c:forEach>


<input type="button" value="添加" onclick="location.href='${pageContext.request.contextPath}/add.jsp'">
</body>
