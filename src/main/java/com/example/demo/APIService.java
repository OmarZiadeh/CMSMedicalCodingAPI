package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.springframework.cache.annotation.Cacheable;

public class APIService {

    public static void iterateFileTitles(String title, String endTitle, JSONObject json) throws Exception{
        FileInputStream file = new FileInputStream(new File(Constants.PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(Constants.FIRSTPAGE);
        Iterator<Row> rowIterator = sheet.iterator();
        boolean isTitle = false;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                

                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().equals(title)){
                    isTitle = true;
                }
                else if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().equals(endTitle)){
                    isTitle = false;
                    break;
                }

                if(isTitle){
                    findCodes(cell, cellIterator, json);
                }
            }
        }
        file.close();
        workbook.close();
    }

    @Cacheable("AllCodes")
    public static void iterateEntireFile(JSONObject json) throws Exception{
        FileInputStream file = new FileInputStream(new File(Constants.PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(Constants.FIRSTPAGE);
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();

                APIService.findCodes(cell, cellIterator, json);
            }
        }
        
        file.close();
        workbook.close();
    }

    public static void iterateLastSection(String title, JSONObject json) throws Exception{
        FileInputStream file = new FileInputStream(new File(Constants.PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(Constants.FIRSTPAGE);
        Iterator<Row> rowIterator = sheet.iterator();
        boolean isTitle = false;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                

                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().equals(title)){
                    isTitle = true;
                }

                if(isTitle){
                    APIService.findCodes(cell, cellIterator, json);
                }
            }
        }
        
        file.close();
        workbook.close();
    }


    public static void findCodes(Cell cell, Iterator<Cell> cellIterator, JSONObject json){
        Pattern pattern = Pattern.compile("[A-Z0-9]{5}");
        Matcher matcher;

        switch(cell.getCellType()){
            case STRING:
                matcher = pattern.matcher(cell.getStringCellValue());
                if(matcher.find() && cell.getStringCellValue().trim().length() == 5){
                    String code = cell.getStringCellValue().trim();
                    cell = cellIterator.next();
                    String description = cell.getStringCellValue().trim();
                    json.put(code, description);    
                }
                break;

            case NUMERIC:
                matcher = pattern.matcher(Integer.toString((int)cell.getNumericCellValue()));
                if(matcher.find() && Integer.toString((int)cell.getNumericCellValue()).trim().length() == 5){
                    String code = Integer.toString((int)cell.getNumericCellValue()).trim();
                    cell = cellIterator.next();
                    String description = cell.getStringCellValue().trim();
                    json.put(code, description);
                }
                break;
        }
    }
}
