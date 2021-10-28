package com.simplilearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;

    public WebDriverWait applyingExplicitWait(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait;
    }

    public void click(By byObject){
        driver.findElement(byObject).click();
    }

    public void sendKeysValue(By byObject, String data){
        driver.findElement(byObject).sendKeys(data);
    }

    public String getKeysValue(By byObject){
        return driver.findElement(byObject).getText();
    }

    public void sendKeysAndEnter(By byObject, String data){
        driver.findElement(byObject).sendKeys(data);
        driver.findElement(byObject).sendKeys(Keys.ENTER);
    }
}
