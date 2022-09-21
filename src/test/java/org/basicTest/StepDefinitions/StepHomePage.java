package org.basicTest.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.basicTest.Pages.Appointment;
import org.basicTest.Pages.KatalonDemoHomePage;
import org.basicTest.Pages.Login;
import org.fluentlenium.core.annotation.Page;

public class StepHomePage extends BaseTest {
    @Page
    KatalonDemoHomePage katalonDemoHomePage;
    @Page
    Login login;
    @Page
    Appointment appointment;

    @When("I go to katalon home page")
    public void i_go_to_katalon_home_page() {
        goTo(katalonDemoHomePage);
    }

    @Then("I verify page title")
    public void i_verify_page_title() {
        katalonDemoHomePage.checkPageTitle();
    }

    @Then("I verify page url")
    public void i_verify_page_url() {
        katalonDemoHomePage.checkPageUrl();
    }

    @Given("I click on home page burger menu login button")
    public void iClickOnHomePageBurgerMenuLoginButton() {
        katalonDemoHomePage
                .clickOnBurgerMenu()
                .clickOnLoginBtn();
    }


    @When("I fill up userId and password")
    public void iFillUpUserIdAndPassword() {
        login
                .copyUserNameAndPassword()
                .inputUserNameAndPassword();
    }

    @When("I click on login button")
    public void iClickOnLoginButton() {
        login
                .clickOnLoginButton();
    }

    @Then("I verify user successfully login")
    public void iVerifyUserSuccessfullyLogin() {
        appointment
                .checkPageUrl();
    }

    @When("I click on home page burger menu")
    public void iClickOnHomePageBurgerMenu() {
        katalonDemoHomePage
                .clickOnBurgerMenu();
    }

    @Then("I check for menu items before login")
    public void iCheckForMenuItemsBeforeLogin() {
        katalonDemoHomePage
                .assertBurgerMenuItemsBeforeLogin();
    }

    @When("I login katalon demo site")
    public void iLoginKatalonDemoSite() {
        goTo(katalonDemoHomePage)
                .clickOnBurgerMenu()
                .clickOnLoginBtn();
        login
                .checkLoginPageUrl()
                .copyUserNameAndPassword()
                .inputUserNameAndPassword()
                .clickOnLoginButton();
        appointment
                .checkPageUrl();
    }

    @Then("I check for menu items after login")
    public void iCheckForMenuItemsAfterLogin() {
        goTo(katalonDemoHomePage)
                .clickOnBurgerMenu()
                .assertBurgerMenuItemsAfterLogin();
    }

    @When("I logout from katalon demo site")
    public void iLogoutFromKatalonDemoSite() {
        goTo(katalonDemoHomePage)
                .clickOnBurgerMenu()
                .assertBurgerMenuItemsAfterLogin()
                .clickLogoutBtn();
    }

    @Then("I verify user successfully logout")
    public void iVerifyUserSuccessfullyLogout() {
        goTo(katalonDemoHomePage)
                .clickOnBurgerMenu()
                .assertBurgerMenuItemsBeforeLogin();
    }



}
