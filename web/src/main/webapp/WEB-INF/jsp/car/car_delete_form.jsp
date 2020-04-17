<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 16.04.2020
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Car</title>
</head>
<body>

    <h2>Car Delete</h2>


    <p>Car id: ${requestScope.car.Id}</p>
    <p>Car model: ${requestScope.car.model}</p>
    <p>Car color: ${requestScope.car.color}</p>
    <p>Car rented: ${requestScope.car.rented}</p>
    <p>Car plate num: ${requestScope.car.plate_num}</p>
    <p>Car year: ${requestScope.car.year}</p>
    <p>Car price: ${requestScope.car.price}</p>
        <form method="post" action="${pageContext.request.contextPath}/car_delete">
        <input type="number" value="${requestScope.car.id}" name="id">
        <button type="submit" >ДА</button>
    </form>
</div>
</body>
</html>
