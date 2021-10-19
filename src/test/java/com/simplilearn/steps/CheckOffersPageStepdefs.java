package com.simplilearn.steps;

import com.simplilearn.TestRunnerRegression;
import com.simplilearn.pages.RestaurantsPage;
import com.simplilearn.reports.ExtentTestManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckOffersPageStepdefs {

    RestaurantsPage restaurantsPage = new RestaurantsPage(TestRunnerRegression.testDriver);

    @Then("user clicks on the offers link")
    public void userClicksOnTheOffersLink() {
        restaurantsPage.clickOffers();
        ExtentTestManager.logInfo("User clicks on the Offers link on the page.");
    }

    @And("user validates the offers page by checking {string}")
    public void userValidatesTheOffersPageByChecking(String expectedresult) {
        String actualresult = restaurantsPage.getTextOnOffersPage();
        Assert.assertEquals(actualresult,expectedresult,"Text does not match");
        ExtentTestManager.logSuccess("User validates the Offers page");
    }
}
