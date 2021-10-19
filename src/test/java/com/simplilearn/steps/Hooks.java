package com.simplilearn.steps;

import com.simplilearn.SeleniumDriverManager;
import com.simplilearn.reports.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

 //   public static WebDriver testDriver = null;

    @Before
    public void beforeTest(Scenario scenario){

        String scenarioName = scenario.getName();
        System.out.println("Hooks---> @Before "+scenarioName);
        ExtentTestManager.startTest(scenarioName);
    }

//    @Before
//    public void startupBrowser(){
//        //start the browser
//        System.out.println("Hooks--->@Before startupBrowser()");
//        testDriver = new SeleniumDriverManager().getDriver();
//        testDriver.manage().window().maximize();
//    }

//    @After
//    public void teardownBrowser(){
//        //closing the browser
//        System.out.println("Hooks--->@After");
//        testDriver.quit();
//    }
}
