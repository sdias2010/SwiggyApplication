package com.simplilearn.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTestManager {

    static ExtentReports extentReports;
    static ExtentTest extentTest;

    public static void setExtentReports(String path){
        if(extentReports == null){
            extentReports = new ExtentReports(path);
        }
    }

    public static ExtentReports getExtentReports(){
        return extentReports;
    }

    public static ExtentTest getTest(){
        return extentTest;
    }

    public static void flushReport(){
        getExtentReports().flush();
    }

    public static void startTest(String nameOfTest){
        extentTest = getExtentReports().startTest(nameOfTest);
    }

    public static void endTest(){
        getExtentReports().endTest(extentTest);
    }

    public static void logInfo(String message){
        getTest().log(LogStatus.INFO, message);
    }

    public static void logSuccess(String message){
        getTest().log(LogStatus.PASS, message);
    }

    public static void logFailure(String message){
        getTest().log(LogStatus.FAIL, message);
    }

    public static void logSkipped(String message){
        getTest().log(LogStatus.SKIP, message);
    }

    public static void logError(String message){
        getTest().log(LogStatus.FATAL, message);
    }
}
