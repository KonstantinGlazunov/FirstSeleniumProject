package org.ait.hw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demowebshopSiteTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
driver.navigate().to("https://demowebshop.tricentis.com/apparel-shoes");
driver.navigate().refresh();
driver.navigate().back();
driver.navigate().refresh();
driver.navigate().forward();
    }
@Test
public void demowebshopOpenTest(){
    System.out.println("demowebshop  opened!");
}

    @AfterMethod
    public void tearDown () {
        driver.close();
        driver.quit();
        System.out.println("Test done");
    }

}
