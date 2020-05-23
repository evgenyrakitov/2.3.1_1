<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.id}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty user.id}">
        <title>Update</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.id}">
    <c:url value="/admin/add" var="var"/>
</c:if>
<c:if test="${!empty user.id}">
    <c:url value="/admin/update" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty user.id}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="userName">UserName</label>
    <input type="text" name="userName" id="userName">
    <label for="lastName">LastName</label>
    <input type="text" name="lastName" id="lastName">
    <label for="email">Email</label>
    <input type="text" name="email" id="email">
    <label for="password">Password</label>
    <input type="text" name="password" id="password">
    <c:if test="${empty user.id}">
        <input type="submit" value="Add User">
    </c:if>
    <c:if test="${!empty user.id}">
        <input type="submit" value="Update User">
    </c:if>
</form>
</body>
</html>