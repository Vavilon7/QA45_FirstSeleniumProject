package com.ait.Home.Work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class TestNgDemoShop {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");// открытие сайта без истории
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void openChromeTest() {
        System.out.println("Browser opens!");
    }
    @Test
    public void findElementsByTagName() {
        WebElement element = driver.findElement(By.name("q"));
        System.out.println(element.getText());
    }
    @Test
    public void findElementById(){
        driver.findElement(By.id("bar-notification"));
        driver.findElement(By.id("mob-menu-button"));
        driver.findElement(By.id("dialog-notifications-error"));
        driver.findElement(By.id("topcartlink"));
        driver.findElement(By.id("flyout-cart"));
        driver.findElement(By.id("small-searchterms"));
        driver.findElement(By.id("newsletter-subscribe-block"));
    }
    @Test
    public void findElementByClassName(){
        List<WebElement> elements = driver.findElements(By.className("title"));
        System.out.println(elements.size());
        System.out.println("=========================================");
        WebElement element = driver.findElement(By.className("listbox"));
        System.out.println(element.getText());
        System.out.println("=========================================");
        WebElement element1 = driver.findElement(By.className("footer"));
        System.out.println(element1.getText());
    }
    @Test
    public void findElementByCssSelector(){

        //id -> css - #
        driver.findElement(By.cssSelector("#flyout-cart"));

        //className ->css-.
        driver.findElement(By.cssSelector(".header-links-wrapper"));

        //[key='value']
        driver.findElement(By.cssSelector("[type='button']"));
        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[for='pollanswers-1']"));

        //contains ->*
        driver.findElement(By.cssSelector("[href*='build']"));

        //start with ->^
        driver.findElement(By.cssSelector("[href^='/electronics']"));

    }

    @AfterMethod()

    public void tearDown() {
        driver.quit();
    }
}
