package com.carrent.car;



import com.carrent.Car;
import com.carrent.CarsService;
import com.carrent.dao.CarsDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/car_delete", name = "Car Delete")
public class ServletDeleteCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");
        if(idStr != null){
            long id = Long.valueOf(idStr);
            req.setAttribute("car", CarsDAOImpl.getInstance().getById((int) id));
            req.getRequestDispatcher("/car/delete_form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String idStr = req.getParameter("id");
            if(idStr != null){
                long id = Long.valueOf(idStr);
                Car car = new Car();
                CarsService.getInstance().delete(car);
                resp.getWriter().println(car);


        }}}


