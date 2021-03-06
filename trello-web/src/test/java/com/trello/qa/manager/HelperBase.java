package com.trello.qa.manager;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {

        this.driver = driver;
    }

    public void waitForElementAndClick(By locator, int time){
       new WebDriverWait(driver, time).
               until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(By locator) {

        driver.findElement(locator).click();
    }

    public void type(By locator, String text) throws InterruptedException {
        if(text!= null){
            Thread.sleep(3000);
            driver.findElement(locator).click();
            Thread.sleep(5000);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }

    }

    public boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.name("add"));
    }

    public void returnToHomePage()  {
        waitElement(By.cssSelector("[name=house]"));
        click(By.cssSelector("[name=house]"));

    }

    public void clickOnPlusButtonOnLeftNavMenu() {

        click(By.cssSelector(".icon-add.icon-sm"));
    }

public void waitElement(By locator){
    int tries = 0;
    try {
    while (!isElementPresent(locator) && tries<100){
            Thread.sleep(100);
        tries++;
    }
    Thread.sleep(200);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
public void takeScreenshot(){
    File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File screen = new File("src/test/resources/Screenshots/screen" + System.currentTimeMillis()+".png");

    try {
        Files.copy(tmp,screen);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
