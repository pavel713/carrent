package com.prokat.web.servlet.car;

import com.prokat.entity.Car;
import com.prokat.service.CarsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-car", name = "CreateCar")
public class ServletAddCar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/car/car-add.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String model = req.getParameter("model");
        String color = req.getParameter("color");
        String plate_num = req.getParameter("plate_num");
        String yearStr = req.getParameter("year");
        String priceStr = req.getParameter("price");
        int year = Integer.parseInt(yearStr);
        int price = Integer.parseInt(priceStr);
        Car car = new Car(model, color, plate_num, year, price);
        CarsService.getInstance().addCar(car);
        resp.getWriter().println("Success");

    }
}

