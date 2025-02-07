package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");// открытие сайта без истории
        //driver.navigate().to("https://ilcarro.web.app");//открытие сайта с историей
        //driver.navigate().back();
        driver.manage().window().maximize();
        //wait for all elements on the website to load before staring test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    public void openChromeTest() {
        System.out.println("Browser opens!");
    }

    @Test
    public void findElementsByTagName() {
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());
        WebElement element1 = driver.findElement(By.tagName("h2"));
        System.out.println(element1.getText());
        WebElement element2 = driver.findElement(By.tagName("a"));
        System.out.println(element2.getText());
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

    }

    @Test
    public void findElementById(){
        driver.findElement(By.id("city"));
        driver.findElement(By.id("dates"));

    }
    @Test
    public void findElementByClassName(){
        WebElement element = driver.findElement(By.className("header"));
        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.className("logo"));
        System.out.println(elements.size());

        WebElement element1 = driver.findElement(By.className("navigation-link"));
        System.out.println(element1.getText());
    }
    @AfterMethod()

    public void tearDown() {
        driver.quit();// закрываются все вкладки
        //driver.close();// закрывает только одна вкладка, текущая
    }
}
