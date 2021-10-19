package com.simplilearn.main;

import com.simplilearn.TestRunnerRegression;
import com.simplilearn.steps.SignUpFormStepdefs;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestNGMain {
    static TestNG testNG;
    public static void main(String[] args) {
//        String testngxml = System.getProperty("user.dir")+"/testngRegression.xml";
//        System.out.println("File path" +testngxml);
//        System.out.println("Started!");
//        TestNG testNG = new TestNG();
//        List<String> suites = new ArrayList<>();
//        suites.add(testngxml);
//        testNG.setTestSuites(suites);
//        testNG.run();

        testNG = new TestNG();

        testNG.setTestClasses(new Class[] {TestRunnerRegression.class});
        testNG.run();
    }
}
