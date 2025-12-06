package com.securebankdemo.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReaderUtlility {

public static Object[][] getSheetData(String filePath, String sheetName) {

    try (FileInputStream fis = new FileInputStream(filePath);
         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        int rows = sheet.getPhysicalNumberOfRows();
        if (rows == 0) {
            throw new RuntimeException("The sheet is empty!");
        }

        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            throw new RuntimeException("Header row (row 0) is empty!");
        }

        int cols = headerRow.getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {  
            
            Row row = sheet.getRow(i);
            
            for (int j = 0; j < cols; j++) {
                Cell cell = (row == null) ? null : row.getCell(j);
                data[i - 1][j] = getCellValue(cell);
            }
        }
        return data;

    } catch (IOException e) {
        throw new RuntimeException("Unable to read excel file: " + e.getMessage());
    }
}

private static Object getCellValue(Cell cell) {
    if (cell == null) {
        return "";
    }
    switch (cell.getCellType()) {
        case STRING:
            return cell.getStringCellValue();
        case NUMERIC:
            return cell.getNumericCellValue();
        case BOOLEAN:
            return cell.getBooleanCellValue();
        default:
            return "";
    }
}
}
