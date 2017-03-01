import com.zentelia.automation.pagefactoryexample.DashboardPage;
import com.zentelia.automation.pagefactoryexample.LoginPage;
import com.zentelia.automation.pagefactoryexample.SettingsPage;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

/**
 * Created by martin-pierreroy on 2017-03-01.
 */

import static org.testng.AssertJUnit.assertTrue;

public class TestRunner {
    private WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", "/Users/martin-pierreroy/Devl/Librairies/selenium/geckodriver");

        driver=new FirefoxDriver();
        driver.navigate().to("http://demo.mahara.org");
        driver.manage().window().maximize();
    }

    @Test
    public void LoginTest() {
        System.out.println("************* M P R ***************");

        //Initialize Login Page
        LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
        //Enter user name
        loginPage.EnterUserName("student1");
        //Enter Password
        loginPage.EnterPassword("Testing1");
        //Click Login Button
        loginPage.ClickLoginButton();
    }

    @Test
    public void DashboardTest() throws InterruptedException
    {
        Thread.sleep(5000);
//Initialize Dashboard Page
        DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
//Wait for settings link
        dashboardPage.WaitForSettingLinkToDisplay(driver);
//Click on Settings
        dashboardPage.ClickSettings();
    }

    @Test
    public void UserSettingsTest() throws InterruptedException
    {
        Thread.sleep(5000);
        //Initialize User Settings Page
        SettingsPage settingsPage=PageFactory.initElements(driver, SettingsPage.class);
        //Enter Maximum Tags in Cloud Number
        settingsPage.EnterMaximumTagsInCloud("40");
        //Click Save
        settingsPage.ClickSave();
        //Verify Preference Saved Message
        assertTrue(settingsPage.VerifyPreferenceSavedMessage());
        //Click Logout link
        settingsPage.ClickLogout();
    }

    @AfterClass
    public void afterClass() {
    //Close the browser
        driver.close();
        driver.quit();
    }

}
