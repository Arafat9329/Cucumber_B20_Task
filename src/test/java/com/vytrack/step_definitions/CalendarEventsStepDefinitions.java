package com.vytrack.step_definitions;

import com.vytrack.page.CalendarEventsPage;
import com.vytrack.utils.Browser;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CalendarEventsStepDefinitions {

    @Given("user in login page")
    public void user_in_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user login as {string}")
    public void user_login_as(String role) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.login(role);
    }

    @When("user naivest to {string} and {string}")
    public void user_naivest_to_and(String tab, String module) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigate(tab,module);
    }

    @When("Hover on three dots “...” for “Testers meeting” calendar event")
    public void hover_on_three_dots_for_testers_meeting_calendar_event() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(3);
        calendarEventsPage.threeDotsHover();
    }

    @Then("Verify that “view”, “edit” and “delete” options are available")
    public void verify_that_view_edit_and_delete_options_are_available() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.threeDots_view.isDisplayed());
        Assert.assertTrue(calendarEventsPage.threeDots_edit.isDisplayed());
        Assert.assertTrue(calendarEventsPage.threeDots_delete.isDisplayed());
    }

    @When("Click on “Grid Options” button")
    public void click_on_grid_options_button() {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    calendarEventsPage.click_gridOptions();
    }

    @When("Deselect all options except “Title”")
    public void deselect_all_options_except_title() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.selectTitleOnly();
    }

    @Then("Verify that “Title” column still displayed")
    public void verify_that_title_column_still_displayed() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.columnTitle.isDisplayed());

    }

    @When("Click on “Create Calendar Event” button")
    public void click_on_create_calendar_event_button() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.click_createCalendarEvent();
    }

    @When("Expand “Save And Close” menu")
    public void expand_save_and_close_menu() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(2);
        calendarEventsPage.click_saveAndClose_expand();
    }

    @Then("Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void verify_that_save_and_close_save_and_new_and_save_options_are_available() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.saveAndClose_expand_save.isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveAndClose_expand_saveAndClose.isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveAndClose_expand_saveAndNew.isDisplayed());
    }

    @When("Click on “Cancel” button")
    public void click_on_cancel_button() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(2);
        calendarEventsPage.click_cancel();
    }

    @Then("Verify that “All Calendar Events” page subtitle is displayed")
    public void verify_that_all_calendar_events_page_subtitle_is_displayed() {
        Browser.wait(1);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("All - Calendar Events - Activities"));
    }

    @Then("Verify that difference between end and start time is exactly {int} hour")
    public void verify_that_difference_between_end_and_start_time_is_exactly_hour(Integer int1) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        System.out.println("start"+calendarEventsPage.starts.getText());
        System.out.println("end"+calendarEventsPage.end.getText());
    }

}
