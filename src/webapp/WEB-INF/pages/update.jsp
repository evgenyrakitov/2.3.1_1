<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty car.id}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty car.id}">
        <title>Update</title>
    </c:if>
</head>
<body>
<c:if test="${empty car.id}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty car.id}">
    <c:url value="/update" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty car.id}">
        <input type="hidden" name="id" value="${car.id}">
    </c:if>
    <label for="model">Model</label>
    <input type="text" name="model" id="model">
    <label for="color">Color</label>
    <input type="text" name="color" id="color">
    <label for="tipe">Tipe</label>
    <input type="text" name="tipe" id="tipe">
    <c:if test="${empty car.id}">
        <input type="submit" value="Add Car">
    </c:if>
    <c:if test="${!empty car.id}">
        <input type="submit" value="Update Car">
    </c:if>
</form>
</body>
</html>