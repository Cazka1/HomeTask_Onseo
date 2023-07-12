package com.ssp.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import org.springframework.stereotype.Component;

@Component
public class TimeZonePage extends BasePage {
    private static final String TIME_ZONE_CHEKBOX = "//div[@id='TZ_SELECT']";
    private static final String TIME_ZONE_SELECT_LABEL = "//label[@id='TZ_SELECT-label']";
    private static final String TIME_ZONE = "//div[contains(text(),'%s')]";
    private static final String APPLY_BUTTON = "//button[contains(text(), '%s')]";

    public void clickOnTimeZoneCheckbox() {
        $(By.xpath(TIME_ZONE_CHEKBOX)).shouldBeVisible();
        $(By.xpath(TIME_ZONE_CHEKBOX)).click();
    }

    public void rememberCurrentTimeZone() {
        String currentTimeZone = $(By.xpath(TIME_ZONE_SELECT_LABEL)).shouldBeVisible().getText();
        Serenity.setSessionVariable("currentTimeZoneUTC").to(currentTimeZone.replace("0", "").replace(":", "")
                .replace(" ", ""));
        Serenity.setSessionVariable("currentTimeZone").to(currentTimeZone.replace("UTC +", ""));
        $(By.xpath(TIME_ZONE_CHEKBOX)).click();
    }

    public void clickOnTimeZone(String timeZone) {
        $(By.xpath(String.format(TIME_ZONE, timeZone))).shouldBeVisible();
        $(By.xpath(String.format(TIME_ZONE, timeZone))).click();
        String newTimeZone = $(By.xpath(TIME_ZONE_SELECT_LABEL)).shouldBeVisible().getText();
        Serenity.setSessionVariable("newTimeZoneUTC").to(newTimeZone.replace("0", "").replace(":", "")
                .replace(" ", ""));
        Serenity.setSessionVariable("newTimeZone").to(newTimeZone.replace("UTC +", ""));
    }

    public void replaceUtcTimeZone(String timeZone) {

    }

    public void clickOnApplyButton(String name) {
        $(By.xpath(String.format(APPLY_BUTTON, name))).shouldBeVisible();
        $(By.xpath(String.format(APPLY_BUTTON, name))).click();
    }


}
