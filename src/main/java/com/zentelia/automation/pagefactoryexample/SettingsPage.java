package com.zentelia.automation.pagefactoryexample;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by martin-pierreroy on 2017-03-01.
 */


public class SettingsPage {

    //Define Maximum tags in cloud check box
    @FindBy(how=How.ID,using="accountprefs_tagssideblockmaxtags")
    private WebElement maximumTagsInCloud;

    //Define Save Button
    @FindBy(how=How.ID,using="accountprefs_submit")
    private WebElement saveButton;

    //Define Preference saved text
    @FindBy(how=How.XPATH,using="//div[contains(text(),'Preferences saved']")
    private WebElement preferenceSavedMessage;

    //Define Logout Link
    @FindBy(how=How.LINK_TEXT,using="Logout")
    private WebElement logoutLink;

    //Define Click Save Button Method
    public void ClickSave()
    {
        saveButton.click();
    }

    //Define Maximum tags in Cloud Enter Number Method
    public void EnterMaximumTagsInCloud(String inputNumber)
    {
        maximumTagsInCloud.sendKeys(inputNumber);
    }
    //Define preference saved confirmation
    public boolean VerifyPreferenceSavedMessage()
    {
        return preferenceSavedMessage.isDisplayed();
    }

    //Define logout click method
    public void ClickLogout()
    {
        logoutLink.clear();
    }
}
