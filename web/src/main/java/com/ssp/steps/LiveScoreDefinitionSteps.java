package com.ssp.steps;

import com.ssp.pages.EventInformationPage;
import com.ssp.pages.LiveScoreBasePage;
import com.ssp.pages.TimeZonePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class LiveScoreDefinitionSteps {
    @Autowired
    private LiveScoreBasePage liveScoreBasePage;
    private TimeZonePage timeZonePage;
    private EventInformationPage eventInformationPage;

    @When("User opens main menu")
    public void userClickOnMainMenu() {
        liveScoreBasePage.clickOnMenuButton();
    }

    @Given("User closes cookies popup")
    public void userCloseCookiesPopup() {
        liveScoreBasePage.closeCookiesPopup();
    }

    @And("User choose football event")
    public void userClickOnEvent() {
        liveScoreBasePage.clickOnEventButton();
    }

    @And("User choose another day")
    public void userClickOnNextDayButton() {
        liveScoreBasePage.clickOnNextDayButton();
    }

    @And("User opens {string}")
    public void userClickOnMenuElement(String element) {
        liveScoreBasePage.clickOnSetting(element);
    }

    @And("User opens time zone checkbox")
    public void userClickOnTimeZoneCheckbox() {
        timeZonePage.clickOnTimeZoneCheckbox();
    }

    @And("User sees current time zone")
    public void userSeesCurrentTimeZone() {
        timeZonePage.rememberCurrentTimeZone();
    }


    @And("User choose Timezone {string}")
    public void userSelectTimeZone(String timeZone) {
        timeZonePage.clickOnTimeZone(timeZone);
    }

    @And("User sees start time")
    public void userSeesStartTime() {
        eventInformationPage.rememberStartTime();
    }

    @And("User sees start date")
    public void userSeesStartDate() {
        eventInformationPage.rememberStartDate();
    }

    @And("User sees new start time")
    public void userSeesNewStartTime() {
        eventInformationPage.rememberNewStartTime();
    }

    @And("User sees new start date")
    public void userSeesNewStartDate() {
        eventInformationPage.rememberNewStartDate();
    }

    @And("User clicks {string} button")
    public void userClickOnApplyButton(String name) {
        timeZonePage.clickOnApplyButton(name);
    }

    @And("User sees that new start time is correct")
    public void userSeesThatNewStartTimeIsCorrect() {
        Assert.assertTrue(eventInformationPage.seesThatNewStartTimeIsCorrect());
    }

    @And("User sees that new start date is correct")
    public void userSeesThatNewStartDateIsCorrect() {
        Assert.assertTrue(eventInformationPage.seesThatNewStartDateIsCorrect());
    }
}
