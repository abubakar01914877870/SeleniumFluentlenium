package org.basicTest.Pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@PageUrl("https://katalon-demo-cura.herokuapp.com/#appointment")
public class Appointment extends FluentPage {
    private String URL_CONTAIN_TEXT = "appointment";
    private String APPOINTMENT_CONFIRMATION_TEXT = "Appointment Confirmation";

    @FindBy(css = "select[id=combo_facility]")
    private FluentWebElement facilityDropdown;
    @FindBy(css = "input[id=chk_hospotal_readmission]")
    private FluentWebElement chkBoxHospotalReadmission;
    @FindBy(css = "input[id=radio_program_medicaid]")
    private FluentWebElement radioBtnProgramMedicaid;
    @FindBy(css = "input[id=txt_visit_date]")
    private FluentWebElement visitDate;
    @FindBy(css = "textarea[id=txt_comment]")
    private FluentWebElement comment;
    @FindBy(css = "button[id=btn-book-appointment]")
    private FluentWebElement btnBookAppointment;
    @FindBy(xpath = "//section[@id='summary']/div/div/div/h2")
    private FluentWebElement appointmentConfirmation;

    public Appointment checkPageUrl(){
        assertThat(getUrl()).contains(URL_CONTAIN_TEXT);
        return this;
    }

    public Appointment fillUpAppointmentForm(){
        await().until(facilityDropdown).clickable();
        facilityDropdown.click().fillSelect().withIndex(2);
        chkBoxHospotalReadmission.click();
        radioBtnProgramMedicaid.click();
        visitDate.write("29/09/2022");
        comment.write("This is a test comment for and appointment");
        return this;
    }
    public Appointment clickBookAppointFrom(){
        btnBookAppointment.submit();
        return this;
    }
    public Appointment checkAppointConfirmation(){
        await().until(appointmentConfirmation).displayed();
        assertThat(appointmentConfirmation.text()).isEqualTo(APPOINTMENT_CONFIRMATION_TEXT);
        return this;
    }
}
