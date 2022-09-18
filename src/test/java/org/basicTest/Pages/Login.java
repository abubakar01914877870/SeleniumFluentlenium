package org.basicTest.Pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

@PageUrl("https://katalon-demo-cura.herokuapp.com/profile.php#login")
public class Login extends FluentPage {
    private String USER_NAME;
    private String PASSWORD;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private FluentWebElement givenUserName;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private FluentWebElement givenPassword;
    @FindBy(xpath = "//input[@id='txt-username']")
    private FluentWebElement userNameField;
    @FindBy(xpath = "//input[@id='txt-password']")
    private FluentWebElement passwordField;
    @FindBy(xpath = "//button[@id='btn-login']")
    private FluentWebElement btnLogin;

    public Login checkLoginPageUrl(){
        //System.out.println(getUrl());
        assertThat(getUrl()).contains("login");
        return this;
    }
    public Login copyUserNameAndPassword(){
        await().until(givenUserName).displayed();
        USER_NAME = givenUserName.attribute("value");
        PASSWORD = givenPassword.attribute("value");
        return this;
    }
    public Login inputUserNameAndPassword(){
        userNameField.write(USER_NAME);
        passwordField.write(PASSWORD);
        return this;
    }
    public Login clickOnLoginButton(){
        btnLogin.click();
        return this;
    }
}
