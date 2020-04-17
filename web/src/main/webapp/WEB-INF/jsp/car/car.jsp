<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Car id: ${requestScope.car.Id}</p>
<p>Car model: ${requestScope.car.model}</p>
<p>Car color: ${requestScope.car.color}</p>
<p>Car rented: ${requestScope.car.rented}</p>
<p>Car plate num: ${requestScope.car.plate_num}</p>
<p>Car year: ${requestScope.car.year}</p>
<p>Car price: ${requestScope.car.price}</p>
</body>
</html>
