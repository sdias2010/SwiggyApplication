package com.simplilearn.steps;

import com.simplilearn.TestRunnerRegression;
import com.simplilearn.pages.HomePage;
import com.simplilearn.reports.ExtentTestManager;
import com.simplilearn.utils.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class EnterDeliveryLocationStepdefs {

    HomePage homePage = new HomePage(TestRunnerRegression.testDriver);

    String projectFolderpath = System.getProperty("user.dir");
    //String excelFilePath = projectFolderpath + "/datafiles/datafile.xlsx";
    String excelFilePath = "/resources/datafiles/datafile.xlsx"; //setup for jar file
    ExcelReader reader = new ExcelReader();

    @When("user enters the location from the sheet {string} and {int}")
    public void userEntersTheLocationFromTheSheetAnd(String sheetName, Integer rowNumber) throws Throwable {
        List<Map<String,String>> testData = reader.getData(excelFilePath,sheetName);
        String location = testData.get(rowNumber).get("Location");
        homePage.setDeliveryLocation(location);
        ExtentTestManager.logInfo("User Enters location "+location);
    }

    @Then("user selects the first location from dropdown list")
    public void userSelectsTheFirstLocationFromDropdownList() {
        homePage.clickFirstLocationValue();
        ExtentTestManager.logInfo("User selects the first location from the dropdown list");
    }

    @And("user lands on the restaurants page {string} and {int}")
    public void userLandsOnTheRestaurantsPageAndRowNumber(String sheetName, Integer rowNumber) throws Throwable {
        List<Map<String,String>> testData = reader.getData(excelFilePath,sheetName);
        String expectedResult = testData.get(rowNumber).get("ExpectedResults");
        String actualResult = homePage.verifyTextOnthepage().substring(25,36);
        Assert.assertEquals(actualResult, expectedResult,"Text does not match");
        ExtentTestManager.logSuccess("User lands on the restaurants page.");
    }
}
