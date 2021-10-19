package com.simplilearn.pages;

import com.simplilearn.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    String homePageUrl = Configuration.getProperty("HOME_PAGE_URL");
    By btn_signup = By.xpath("//a[contains(text(),'Sign up')]");
    By txt_name = By.id("name");
    By txt_email = By.id("email");
    By txt_password = By.id("password");
    By txt_phonemessage = By.xpath("//label[contains(text(),'Enter your phone number')]");
    By txt_formheader = By.xpath("//div[contains(text(),'Sign up')]");
    By btn_continue = By.linkText("CONTINUE");
    By txt_deliverylocation = By.id("location");
    By clk_firstlocationvalue = By.xpath("//div[@class='_3lmRa' and @tabindex='2']");
    By txt_restaurants = By.xpath("//div[contains(text(),'restaurants')]");


    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void navigate(){
        driver.get(homePageUrl);
    }

    public void clickSignupButton(){
        click(btn_signup);
    }

    public void setName(String _name){
        sendKeysValue(txt_name, _name);
    }

    public void setEmail(String _email){
        sendKeysValue(txt_email, _email);
    }

    public void setPassword(String _password){
        sendKeysValue(txt_password, _password);
    }

    public void clickContinueButton(){
        click(btn_continue);
    }

    public String getPhonenumbermessage(){
        String error_message = getKeysValue(txt_phonemessage);
        return error_message;
    }

    public String getFormHeader(){
        String formheader = getKeysValue(txt_formheader);
        return formheader;
    }

    public void setDeliveryLocation(String _location){
        sendKeysValue(txt_deliverylocation, _location);
    }

    public void clickFirstLocationValue(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(clk_firstlocationvalue));
        click(clk_firstlocationvalue);

    }

    public String verifyTextOnthepage(){
        return getKeysValue(txt_restaurants);
    }
}
