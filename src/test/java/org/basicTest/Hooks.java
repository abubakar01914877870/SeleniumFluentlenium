package org.basicTest;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.basicTest.StepDefinitions.BaseTest;

public class Hooks extends BaseTest {
    @Before
    public void beforeScenario(Scenario scenario) {
        this.before(scenario);
    }

    @After
    public void afterScenario(Scenario scenario) {
        this.after(scenario);
    }

//    @After
//    public void takeImage(){
//        takeScreenshot();
//    }

}
