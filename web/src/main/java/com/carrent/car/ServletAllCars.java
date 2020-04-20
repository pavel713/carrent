package com.carrent.car;




import com.carrent.Car;
import com.carrent.CarsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/all-cars", name = "AllCars")
public class ServletAllCars extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Car> carList = CarsService.getInstance().findAllCars();
        StringBuilder result = new StringBuilder();
        for (Car car : carList) {
            result.append("<p>")
                    .append(car.getId())
                    .append(car.getModel())
                    .append(car.getColor())
                    .append(car.isRented())
                    .append(car.getPlate_num())
                    .append(car.getYear())
                    .append(car.getPrice())
                    .append("</p>");
        }
        resp.getWriter().write(result.toString());
        req.setAttribute("cars", carList);
        getServletContext()
                .getRequestDispatcher("WEB-INF/jsp/car/car.jsp")
                .forward(req, resp);


    }


}
