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

public class FindElementTests {
WebDriver driver;

@BeforeMethod
    public void setUp(){
    driver = new ChromeDriver();
    driver.get("https://ilcarro.web.app");
    driver.manage().window().maximize(); //разворачиваем на весь экран
    //set implicit timeout
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //время ожидания загрузки всех элементов сайта.
}

@Test
    public void findElementTest (){
    WebElement h1Element = driver.findElement(By.tagName("h1")); //ищем элемент
    System.out.println(h1Element.getText());
    List<WebElement> aElements = driver.findElements(By.tagName("a"));  //ищем элементы
    System.out.println(h1Element.getSize());
    WebElement cityElement = driver.findElement(By.id("city"));
    System.out.println(cityElement.getLocation());
    WebElement inputLableElement = driver.findElement(By.className("input-label"));
    System.out.println(inputLableElement.getLocation());
    driver.findElement(By.name("viewport"));
    driver.findElement(By.linkText("Let the car work"));
    driver.findElement(By.partialLinkText("work"));
}
@Test
public void findElementByCssTest(){
    //css = tag
    //driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("h1"));
    //id->#ccs
    driver.findElement(By.cssSelector("#city"));
    //classname - > css(.)
    driver.findElement(By.cssSelector(".input-label"));
//attr + parametr -> css "[='']"
    driver.findElement(By.cssSelector("[name='viewport']"));
    //css - containts(*)
    driver.findElement(By.cssSelector("[class*='pristine']"));
    //css - start (^)
    driver.findElement(By.cssSelector("[class^='ng']"));
    //css - end on ($);
    driver.findElement(By.cssSelector("[class$='input']"));
}


@Test
public void findElementXpathTests(){
    //*[@attr='par']
    driver.findElement(By.xpath("//h1"));  //
    driver.findElement(By.xpath("//input[@id='city']"));
    driver.findElement(By.xpath("//label[@class='input-label']"));
    //text -> xpath //*[contains(.,'text')]
    driver.findElement(By.xpath("//h2[contains(.,'Type your data and hit Yalla!')]"));
    //start -> //*[start-with (@attr, 'text')
    driver.findElement(By.xpath("//h2[contains(.,'Type your data and hit Yalla!')]"));

}


@AfterMethod
    public void tierDown(){
driver.quit();
}
}

