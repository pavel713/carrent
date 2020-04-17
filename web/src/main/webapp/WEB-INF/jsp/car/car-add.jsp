<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.prokat.entity.Car" %>
<html>
<head>
    <title>Create Car Form</title>
</head>
<body>
<p>Create Car Form</p>
<form action="${pageContext.request.contextPath}/add-car" method="post">

    <p>Модель:</p>
    <input type="text" name="model" value="${requestScope.car.model}"><br>
    <p>Цвет:</p>
    <input type="text" name="color" value="${requestScope.car.color}"><br>
    <p>Регистрационный знак:</p>
    <input type="text" name="plate_num" value="${requestScope.car.plate_num}"><br>
    <p>Год выпуска:</p>
    <input type="number" name="year" value="${requestScope.car.year}"><br>
    <p>Стоимость аренды:</p>
    <input type="number" name="price" value="${requestScope.car.price}"><br>

    <button type="submit">Добавить автомобиль</button>
</form>
</body>
</html>
