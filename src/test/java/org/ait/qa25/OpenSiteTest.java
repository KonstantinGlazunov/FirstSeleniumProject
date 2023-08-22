package org.ait.qa25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {
    WebDriver driver;
    //before - setUp - инициализируется переменная, создается новый инстанс
    @BeforeMethod
    public void setUp(){
driver = new ChromeDriver();
// driver.get("https://www.google.de/");  //без истории
        driver.navigate().to("https://www.google.de/");  //с историей
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
    //tests - open google test

    @Test
    public void openGoogleTest(){
        System.out.println("Site opened!");
    }
    //after - tearDown - браузер закрывается

    @AfterMethod
    public void tearDown() {
        driver.close(); // закрывает текущую вкладку
        driver.quit();  //закрывает все вкладки
    }

}
