package com.simplilearn.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    private XSSFWorkbook openWorkbook(String excelFilePath) throws Throwable{
        File excelFile = new File(excelFilePath);
        FileInputStream excelFileStream = new FileInputStream(excelFile);
        return new XSSFWorkbook(excelFileStream);
    }

    public XSSFSheet getSheetByIndex(String excelFilePath, int sheetIndex) throws Throwable{
        XSSFWorkbook workbook = openWorkbook(excelFilePath);
        return workbook.getSheetAt(sheetIndex);
    }

    public XSSFSheet getSheetByName(String excelFilePath, String sheetName) throws Throwable {
        XSSFWorkbook workbook = openWorkbook(excelFilePath);
        return workbook.getSheet(sheetName);
    }

    public List<Map<String,String>> getData(String excelFilePath, String sheetName) throws Throwable {
        XSSFSheet sheet = getSheetByName(excelFilePath, sheetName);
        return ReadExcelSheet(sheet);
    }

    private List<Map<String, String>> ReadExcelSheet(XSSFSheet sheet){
       int lastRowIndex = sheet.getLastRowNum();
       int startRowIndex = 1;

        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

       for(int curRowIndex =startRowIndex; curRowIndex<=lastRowIndex; curRowIndex++){
           XSSFRow row = sheet.getRow(curRowIndex);
           int lastCellNum = row.getLastCellNum();

           LinkedHashMap<String, String> cellMapData = new LinkedHashMap<String, String>();

           for(int curCellIndex=1;curCellIndex<lastCellNum;curCellIndex++){
               cellMapData.putAll(getCellValue(sheet,row,curCellIndex));
           }
           excelRows.add(cellMapData);
       }
       return excelRows;
    }

    private LinkedHashMap<String, String> getCellValue(XSSFSheet sheet, XSSFRow row, int curCol){
        LinkedHashMap<String, String> colMapdata = new LinkedHashMap<String, String>();

        XSSFCell cell = row.getCell(curCol);
        String colHeaderData = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
        switch (cell.getCellType()){
            case STRING:
                colMapdata.put(colHeaderData,cell.getStringCellValue());
                break;
            case NUMERIC:
                colMapdata.put(colHeaderData, String.valueOf(cell.getNumericCellValue()));
                break;
        }
        return colMapdata;
    }

//    public static void main(String[] args) throws Throwable {
//        String projectFolderpath = System.getProperty("user.dir");
//        String excelFilePath = projectFolderpath + "/datafiles/datafile.xlsx";
//
//        XSSFWorkbook workbook = openWorkbook(excelFilePath);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//
//        List<Map<String, String>> testData = ReadExcelSheet(sheet);
//        System.out.println(testData.get(0).get("Location"));
//
//
//    }
}
