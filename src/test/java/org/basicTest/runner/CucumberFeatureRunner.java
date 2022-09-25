package org.basicTest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import javax.annotation.concurrent.NotThreadSafe;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/feature",
        glue = "org.basicTest",
        monochrome = true,
        snippets = CAMELCASE,
        dryRun = false,
        publish = false,
        plugin = {"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
@NotThreadSafe
public class CucumberFeatureRunner {
    @BeforeClass
    public static void setUpChrome() {
        WebDriverManager.chromedriver().setup();
    }
}
