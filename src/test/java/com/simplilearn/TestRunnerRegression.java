package com.simplilearn;

import com.simplilearn.reports.ExtentTestManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@CucumberOptions(
        //features = "classpath:features",
        features = "classpath:resources/features",  //setup for jar file
        glue = "com.simplilearn.steps",
        tags = "@Sanity",
        plugin = {"pretty",
                "html:reports/cucumber/cucumber-report.html",
                "json:reports/cucumber/cucumber-report.json"}
)

public class TestRunnerRegression extends AbstractTestNGCucumberTests {

    public static WebDriver testDriver = null;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("TestRunner----> @BeforeSuite");
        String pathOfProject = System.getProperty("user.dir");
        ExtentTestManager.setExtentReports(pathOfProject+"/reports/extent/extentReport.html");
    }
    @DataProvider
    @Override
    public Object[][] scenarios(){return super.scenarios();}

    @BeforeMethod
    @Parameters({"browser"})
    public void startupBrowser(String browser){
        System.out.println("TestRunner----> @BeforeMethod " +browser);
        testDriver = new com.simplilearn.SeleniumDriverManager().getDriver(browser);
        testDriver.manage().window().maximize();
    }

    @AfterMethod
    public void teardownBrowser(){
        //closing the browser
        System.out.println("TestRunner--->@AfterMethod");
        testDriver.quit();
    }

//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("TestRunner---->@AfterSuite");
//        ExtentTestManager.flushReport();
//    }
}
