<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <c:url value="/admin/update" var="var"/>
<form action="${var}" method="POST">
    <%--@declare id="id"--%><label for="id">Id</label>
    <input type="text" name="id" value="${user.id}" readonly>
    <label for="userName">UserName</label>
    <input type="text" name="userName" id="userName" value="${user.username}">
    <label for="lastName">LastName</label>
    <input type="text" name="lastName" id="lastName" value="${user.lastName}">
    <label for="email">Email</label>
    <input type="text" name="email" id="email" value="${user.email}">
    <label for="password">Password</label>
    <input type="text" name="password" id="password" value="${user.password}">

    <label>Role</label>
    <select name="role" multiple>
                                <c:forEach var="role" items="${roles}">
                                    <option value="<c:out value="${role}"/>"><c:out value="${role}"/></option>
                                 </c:forEach>
    </select>



    <input type="submit" value="Update User">
</form>
</body>
</html>