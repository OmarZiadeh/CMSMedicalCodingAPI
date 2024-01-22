package com.example.demo;


import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.json.simple.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CodeController {

    //This needs to modified to server file location
    String PATH = "C:\\ModifyThisPath\\2024_DHS_Code_List_Addendum_11_29_2023.xlsx";

    @GetMapping("/AllCodes")
    public ResponseEntity<Object> AllCodes() throws Exception{
        JSONObject json = new JSONObject();
        FileInputStream file = new FileInputStream(new File(PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            
            //two while loops look scary, but this just iterates through each row and each cell in that row
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();

                findCodes(cell, cellIterator, json);
            }
        }
        
        file.close();
        workbook.close();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/ClinicalLabCodes")
    public ResponseEntity<Object> ClinicalLabCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "CLINICAL LABORATORY SERVICES";
        String endTitle = "PHYSICAL THERAPY, OCCUPATIONAL THERAPY, AND OUTPATIENT SPEECH-LANGUAGE PATHOLOGY SERVICES";
        FileInputStream file = new FileInputStream(new File(PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        boolean isTitle = false;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            
            //two while loops look scary, but this just iterates through each row and each cell in that row
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
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/TherapyCodes")
    public ResponseEntity<Object> TherapyCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "PHYSICAL THERAPY, OCCUPATIONAL THERAPY, AND OUTPATIENT SPEECH-LANGUAGE PATHOLOGY SERVICES";
        String endTitle = "RADIOLOGY AND CERTAIN OTHER IMAGING SERVICES";
        FileInputStream file = new FileInputStream(new File(PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        boolean isTitle = false;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            
            //two while loops look scary, but this just iterates through each row and each cell in that row
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
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/RadiologyCodes")
    public ResponseEntity<Object> RadiologyCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "RADIOLOGY AND CERTAIN OTHER IMAGING SERVICES";
        String endTitle = "RADIATION THERAPY SERVICES AND SUPPLIES";
        FileInputStream file = new FileInputStream(new File(PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        boolean isTitle = false;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            
            //two while loops look scary, but this just iterates through each row and each cell in that row
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
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/RadiationCodes")
    public ResponseEntity<Object> RadiationCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "RADIATION THERAPY SERVICES AND SUPPLIES";
        String endTitle = "PREVENTIVE SCREENING TESTS AND VACCINES";
        FileInputStream file = new FileInputStream(new File(PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        boolean isTitle = false;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            
            //two while loops look scary, but this just iterates through each row and each cell in that row
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
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/PreventativeCodes")
    public ResponseEntity<Object> PreventativeCodes() throws Exception{
        JSONObject json = new JSONObject();
        String title = "PREVENTIVE SCREENING TESTS AND VACCINES";
        FileInputStream file = new FileInputStream(new File(PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        boolean isTitle = false;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            
            //two while loops look scary, but this just iterates through each row and each cell in that row
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                

                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().equals(title)){
                    isTitle = true;
                }

                if(isTitle){
                    findCodes(cell, cellIterator, json);
                }
            }
        }
        
        file.close();
        workbook.close();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }



    public void findCodes(Cell cell, Iterator<Cell> cellIterator, JSONObject json){

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
