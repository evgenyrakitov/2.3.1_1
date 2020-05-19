<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>

<h2>Cars</h2>
<table>
    <tr>
        <th>id</th>
        <th>model</th>
        <th>color</th>
        <th>type</th>
    </tr>
    <c:forEach var="cars" items="${allCar}">
        <tr>
            <td>${cars.id}</td>
            <td>${cars.model}</td>
            <td>${cars.color}</td>
            <td>${cars.tipe}</td>
            <td>
                <a href="/update/${cars.id}">edit</a>
                <a href="/delete/${cars.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new car</a>
</body>
</html>