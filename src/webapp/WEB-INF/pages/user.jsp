<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <title>User</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>userName</th>
        <th>lastName</th>
        <th>email</th>
        <th>password</th>
    </tr>
    <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
    </tr>
</table>
<h4><a href="/logout">Logout</a></h4>
</body>
</html>
