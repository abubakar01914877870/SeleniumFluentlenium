package org.basicTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.basicTest.Pages.Appointment;
import org.basicTest.Pages.KatalonDemoHomePage;
import org.basicTest.Pages.Login;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class SimpleTest extends FluentTest {

    @Page
    KatalonDemoHomePage katalonDemoHomePage;
    @Page
    Login loginPage;
    @Page
    Appointment appointment;

    @Override
    public WebDriver newWebDriver(){
      // System.setProperty("webdriver.chrome.driver", "C:\\Users\\abuba\\www\\SeleniumFluentlenium\\webDriver\\chromeDriver\\chromedriver.exe");
        WebDriver driver = WebDriverManager.chromedriver().create();
        return driver;
    }



    @Test
    @DisplayName("Simple test for check home page title and url")
    public void testKatalonHomePage(){
        goTo(katalonDemoHomePage)
                .checkPageTitle()
                .checkPageUrl();
    }
    @Test
    @DisplayName("Simple Login Test for test katalon site")
    public void loginKatalon(){
        goTo(katalonDemoHomePage)
                .clickOnBurgerMenu()
                .clickOnLoginBtn();
        loginPage.checkLoginPageUrl()
        .copyUserNameAndPassword()
        .inputUserNameAndPassword()
        .clickOnLoginButton();
        appointment.checkPageUrl();
    }

}
