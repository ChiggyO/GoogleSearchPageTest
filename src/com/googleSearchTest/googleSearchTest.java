package com.googleSearchTest;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;


public class googleSearchTest {

    static String baseUrl = "https://www.google.com/";

    public static void main(String args[]) throws NullPointerException, InterruptedException {

        // System.setProperty("webdriver.chrome.driver", "d://chromedriver_Old.exe");
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);// 5 seconds

        driver.manage().window().maximize();
        driver.get(baseUrl);

        //You can comment these lines if you do not have to change language to English
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("English")));
        WebElement engButton = driver.findElement(By.linkText("English"));
        engButton.click();
        System.out.println("Clicked on english button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        WebElement searchButton = driver.findElement(By.name("q"));
        searchButton.sendKeys(new String[]{"programming"});
        searchButton.submit();
        System.out.println("Clicked on submit button");

        // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("res")));
        // String link1 = driver.findElement(By.id("res")).getText();

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("res")));
        //String link2 = driver.findElement(By.id("res")).getText();

        //System.out.println("*******The google results are listed below *******");
        //System.out.println(link2);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rso")));
        String link1 = driver.findElement(By.id("rso")).getText();
        System.out.println("*******The google results for page one are listed below *******");
        System.out.println(link1);
        //String results = String.valueOf(driver.findElement(By.id("res")));
        //System.out.println(results);
        System.out.println("*******The google results for page one are listed above *******");

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("2")));
        WebElement pageTwo = driver.findElementByLinkText("2");
        pageTwo.click();
        System.out.println("Clicked on page 2");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("res")));
        String link3 = driver.findElement(By.id("res")).getText();
        System.out.println("+++++++++++++++++ The google results for page two are listed below ++++++++++++++");
        System.out.println(link3);
        System.out.println("+++++++++++++++ The google results for page two are listed above +++++++++++++++++");

        driver.close();

    }
}
