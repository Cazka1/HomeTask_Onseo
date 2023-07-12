package com.ssp.hook;

import com.ssp.pages.LiveScoreBasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

import static net.serenitybdd.core.Serenity.getDriver;

public class CucumberHook {
    @Autowired
    private LiveScoreBasePage basePage;
    private String LIVE_SCORE_URL = "https://www.livescore.com/en/";

    @Before
    public void profileSetUp() {
        basePage.openUrl(LIVE_SCORE_URL);
    }

    @After
    public void tearDown() {
        getDriver().close();
        getDriver().quit();
    }
}
