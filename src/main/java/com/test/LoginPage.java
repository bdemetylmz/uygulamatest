package com.test;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public  class  LoginPage {
     WebDriver driver;
     WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,20,150);
    }



    @Test
    public void Login(String username,String password){
        driver.get("https://www.gittigidiyor.com/");
        Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",driver.getTitle());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div[1]/div[3]/div/div[1]/div")))).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[2]")))).click();


        driver.findElement(By.id(("gg-login-enter"))).click();
        Assert.assertEquals("Üye Girişi - GittiGidiyor",driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("L-UserNameField")).clear();
        driver.findElement(By.id("L-UserNameField")).sendKeys(username);

        driver.findElement(By.id("L-PasswordField")).clear(); //clear password text area
        driver.findElement(By.id("webDriver.findElement(By.id")).sendKeys(password);

        driver.findElement(By.id("gg-login-enter")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("gg-login-enter"))).click();


        // Arama çubuğunda 'Bilgisayar' ifadesinin aranması
        WebElement searchBox = driver.findElement(By.id("searchData"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.className("searchBtn")).click();

        // Arama sonuç sayfalarında 2. sayfanın açılması ve rastgele bir ürünün açılması
        driver.findElement(By.xpath(".//*[@class='pagination']/a[2]")).click();
        driver.findElement(By.xpath(".//*[@id='p-369374378']/div[1]/a[1]")).click();

        WebElement price= driver.findElement(By.xpath(".//*[@class='newPrice']/ins[1]"));
        String priceText= price.getText();

        // Açılan ürün sayfasında ürünün sepete eklenmesi
        WebElement quantityBox = driver.findElement(By.id("quantity"));
        quantityBox.click();
        quantityBox.clear();
        quantityBox.sendKeys("1");

        WebElement basketBtn = driver.findElement(By.className("btnAddBasket"));
        basketBtn.click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("iconBasket")).click();

        // Ürün sayfasındaki fiyat ile sepetteki fiyatın karşılaştırılması
        WebElement priceBasket= driver.findElement(By.className("price"));
        String priceText2= priceBasket.getText();
        if(priceText.compareTo(priceText2)>0){

            //Sepetteki ürün adetinin artırılması
            WebElement quantityBasket = driver.findElement(By.id("quantity_126686985817"));
            quantityBasket.click();
            quantityBasket.clear();
            quantityBasket.sendKeys("1");
            driver.findElement(By.className("spinnerUp")).click();
        }
        // Sepetteki ürünlerin boşaltılması
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("removeProd")).click();


    }




}
