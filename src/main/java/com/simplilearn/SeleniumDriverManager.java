package com.simplilearn;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumDriverManager {

    WebDriver driver = null;

    public WebDriver getDriver(String browser){
        if(driver == null){
            setupRemoteWebDriver(browser);
        }
        return driver;
    }

    private void setupRemoteWebDriver(String browserName){
        URL url = null;
        String server = Configuration.getProperty("hubIP");
        String port = Configuration.getProperty("hubPort");
        try {
            url = new URL("http://"+server+":"+port+"/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capabilities = null;
        System.out.println("BrowserName --> "+browserName);

        if(browserName.equals("firefox")){
            capabilities = DesiredCapabilities.firefox();
            capabilities.setBrowserName(browserName);
            capabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(url, capabilities);
        }else if(browserName.equals("chrome")){
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName(browserName);
            capabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(url, capabilities);
        }
    }
}
