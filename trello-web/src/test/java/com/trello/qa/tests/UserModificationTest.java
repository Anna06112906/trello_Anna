package com.trello.qa.tests;

import org.testng.annotations.Test;

public class UserModificationTest extends TestBase {
    @Test
    public void changeAvatarTest() throws InterruptedException {
        app.getUserHelper().clickOnAvatar();
        app.getUserHelper().openOrofileFromDropDown();
        app.getUserHelper().initAvatarChanging();
        app.getUserHelper().addPicture();
    }
}
