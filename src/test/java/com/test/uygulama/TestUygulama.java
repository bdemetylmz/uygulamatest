package com.test.uygulama;



import com.test.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public  abstract class TestUygulama {
     public WebDriver driver;



    @Before
    public void setup() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "C:/Users/AsusNB/Desktop/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(desiredCapabilities);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @After
    public void tearDown() {

        driver.quit();
    }

}
