package com.simplilearn.steps;

import com.simplilearn.TestRunnerRegression;
import com.simplilearn.pages.HomePage;
import com.simplilearn.reports.ExtentTestManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.Map;

//Negative test scenario
public class SignUpFormStepdefs {

    HomePage homePage = new HomePage(TestRunnerRegression.testDriver);

    @Given("user has opened swiggy homepage")
    public void userHasOpenedSwiggyHomepage() {
        System.out.println("Opening home page");
        homePage.navigate();
        ExtentTestManager.logInfo("User opens Swiggy homepage..");
    }

    @When("user clicks on the Sign up button on homepage")
    public void userClicksOnTheSignUpButtonOnHomepage() {
        homePage.clickSignupButton();
        ExtentTestManager.logInfo("User clicks on the Sign up button");
    }

    @Then("sign up form opens {string}")
    public void signUpFormOpens(String expectedformheader) {
        String actualformheader = homePage.getFormHeader();
        Assert.assertEquals(actualformheader, expectedformheader);
        ExtentTestManager.logInfo("This test get the header on the signup form : "+expectedformheader);
    }

    @And("user enters following login details")
    public void userEntersFollowingLoginDetails(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        
        String name = dataMap.get("Name");
        String email = dataMap.get("Email");
        String password = dataMap.get("Password");
        
        homePage.setName(name);
        homePage.setEmail(email);
        homePage.setPassword(password);
        ExtentTestManager.logInfo("Following user credentials entered : " +name +", "+email +", "+password);
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        homePage.clickContinueButton();
    }

    @Then("There should be error message in phone number field {string}")
    public void thereShouldBeErrorMessageInPhoneNumberField(String expectederrormessage) {
        String actualerrormessage = homePage.getPhonenumbermessage();
        Assert.assertEquals(actualerrormessage,expectederrormessage);
        ExtentTestManager.logSuccess("Validating the negative test by displaying the message for the field missed : "+expectederrormessage);
    }
}
