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
}
