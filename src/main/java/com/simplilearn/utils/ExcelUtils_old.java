package com.simplilearn.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils_old {

    public static XSSFWorkbook openWorkbook(String excelFilePath) throws IOException {
        File excelFile = new File(excelFilePath);
        FileInputStream excelFileStream = new FileInputStream(excelFile);
        return new XSSFWorkbook(excelFileStream);
    }

    public static XSSFSheet getSheet(String excelFilePath, int sheetIndex) throws IOException {
        XSSFWorkbook workbook = openWorkbook(excelFilePath);
        return workbook.getSheetAt(sheetIndex);
    }

    public static List<Map<String, String>> ReadExcelSheet(XSSFSheet sheet){
        XSSFRow row;
        int totalRow = sheet.getPhysicalNumberOfRows();
        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();

        int totalCol = sheet.getRow(0).getLastCellNum();

        for(int curRow=1;curRow <= totalRow;curRow++){

            row = getRow(sheet, sheet.getFirstRowNum() + curRow);

            LinkedHashMap<String, String> cellMapData = new LinkedHashMap<String, String>();

 //           System.out.println("row.getLastCellNum() --> "+row.getLastCellNum());
            for(int curCell=1;curCell<totalCol;curCell++){
                System.out.println("getCellValue(sheet,row,curCell) --> " +getCellValue(sheet,row,curCell));
                cellMapData.putAll(getCellValue(sheet,row,curCell));
            }
            excelRows.add(cellMapData);
        }
        return excelRows;
    }

    public static XSSFRow getRow(XSSFSheet sheet, int rowNumber){
        return sheet.getRow(rowNumber);
    }


    public static LinkedHashMap<String, String> getCellValue(XSSFSheet sheet, XSSFRow row, int curCol){

        LinkedHashMap<String, String> colMapdata = new LinkedHashMap<String, String>();
//        XSSFCell cell = row.getCell(curCol);
        XSSFCell cell;
//        System.out.println(row.getCell(curCol)+ "  "+ cell.getCellType());
        if(row == null){
            String colHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(curCol).getStringCellValue();
            colMapdata.put(colHeaderName,"");
        }else{
            cell = row.getCell(curCol);
            if(cell.getCellType() == CellType.STRING){
                String colHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
                System.out.println("colHeaderName -->"+colHeaderName + "  cell.getStringCellValue()--> "+cell.getStringCellValue());
                colMapdata.put(colHeaderName,cell.getStringCellValue());
            }
        }
        return colMapdata;
    }

    public static void main(String[] args) throws IOException {
        String projectFolderpath = System.getProperty("user.dir");
        String excelFilePath = projectFolderpath + "/datafiles/datafile.xlsx";

        XSSFWorkbook workbook = openWorkbook(excelFilePath);
        XSSFSheet sheet = workbook.getSheetAt(0);

        List<Map<String, String>> testData = ReadExcelSheet(sheet);

        System.out.println("TestData-->" +testData.get(2).get("Location"));



    }
}
