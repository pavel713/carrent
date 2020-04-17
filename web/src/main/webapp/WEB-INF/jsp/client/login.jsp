<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <p>

        <input type="text" name="name" value="${requestScope.client.name}">
    </p>
    <p>

        <input type="password" name="password" value="${requestScope.client.password}">
    </p>
    <p>
        <button type="submit">Login</button>
    </p>
</form>
</body>
</html>
