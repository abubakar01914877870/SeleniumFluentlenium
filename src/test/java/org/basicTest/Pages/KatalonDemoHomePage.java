package org.basicTest.Pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

@PageUrl("https://katalon-demo-cura.herokuapp.com")
public class KatalonDemoHomePage extends FluentPage {
    private static final String KATALON_HOME_PAGE_TITLE = "CURA Healthcare Service";
    private static final String KATALON_HOME_PAGE_URL = "https://katalon-demo-cura.herokuapp.com";
    @FindBy(css = "a[id=btn-make-appointment]")
    private FluentWebElement btnMakeAppointment;
    @FindBy(css = "#menu-toggle")
    private FluentWebElement burgerMenuKatalonHomePage;
    @FindBy(xpath = "//li/a[text()='Login']")
    private FluentWebElement btnLogin;
    @FindBy(xpath = "//li/a[text()='Home']")
    private FluentWebElement burgerMenuHomeBtn;
    @FindBy(xpath = "//li/a[text()='History']")
    private FluentWebElement burgerMenuHistoryBtn;
    @FindBy(xpath = "//li/a[text()='Profile']")
    private FluentWebElement burgerMenuProfileBtn;
    @FindBy(xpath = "//li/a[text()='Logout']")
    private FluentWebElement burgerMenuLogoutBtn;

    public KatalonDemoHomePage clickOnMakeAppointmentPage(){
        btnMakeAppointment.click();
        return this;
    }

    public KatalonDemoHomePage checkPageUrl(){
        assertThat(getUrl()).isEqualTo(KATALON_HOME_PAGE_URL);
        return this;
    }

    public KatalonDemoHomePage checkPageTitle(){
        assertThat(window().title()).isEqualTo(KATALON_HOME_PAGE_TITLE);
        return this;
    }
    public KatalonDemoHomePage clickOnBurgerMenu(){
        await().until(burgerMenuKatalonHomePage).clickable();
        burgerMenuKatalonHomePage.click();
        return this;
    }
    public KatalonDemoHomePage clickOnLoginBtn(){
        await().until(btnLogin).clickable();
        btnLogin.click();
        return this;
    }
    public KatalonDemoHomePage assertBurgerMenuItemsBeforeLogin(){
        assertThat(btnLogin).isDisplayed();
        assertThat(burgerMenuHomeBtn).isDisplayed();
        return this;
    }
    public KatalonDemoHomePage assertBurgerMenuItemsAfterLogin(){
        assertThat(burgerMenuHomeBtn.displayed()).isEqualTo(true);
        assertThat(burgerMenuHistoryBtn.displayed()).isEqualTo(true);
        assertThat(burgerMenuProfileBtn.displayed()).isEqualTo(true);
        assertThat(burgerMenuLogoutBtn.displayed()).isEqualTo(true);
        return this;
    }
    public KatalonDemoHomePage clickLogoutBtn(){
        await().until(burgerMenuLogoutBtn).displayed();
        burgerMenuLogoutBtn.click();
        return this;
    }
    public KatalonDemoHomePage assertLogoutBtnNotPresent(){
        //System.out.println(burgerMenuLogoutBtn.displayed());
        assertThat(burgerMenuLogoutBtn.displayed()).isEqualTo(false);
        return this;
    }
    public KatalonDemoHomePage clickHistory(){
        burgerMenuHistoryBtn.click();
        return this;
    }
}
