package com.ssp.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {
                "pretty",
                "summary",
                "html:target/site/cucumber-reports",
                "json:target/cucumber.json"
        },
        stepNotifications = true,
        tags = "not @ignore and @debug",
        glue = "com.ssp")
public class TestRunner {
}
