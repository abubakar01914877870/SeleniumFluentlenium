package org.basicTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.basicTest.Pages.DuckDuckMainPage;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SimpleTest extends FluentTest {
    @Page
    DuckDuckMainPage duckDuckMainPage;

    @Override
    public WebDriver newWebDriver(){
      // System.setProperty("webdriver.chrome.driver", "C:\\Users\\abuba\\www\\SeleniumFluentlenium\\webDriver\\chromeDriver\\chromedriver.exe");
        WebDriver driver = WebDriverManager.chromedriver().create();
        return driver;
    }

    @Test
    public void titleOfDuckDuckGoShouldContainSearchQueryName() {
        String searchPhrase = "searchPhrase";

        goTo(duckDuckMainPage)
                .typeSearchPhraseIn(searchPhrase)
                .submitSearchForm()
                .assertIsPhrasePresentInTheResults(searchPhrase);
    }

}
