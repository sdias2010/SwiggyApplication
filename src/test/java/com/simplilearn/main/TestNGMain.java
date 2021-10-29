package com.simplilearn.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;


public class TestNGMain {

    public static void main(String[] args){

        TestNG testNG = new TestNG();

        String testngxml = "/resources/testngRegression.xml";

        InputStream testinputstream = TestNG.class.getResourceAsStream(testngxml);


        List<XmlSuite> suite;

        try {
            suite = (List<XmlSuite>)new Parser(testinputstream).parse();

            System.out.println("Suites Name :- " +suite.toString());

            testNG.setXmlSuites(suite);


            testNG.run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}