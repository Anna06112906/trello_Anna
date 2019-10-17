package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void openOrofileFromDropDown() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void initAvatarChanging() {
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector(".rsiNque2CCqtPE")))
                .click().perform();
    }

    public void addPicture() throws InterruptedException {
        attach(new File("C:/Users/pc/Documents/GitHub/trello_Anna/trello-web/src/test/resources/Logs/fW0B7mVg.jpeg"));
        Thread.sleep(10000);
    }

    private void attach(File file) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.name("file")).sendKeys(file.getAbsolutePath());
    }
}
