package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Order;
import com.carrent.service.service.CarService;
import com.carrent.service.service.OrderService;
import com.carrent.service.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;

@Controller
public class OrderController {

    private CarService carService;
    private OrderService orderService;
    private UserService userService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String BookDates(Model model, @RequestParam(value = "car_id") Long CarId,
                            @RequestParam(value = "start_date", defaultValue = "1800-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar startDate,
                            @RequestParam(value = "end_date", defaultValue = "3000-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar endDate) {
        Car carById = carService.getCarById(CarId);
        model.addAttribute("carById", carById);
        return "order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String createNewCustomer(Car car, Order order,
                                    RedirectAttributes redirectAttributes, @RequestParam(value = "car_id") Long CarId,
                                    @RequestParam(value = "start_date", defaultValue = "1800-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar startDate,
                                    @RequestParam(value = "end_date", defaultValue = "3000-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar endDate) {
        Car carById = carService.getCarById(CarId);
        redirectAttributes.addAttribute("car_id", CarId);
        return "redirect:/order";

    }

    @RequestMapping(value = "orderResume{car_id}", method = RequestMethod.GET)
    public String showCustomerResume(Model model, Order order,
                                     @RequestParam(value = "car_id") Long carId, @PathVariable String car_id) {
        Car car = carService.getCarById(carId);
        model.addAttribute("order", order);
        model.addAttribute("carById", car);
        return "orderResume";
    }

    @RequestMapping(value = "orderResume", method = RequestMethod.POST)
    public String completeAll(Order order) {
        orderService.save(order);
        return "redirect:/";
    }
}
