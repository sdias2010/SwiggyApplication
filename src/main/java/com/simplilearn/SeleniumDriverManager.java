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

//    public void setupDriver(String browser){
//        String browserType = Configuration.getProperty("browserType");
//        switch (browserType){
//            case "CHROME":
//                System.out.println("RUNNING CHROME BROWSER!!");
//                driver = setupChromeDriver(browser);
//            case "REMOTE":
//                System.out.println("RUNNING REMOTE BROWSER");
//                setupRemoteWebDriver(browser);
//        }
//    }

    private void setupRemoteWebDriver(String browserName){
        URL url = null;
        String server = Configuration.getProperty("hubIP");
        String port = Configuration.getProperty("hubPort");
//        String browserName = Configuration.getProperty("browserName");
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

//    private ChromeDriver setupChromeDriver(String browser){
//        System.out.println("setupChromeDriver --> " +browser);
//        String projectFolderPath = System.getProperty("user.dir");
//        String chromeDriverPath = projectFolderPath + "/drivers/chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//        return new ChromeDriver();
//    }
}
