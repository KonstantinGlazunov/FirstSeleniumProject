package org.ait.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TableTeasts {
    WebDriver driver;
    //before - setUp - инициализируется переменная, создается новый инстанс
    @BeforeMethod

        public void setUp(){
            driver = new ChromeDriver();
            driver.get("https://www.w3schools.com/css/css_table.asp");
            driver.manage().window().maximize(); //разворачиваем на весь экран
            //set implicit timeout
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //время ожидания загрузки всех элементов сайта.
    }

    @Test
    public void tableByCssTest () {
        //numbers of rows
        List<WebElement> tr = driver.findElements(By.cssSelector("tr"));
        System.out.println("Roes in table -->" + tr.size());
        System.out.println("==============================");
        for (int i = 0; i < tr.size(); i++) {
            System.out.println(tr.get(i).getText());
        }

        System.out.println("==============================");

        List<WebElement> trTh = driver.findElements(By.cssSelector("tr th"));
        System.out.println("Colums in tables -->" + trTh.size());
        List<WebElement> row3 = driver.findElements(By.cssSelector(" tr:nth-child(3) td"));
        for (WebElement el:row3
             ) {
            System.out.println("row3: "+ el.getText());
        }
        System.out.println("====================================");
        List<WebElement> lastChildRow = driver.findElements(By.cssSelector("  tr td:last-child"));
        for (WebElement el:lastChildRow
             ) {
            System.out.println("lastChildRow: " + el.getText());
            System.out.println("====================================");
            System.out.println(driver.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)")).getText());
            System.out.println("====================================");
        }

    }

@Test
public void tableXpathTest() {
    List<WebElement> tr = driver.findElements(By.xpath("//tr"));
    System.out.println("Roes in table -->" + tr.size());
    System.out.println("==============================");
    for (int i = 0; i < tr.size(); i++) {
        System.out.println(tr.get(i).getText());
    }
    System.out.println("==============================");

    List<WebElement> trTh = driver.findElements(By.xpath("//tr/th"));
    System.out.println("Colums in tables -->" + trTh.size());
    List<WebElement> row3 = driver.findElements(By.xpath("//tr[3]//td"));
    for (WebElement el:row3
    ) {
        System.out.println("row3: "+ el.getText());
    }
    System.out.println("====================================");
    List<WebElement> lastChildRow = driver.findElements(By.xpath("//tr/td[last()]"));
    for (WebElement el:lastChildRow
    ) {
        System.out.println("lastChildRow: " + el.getText());
        System.out.println("====================================");
        System.out.println(driver.findElement(By.xpath("//td[text()='Maria Anders']")).getText());
        System.out.println(driver.findElement(By.xpath("//td[contains(.,'Maria')]")).getText());
        System.out.println("====================================");
    }

}



@AfterMethod
    public void tierDown(){
        driver.quit();
    }

}
