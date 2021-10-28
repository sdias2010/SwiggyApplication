package com.simplilearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RestaurantsPage extends BasePage{

    public RestaurantsPage(WebDriver driver){
        this.driver=driver;
    }

    By clk_offers = By.xpath("//a[contains(text(), 'Offers')]");
    By txt_offerspagename = By.className("D-teR");

    By clk_search = By.xpath("//span[contains(text(),'Search')]");
    By txt_searchbar = By.className("_2BJMh");

    By clk_restaurantname = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/div[2]");
    By clk_additem = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");

    By txt_restaurantname = By.xpath("//h1[@class='_3aqeL']");


    public void clickOffers(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(clk_offers));
        click(clk_offers);
    }

    public String getTextOnOffersPage(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(txt_offerspagename));
        String offersforyou = getKeysValue(txt_offerspagename);
        return offersforyou;
    }

    public void clickSearch(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(clk_search));
        click(clk_search);
    }

    public void searchTheItem(String item){
        sendKeysAndEnter(txt_searchbar,item);
    }

    public String getRestaurantName(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(clk_restaurantname));
       String restaurantName = getKeysValue(clk_restaurantname);
       return restaurantName;
    }

    public void clickRestaurantName(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(clk_restaurantname));
        click(clk_restaurantname);
    }

    public void clickAddItem(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(clk_additem));
        click(clk_additem);
    }

    public String getRestaurantNameText(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(txt_restaurantname));
        String restaurantname = getKeysValue(txt_restaurantname);
        return restaurantname;
    }
}
