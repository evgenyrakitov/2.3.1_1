<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<h2>Users</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>lastName</th>
        <th>email</th>
        <th>password</th>
    </tr>
    <c:forEach var="users" items="${allUser}">
        <tr>
            <td>${users.id}</td>
            <td>${users.name}</td>
            <td>${users.lastName}</td>
            <td>${users.email}</td>
            <td>${users.password}</td>
            <td>
                <a href="/update/${users.id}">edit</a>
                <a href="/delete/${users.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new User</a>
</body>
</html>