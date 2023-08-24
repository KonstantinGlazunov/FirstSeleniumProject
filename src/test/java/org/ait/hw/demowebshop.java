package org.ait.hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class demowebshop {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void byCssTest() {
        driver.findElements(By.className("item-box"));
        driver.findElements(By.cssSelector(".item-box"));
        driver.findElement(By.id("bar-notification"));
        driver.findElement(By.cssSelector("#bar-notification"));
        driver.findElement(By.cssSelector("form"));
        driver.findElement(By.cssSelector("[action='/search']"));
        driver.findElements(By.cssSelector("[class*='selector']"));
        driver.findElements(By.cssSelector("[class^='master']"));
        driver.findElements(By.cssSelector("[class$='error']"));
        driver.findElement(By.linkText("Sitemap"));
    }

    @Test
    public void byXpathTest(){
        driver.findElement(By.xpath("//form"));
        driver.findElements(By.xpath("//div[@class='item-box']"));
        driver.findElements(By.xpath("//div[@id='bar-notification']"));
        driver.findElement(By.xpath("//form[@action='/search']"));
        driver.findElement(By.xpath("//div[@class='item-box']"));
        driver.findElement(By.xpath("//*[@id='bar-notification']"));
        driver.findElements(By.xpath("//*[contains(@class,'selector')]"));
        driver.findElements(By.xpath("//*[starts-with (@class, 'master')]"));
        driver.findElements(By.xpath("//*[contains(@id, 'error')]"));
        driver.findElement(By.xpath("//a[text()='Sitemap']"));



    }


    @AfterMethod
    public void tierDown() {
        driver.quit();
    }

}
