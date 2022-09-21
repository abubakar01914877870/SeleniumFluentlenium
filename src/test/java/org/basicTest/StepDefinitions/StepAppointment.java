package org.basicTest.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.basicTest.Pages.Appointment;
import org.basicTest.Pages.History;
import org.basicTest.Pages.KatalonDemoHomePage;
import org.fluentlenium.core.annotation.Page;

public class StepAppointment extends BaseTest {
    @Page
    Appointment appointment;
    @Page
    KatalonDemoHomePage katalonDemoHomePage;
    @Page
    History history;

    @When("I fill up make appointment form")
    public void iFillUpMakeAppointmentForm() {
        appointment
                .checkPageUrl()
                .fillUpAppointmentForm();
    }

    @When("I click in book appointment button")
    public void iClickInBookAppointmentButton() {
        appointment.clickBookAppointFrom();
    }

    @Then("I check for appointment confirmation")
    public void iCheckForAppointmentConfirmation() {
        appointment.checkAppointConfirmation();
    }

    @When("I go to history page")
    public void iGoToHistoryPage() {
        katalonDemoHomePage
                .clickHistory();
        history
                .assertPageHeader()
                .assertPageURLContainText();
    }

    @Then("I check for previously created appointment record")
    public void iCheckForPreviouslyCreatedAppointmentRecord() {
        history.assertAppointmentRecord();
    }


}
