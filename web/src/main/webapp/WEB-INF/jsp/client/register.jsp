<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 07.04.2020
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Create Car Form</p>
<form action="${pageContext.request.contextPath}/register" method="post">

    <p>Name:</p>
    <input type="text" name="name" value="${requestScope.client.name}"><br>
    <p>Passport number:</p>
    <input type="text" name="passport" value="${requestScope.client.passport}"><br>
    <p>Address:</p>
    <input type="text" name="address" value="${requestScope.client.address}"><br>
    <p>Phone number:</p>
    <input type="number" name="phone" value="${requestScope.client.phone}"><br>
    <p>Password:</p>
    <input type="text" name="password" value="${requestScope.client.password}"><br>
    <button type="submit">Sing up</button>
</form>
</body>
</html>
