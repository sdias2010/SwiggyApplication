package com.simplilearn.steps;

import com.simplilearn.TestRunnerRegression;
import com.simplilearn.pages.HomePage;
import com.simplilearn.pages.RestaurantsPage;
import com.simplilearn.reports.ExtentTestManager;
import com.simplilearn.utils.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class SearchPageStepdefs {

    HomePage homePage = new HomePage(TestRunnerRegression.testDriver);

    RestaurantsPage restaurantsPage = new RestaurantsPage(TestRunnerRegression.testDriver);

    String projectFolderpath = System.getProperty("user.dir");
    //String excelFilePath = projectFolderpath + "/datafiles/datafile.xlsx";
    String excelFilePath = "/resources/datafiles/datafile.xlsx"; //setup for jar file
    ExcelReader reader = new ExcelReader();

    String restaurantName;

    @When("user enters the location {string}")
    public void userEntersTheLocation(String location) {

        homePage.setDeliveryLocation(location);
        ExtentTestManager.logInfo("User enters the location.");
    }

    @Then("user clicks on the search link")
    public void userClicksOnTheSearchLink() {

        restaurantsPage.clickSearch();
        ExtentTestManager.logInfo("User clicks on the search link.");
    }


    @And("user enters the search item from the sheet {string} and {int}")
    public void userEntersTheSearchItemFromTheSheetAndRowNumber(String sheetName, int rowNumber) throws Throwable {
        List<Map<String,String>> testData = reader.getData(excelFilePath,sheetName);
        String foodName = testData.get(rowNumber).get("FoodName");
        restaurantsPage.searchTheItem(foodName);
        ExtentTestManager.logInfo("User enters the search item from the excel sheet");
    }

    @Then("user clicks on first restaurant")
    public void userClicksOnFirstRestaurant() {
        restaurantName = restaurantsPage.getRestaurantName();
        restaurantsPage.clickRestaurantName();
        ExtentTestManager.logInfo("User clicks on first restaurant.");
    }

    @And("user adds the item to cart")
    public void userAddsTheItemToCart() {
        restaurantsPage.clickAddItem();
        ExtentTestManager.logInfo("User adds the item to cart.");
    }

    @And("user validates the restaurant name")
    public void userValidatesTheRestaurantName() {
        String actualname = restaurantName;
        String expectedname = restaurantsPage.getRestaurantNameText();

        Assert.assertTrue(actualname.contains(expectedname));
        ExtentTestManager.logSuccess("User validates the restaurant name");
    }
}
