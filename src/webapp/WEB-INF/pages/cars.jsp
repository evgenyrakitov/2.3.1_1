<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.05.20
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title><spring:message code="lable.Cars"/></title>
</head>
<body>
    <c:forEach var="msq" items="${message}">
        <h1>${msq.toString()}</h1>
    </c:forEach>
</body>
</html>
