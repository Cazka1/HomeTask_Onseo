package com.ssp.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class EventInformationPage extends BasePage {
    private static final String EVENT_START_TIME = "//span[@id='score-or-time']";
    private static final String EVENT_START_DATE = "//span[@id='SEV__status']";

    public String rememberStartTime() {
        String startTime = $(By.xpath(EVENT_START_TIME)).shouldBeVisible().getText();
        Serenity.setSessionVariable("startTime").to(startTime);
        return startTime;
    }

    public String rememberStartDate() {
        String startDate = $(By.xpath(EVENT_START_DATE)).shouldBeVisible().getText();
        Serenity.setSessionVariable("startDate").to(startDate);
        return startDate;
    }

    public String rememberNewStartDate() {
        String newStartDate = $(By.xpath(EVENT_START_DATE)).shouldBeVisible().getText();
        Serenity.setSessionVariable("newStartDate").to(newStartDate);
        return newStartDate;
    }

    public String rememberNewStartTime() {
        String newStartTime = $(By.xpath(EVENT_START_TIME)).shouldBeVisible().getText();
        Serenity.setSessionVariable("newStartTime").to(newStartTime);
        return newStartTime;
    }

    public boolean seesThatNewStartTimeIsCorrect() {
        LocalTime startTime = LocalTime.parse(Serenity.sessionVariableCalled("startTime"));
        LocalTime newStartTime = LocalTime.parse(Serenity.sessionVariableCalled("newStartTime"));
        LocalTime currentTimeZone = LocalTime.parse(Serenity.sessionVariableCalled("currentTimeZone"));
        LocalTime newTimeZone = LocalTime.parse(Serenity.sessionVariableCalled("newTimeZone"));

        Duration differenceTime = Duration.between(newStartTime, startTime);
        Duration differenceTimeZone = Duration.between(newTimeZone, currentTimeZone);

        String hoursT = String.valueOf(differenceTime.toHours());
        String minutesT = String.valueOf(differenceTime.toMinutes() % 60);
        String hoursZ = String.valueOf(differenceTimeZone.toHours());
        String minutesZ = String.valueOf(differenceTimeZone.toMinutes() % 60);
        String timeDifference = hoursT + ":" + minutesT;
        String ZoneDifference = hoursZ + ":" + minutesZ;
        return timeDifference.equals(ZoneDifference);
    }

    public boolean seesThatNewStartDateIsCorrect() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM", new Locale("en"));

        String startDate = Serenity.sessionVariableCalled("startDate");
        String newStartDate = Serenity.sessionVariableCalled("newStartDate");
        String currentTimeZoneUTC = Serenity.sessionVariableCalled("currentTimeZoneUTC");
        String newTimeZoneUTC = Serenity.sessionVariableCalled("newTimeZoneUTC");

        LocalDate today = LocalDate.now();
        LocalDate nextDay = today.plusDays(1);
        nextDay.atStartOfDay(ZoneId.of(currentTimeZoneUTC));

        String formattedDateCurrentUTC = nextDay.format(formatter);
        nextDay.atStartOfDay(ZoneId.of(newTimeZoneUTC));
        String formattedDateNewUTC = nextDay.format(formatter);

        return formattedDateCurrentUTC.equals(startDate) && formattedDateNewUTC.equals(newStartDate);
    }
}
