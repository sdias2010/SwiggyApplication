package com.simplilearn.steps;

import com.simplilearn.reports.ExtentTestManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeTest(Scenario scenario){

        String scenarioName = scenario.getName();
        System.out.println("Hooks---> @Before "+scenarioName);
        ExtentTestManager.startTest(scenarioName);
    }
}
