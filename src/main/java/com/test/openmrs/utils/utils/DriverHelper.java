package com.test.openmrs.utils.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {

    //private static variable
    private static WebDriver driver;

    //private Constructor to make sure they do not create an object from this class
    private DriverHelper() {

    }

    public static WebDriver getDriver() {

    //    String browser="chrome";
        //if my driver is not instantiated before
        if(driver==null || ((RemoteWebDriver)driver).getSessionId()==null){
            switch (ConfigReader.readProperty("browser")){
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
            }
      //      driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }


}