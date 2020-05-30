<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<c:url value="/admin/add" var="var"/>

<form action="${var}" method="POST">
    <label for="userName">UserName</label>
    <input type="text" name="userName" id="userName">
    <label for="lastName">LastName</label>
    <input type="text" name="lastName" id="lastName">
    <label for="email">Email</label>
    <input type="text" name="email" id="email">
    <label for="password">Password</label>
    <input type="text" name="password" id="password">
    <label>Role</label>
    <select name="role" multiple>
    <c:forEach var="role" items="${roles}">
        <option value="<c:out value="${role}"/>"><c:out value="${role}"/></option>
    </c:forEach>
    </select>
    <input type="submit" value="Add User">
</form>
</body>
</html>