package com.carrent.web.controller;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;
import com.carrent.dto.CarDTO;
import com.carrent.dto.UserDTO;
import com.carrent.service.CarService;
import com.carrent.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
@PreAuthorize(value = "hasAuthority('ADMIN')")
public class AdminController {

    private final CarService carService;
    private final UserService userService;

    public AdminController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }


    @GetMapping("/car/add")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        return "carAdd";
    }

    @PostMapping("/car/add")
    public String addCar(CarDTO car) {
        carService.save(car);
        return "redirect:/admin/cars";
    }

    @GetMapping("/cars")
    public String carListView(Model model) {
       List<CarDTO> carList = carService.findAll();
        model.addAttribute("carList", carList);
        return "carsList";
    }

    @PostMapping("/car/delete/{carId}")
    public String deleteCar(@PathVariable Long carId) {
        carService.delete(carId);
        return "redirect:/admin/cars";
    }

    @GetMapping("/car/edit/{carId}")
    public String carEdit(@PathVariable Long carId, Model model) {
        CarDTO car = carService.getCarById(carId);
        model.addAttribute("car", car);
        return "carEdit";
    }

    @PostMapping("/car/edit")
    public String carEdit(
            @RequestParam Long carId,
            @RequestParam String color,
            @RequestParam String model,
            @RequestParam String plate_num,
            @RequestParam int price,
            @RequestParam String category,
            @RequestParam int year
    ) {
        CarDTO car = carService.getCarById(carId);
        car.setColor(color);
        car.setModel(model);
        car.setPlate_num(plate_num);
        car.setPrice(price);
        car.setCategory(Category.valueOf(category));
        car.setYear(year);
        carService.save(car);
        return "redirect:/admin/cars";
    }


    @GetMapping("/users")
    public String userList(Model model) {
        List<UserDTO> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "userList";
    }

    @PostMapping("/user/delAdmin/{userId}")
    public String deleteAdminRole(@PathVariable Long userId) {
        UserDTO user = userService.findUserById(userId);
        userService.deleteAdminRole(user);
        userService.save(user);
        if (userId.equals(userService.findUserById(userId).getId())) {
            return "redirect:/";
        }
        return "redirect:/admin/users";
    }

    @PostMapping("/user/addAdmin/{userId}")
    public String addAdminRole(@PathVariable Long userId) {
        UserDTO user = userService.findUserById(userId);
        userService.addAdminRole(user);
        userService.save(user);
        return "redirect:/admin/users";
    }

}
