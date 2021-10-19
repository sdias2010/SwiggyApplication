package com.simplilearn.steps;

import com.simplilearn.TestRunnerRegression;
import com.simplilearn.apis.SearchAPI;
import com.simplilearn.pages.HomePage;
import com.simplilearn.reports.ExtentTestManager;
import com.simplilearn.utils.ExcelReader;
import com.simplilearn.utils.RestApiCalls;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class RestApiTestStepdefs {

    HomePage homePage = new HomePage(TestRunnerRegression.testDriver);

    String projectFolderpath = System.getProperty("user.dir");
    String excelFilePath = projectFolderpath + "/datafiles/datafile.xlsx";
    ExcelReader reader = new ExcelReader();

    String[] responseCodeAndMessage;

    @Given("user opens the swiggy home page")
    public void userOpensTheSwiggyHomePage() {
        homePage.navigate();
    }

    @When("user hits search restaurant api by using data from {string} and {int}")
    public void userHitsSearchRestaurantApiByUsingDataFromAndRowNumber(String sheetName, int rowNumber) throws Throwable {
        List<Map<String,String>> testData = reader.getData(excelFilePath,sheetName);
        String restaurantName = testData.get(rowNumber).get("RestaurantName");

        String restnamewitoutspace = restaurantName.replaceAll("\\s+","%20");
        String url = SearchAPI.getSearchApiUrl(restnamewitoutspace);
        responseCodeAndMessage = RestApiCalls.getRequest(url);
        ExtentTestManager.logInfo("User Hits Search Restaurant Api");
    }

    @Then("user validates the response code from {string} and {int}")
    public void userValidatesTheResponseCodeFromAndRowNumber(String sheetName, int rowNumber) throws Throwable {
        List<Map<String,String>> testData = reader.getData(excelFilePath,sheetName);
        String expectedResponseCode = testData.get(rowNumber).get("ResponseCode");

        String actualResponseCode = responseCodeAndMessage[0];
        Assert.assertEquals(actualResponseCode, expectedResponseCode);
        ExtentTestManager.logSuccess("User validates the response code");
    }

    @And("user validates the response message from {string} and {int}")
    public void userValidatesTheResponseMessageFromAndRowNumber(String sheetName, int rowNumber) throws Throwable {
        List<Map<String,String>> testData = reader.getData(excelFilePath,sheetName);
        String expectedResponse = testData.get(rowNumber).get("ResponseMessage");
        String actualResponse = responseCodeAndMessage[1];

        Assert.assertTrue(actualResponse.contains(expectedResponse));
        ExtentTestManager.logSuccess("User validates the response message");
    }
}
