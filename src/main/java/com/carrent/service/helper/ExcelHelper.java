package com.carrent.service.helper;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;
import com.carrent.service.CarService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Color", "Model", "PLate Number", "Price", "Year" };
    static String SHEET = "Cars";

    @Autowired
    private CarService carService;


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

                row.createCell(0).setCellValue(car.getColor());
                row.createCell(1).setCellValue(car.getModel());
                row.createCell(2).setCellValue(car.getPlate_num());
                row.createCell(3).setCellValue(car.getPrice());
                row.createCell(4).setCellValue(car.getYear());
                row.createCell(5).setCellValue(car.getCategory().toString());

            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }

    }


    public static Set<Car> excelToCars(InputStream is) {



        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            Set<Car> cars = new HashSet<>();



            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Car car = new Car();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {

                        case 0:
                            car.setColor(currentCell.getStringCellValue());
                            break;

                        case 1:
                            car.setModel(currentCell.getStringCellValue());
                            break;

                        case 2:
                            car.setPlate_num(currentCell.getStringCellValue());
                            break;

                        case 3:
                            car.setPrice((int) currentCell.getNumericCellValue());
                            break;

                        case 4:
                            car.setYear((int) currentCell.getNumericCellValue());
                            break;

                        case 5:
                            car.setCategory(Category.valueOf(currentCell.getStringCellValue()));
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                cars.add(car);
            }

            workbook.close();

            return cars;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }
}

