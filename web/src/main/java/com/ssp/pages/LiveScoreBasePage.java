package com.ssp.pages;

import com.ssp.pages.interfaces.ITestPage;
import net.serenitybdd.core.annotations.findby.By;
import org.springframework.stereotype.Component;

@Component
public class LiveScoreBasePage extends BasePage implements ITestPage {
    private static final String MAIN_MENU_BUTTON = "//span[@id='burger-menu-open']";
    private static final String NEXT_DAY_BUTTON = "//a[@data-testid='3__match-calendar-link']";
    private static final String MENU_ELEMENT = "//span[contains(text(), '%s')]";
    private static final String COOKIE_POPUP = "//button[@id='simpleCookieBarCloseButton']";

    private static final String EVENT_BUTTON = "//div[@class='To']";

    @Override
    public void clickOnMenuButton() {
        $(By.xpath(MAIN_MENU_BUTTON)).shouldBeVisible();
        $(By.xpath(MAIN_MENU_BUTTON)).click();
    }

    public void closeCookiesPopup() {
        $(By.xpath(COOKIE_POPUP)).shouldBeVisible();
        $(By.xpath(COOKIE_POPUP)).click();
    }

    public void clickOnEventButton() {
        waitFor(EVENT_BUTTON).shouldBeDisplayed();
//        $(By.xpath(EVENT_BUTTON)).shouldBeVisible();
        $(By.xpath(EVENT_BUTTON)).click();
    }

    public void clickOnNextDayButton() {
        $(By.xpath(NEXT_DAY_BUTTON)).shouldBeVisible();
        $(By.xpath(NEXT_DAY_BUTTON)).click();
    }

    public void clickOnSetting(String element) {
        $(By.xpath(String.format(MENU_ELEMENT, element))).shouldBeVisible();
        $(By.xpath(String.format(MENU_ELEMENT, element))).click();
    }
}
