package org.basicTest.Pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@PageUrl("https://katalon-demo-cura.herokuapp.com/history.php#history")
public class History extends FluentPage {
    private String URL_CONTAIN_TEXT = "history";

    @FindBy(xpath = "//section/div/div/div/h2")
    private FluentWebElement historyPageHeaderText;
    @FindBy(xpath = "//div[@class='container']/div[2]/div")
    private FluentWebElement appointmentRecords;

    public History assertPageURLContainText(){
        assertThat(getUrl()).contains(URL_CONTAIN_TEXT);
        return this;
    }
    public History assertPageHeader(){
        assertThat(historyPageHeaderText.text().toLowerCase()).isEqualTo(URL_CONTAIN_TEXT.toLowerCase());
        return this;
    }
    public History assertAppointmentRecord(){
        assertThat(appointmentRecords.displayed()).isEqualTo(true);
        return this;
    }

}
