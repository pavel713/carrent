package com.carrent.web.controller;

import com.carrent.dto.CarDTO;
import com.carrent.service.CarService;
import com.carrent.service.ExcelService;
import com.carrent.service.helper.ExcelHelper;
import com.carrent.service.message.ResponseMessage;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final ExcelService excelService;

    public CarController(CarService carService, ExcelService excelService) {
        this.carService = carService;
        this.excelService = excelService;
    }

    @GetMapping()
    public String findAllCars(Model model) {
       List<CarDTO> cars = carService.findAll();
        model.addAttribute("carList", cars);
        return "carsList";
    }

    @GetMapping("/excel")
    public ResponseEntity<Resource> getFile() {
        String filename = "cars.xlsx";
        InputStreamResource file = new InputStreamResource(excelService.load());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("applocation/vnd.ms-excel"))
                .body(file);
    }

    @PostMapping("/load")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                excelService.save(file);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Location", "/cars");
                return new ResponseEntity<>(headers, HttpStatus.FOUND);

            } catch (Exception e) {
                message = "Could not upload the file";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }


}






