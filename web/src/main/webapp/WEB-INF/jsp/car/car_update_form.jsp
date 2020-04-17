<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Car Update</title>
</head>
<body>
<p>Update form</p>

<form action="${pageContext.request.contextPath}/car_update" method="post">
    <p>id:</p>
    <input type="number" value="${requestScope.car.id}" name="id">
    <p>model:</p>
    <input type="text" name="model" value="${requestScope.car.model}">
    <p>color:</p>
    <input type="text" name="color" value="${requestScope.car.color}">
    <p>year:</p>
    <input type="number" name="year" value="${requestScope.car.year}">
    <p>price:</p>
    <input type="number" name="price" value="${requestScope.car.price}">

    <button type="submit">Update Car</button>
</form>
</div>
</body>
</html>
