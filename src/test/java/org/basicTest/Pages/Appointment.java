package org.basicTest.Pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@PageUrl("https://katalon-demo-cura.herokuapp.com/#appointment")
public class Appointment extends FluentPage {
    private String URL_CONTAIN_TEXT = "appointment";
    public Appointment checkPageUrl(){
        assertThat(getUrl()).contains(URL_CONTAIN_TEXT);
        return this;
    }
}
