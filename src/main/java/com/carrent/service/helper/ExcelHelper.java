package com.carrent.service.helper;

import com.carrent.dao.entities.Car;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelHelper {

    static String[] HEADERs = { "Id", "Color", "Model", "PLate Number", "Price", "Year" };
    static String SHEET = "Cars";

    public static ByteArrayInputStream carsToExcel(List<Car> cars) {

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet(SHEET);

            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (Car car : cars) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(car.getId());
                row.createCell(1).setCellValue(car.getColor());
                row.createCell(2).setCellValue(car.getModel());
                row.createCell(3).setCellValue(car.getPlate_num());
                row.createCell(4).setCellValue(car.getPrice());
                row.createCell(5).setCellValue(car.getYear());

            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}
