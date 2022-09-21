package org.basicTest.StepDefinitions;

import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.configuration.ConfigurationProperties;
import org.fluentlenium.configuration.FluentConfiguration;

import static org.fluentlenium.configuration.ConfigurationProperties.DriverLifecycle.DEFAULT;
import static org.fluentlenium.configuration.ConfigurationProperties.DriverLifecycle.JVM;

@FluentConfiguration(driverLifecycle = DEFAULT)
public class BaseTest extends FluentCucumberTest {
}
