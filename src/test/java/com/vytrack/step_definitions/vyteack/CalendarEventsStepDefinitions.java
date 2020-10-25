package com.vytrack.step_definitions.vyteack;

import com.vytrack.page.vytrack.CalendarEventsPage;
import com.vytrack.utils.Browser;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class CalendarEventsStepDefinitions {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Given("user in login page")
    public void user_in_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user login as {string}")
    public void user_login_as(String role) {
        calendarEventsPage.login(role);
    }

    @When("user naivest to {string} and {string}")
    public void user_naivest_to_and(String tab, String module) {
        calendarEventsPage.navigate(tab,module);
    }

    @When("Hover on three dots “...” for “Testers meeting” calendar event")
    public void hover_on_three_dots_for_testers_meeting_calendar_event() {
        Browser.wait(3);
        calendarEventsPage.threeDotsHover();
    }

    @Then("Verify that “view”, “edit” and “delete” options are available")
    public void verify_that_view_edit_and_delete_options_are_available() {
        Assert.assertTrue(calendarEventsPage.threeDots_view.isDisplayed());
        Assert.assertTrue(calendarEventsPage.threeDots_edit.isDisplayed());
        Assert.assertTrue(calendarEventsPage.threeDots_delete.isDisplayed());
    }

    @When("Click on “Grid Options” button")
    public void click_on_grid_options_button() {
    calendarEventsPage.click_gridOptions();
    }

    @When("Deselect all options except “Title”")
    public void deselect_all_options_except_title() {
        calendarEventsPage.selectTitleOnly();
    }

    @Then("Verify that “Title” column still displayed")
    public void verify_that_title_column_still_displayed() {
        Assert.assertTrue(calendarEventsPage.columnTitle.isDisplayed());
    }

    @When("Click on “Create Calendar Event” button")
    public void click_on_create_calendar_event_button() {
        calendarEventsPage.click_createCalendarEvent();
    }

    @When("Expand “Save And Close” menu")
    public void expand_save_and_close_menu() {
        Browser.wait(2);
        calendarEventsPage.click_saveAndClose_expand();
    }

    @Then("Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void verify_that_save_and_close_save_and_new_and_save_options_are_available() {
        Assert.assertTrue(calendarEventsPage.saveAndClose_expand_save.isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveAndClose_expand_saveAndClose.isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveAndClose_expand_saveAndNew.isDisplayed());
    }

    @When("Click on “Cancel” button")
    public void click_on_cancel_button() {
        Browser.wait(2);
        calendarEventsPage.click_cancel();
    }

    @Then("Verify that “All Calendar Events” page subtitle is displayed")
    public void verify_that_all_calendar_events_page_subtitle_is_displayed() {
        Browser.wait(1);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("All - Calendar Events - Activities"));
    }

    @Then("Verify that difference between end and start time is exactly 1 hour")
    public void verify_that_difference_between_end_and_start_time_is_exactly_hour() {
        Browser.wait(1);
        //calendarEventsPage.startsTimeInput.click();
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys("10"+Keys.ENTER);

        Browser.wait(2);
        calendarEventsPage.endTimeInput.click();
        Browser.wait(2);
        Assert.assertTrue(calendarEventsPage.endTimeSelector11AM.isEnabled());

    }

    @When("Select “9:00 PM” as a start time")
    public void select_pm_as_a_start_time() {
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys(Keys.BACK_SPACE);
        calendarEventsPage.startsTimeInput.sendKeys("9"+Keys.ENTER);
    }

    @Then("Verify that end time is equals to “10:00 PM”")
    public void verify_that_end_time_is_equals_to_pm() {
        Browser.wait(1);
        calendarEventsPage.endTimeInput.click();
        Browser.wait(2);
        Assert.assertTrue(calendarEventsPage.endTimeSelector11AMorEnter("10").isEnabled());
    }

    @When("Select “All-Day Event” checkbox")
    public void select_all_day_event_checkbox() {
        Browser.wait(1);
       calendarEventsPage.allDayCheckBox.click();
    }

    @Then("Verify that “All-Day Event” checkbox is selected")
    public void verify_that_all_day_event_checkbox_is_selected() {
        Assert.assertTrue(calendarEventsPage.allDayCheckBox.isSelected());
    }

    @Then("Verify that start and end time input boxes are not displayed")
    public void verify_that_start_and_end_time_input_boxes_are_not_displayed() {
        Browser.wait(2);
        Assert.assertFalse(calendarEventsPage.startsTimeInput.isDisplayed());
    }

    @Then("Verify that start and end date input boxes are displayed")
    public void verify_that_start_and_end_date_input_boxes_are_displayed() {
        Browser.wait(2);
        Assert.assertFalse(calendarEventsPage.endTimeInput.isDisplayed());
    }

    @When("Select “Repeat” checkbox")
    public void select_repeat_checkbox() {
        calendarEventsPage.repeatCheckBox.click();
    }

    @Then("Verify that “Repeat” checkbox is selected")
    public void verify_that_repeat_checkbox_is_selected() {
        Browser.wait(1);
        Assert.assertTrue(calendarEventsPage.repeatCheckBox.isSelected());
    }

    @Then("Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:")
    public void verify_that_daily_is_selected_by_default_and_following_options_are_available_in_repeats_drop_down() {
        Select select = new Select(calendarEventsPage.repeatsSelector);
        Browser.wait(2);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Daily"));
    }

    @Then("Verify that “Repeat Every” radio button is selected")
    public void verify_that_repeat_every_radio_button_is_selected() {
        Assert.assertTrue(calendarEventsPage.repeatEveryRadioButton.isSelected());
    }

    @Then("Verify that “Never” radio button is selected as an “Ends” option.")
    public void verify_that_never_radio_button_is_selected_as_an_ends_option() {
        Browser.wait(1);
        Assert.assertTrue(calendarEventsPage.end_neverRadioButton.isEnabled());
    }

    @Then("Verify that following message as a summary is displayed: “Summary: Daily every {int} day”")
    public void verify_that_following_message_as_a_summary_is_displayed_summary_daily_every_day(Integer int1) {
        String accRes= calendarEventsPage.summaryMessage.getText().trim();
        System.out.println("accRes = " + accRes);

        Assert.assertEquals(accRes,"Summary:\n" +
                "Daily every "+int1+" day");
    }

    @When("Select “After {int} occurrences” as an “Ends” option.")
    public void select_after_occurrences_as_an_ends_option(Integer int1) {
        calendarEventsPage.end_afterEnter(int1);
    }

    @Then("Verify that following message as a summary is displayed: “Summary: Daily every {int} day, endafter {int} occurrences”")
    public void verify_that_following_message_as_a_summary_is_displayed_summary_daily_every_day_endafter_occurrences(Integer int1, Integer int2) {
        String accRes= calendarEventsPage.summaryMessage.getText().trim();
        System.out.println("accRes = " + accRes);

        Assert.assertEquals(accRes,"Summary:\n" +
                "Daily every "+int1+" day, end after "+int2+" occurrences");
    }

    @When("Select {string} options as a “Repeat” option")
    public void select_weekly_options_as_a_repeat_option(String type) {
        calendarEventsPage.repeatsSelector_select(type);
    }

    @When("Select “Monday and Friday” options as a “Repeat On” options")
    public void select_monday_and_friday_options_as_a_repeat_on_options() {
        calendarEventsPage.repeatOn_monday.click();
        calendarEventsPage.repeatOn_friday.click();
    }

    @Then("Verify that “Monday and Friday” options are selected")
    public void verify_that_monday_and_friday_options_are_selected() {
        Assert.assertTrue(calendarEventsPage.repeatOn_monday.isSelected());
        Assert.assertTrue(calendarEventsPage.repeatOn_friday.isSelected());
    }

    @Then("Verify that following message as a summary is displayed: “Summary: Weekly every {int} week onMonday, Friday”")
    public void verify_that_following_message_as_a_summary_is_displayed_summary_weekly_every_week_on_monday_friday(Integer int1) {
        String accRes= calendarEventsPage.summaryMessage.getText().trim();
        System.out.println("accRes = " + accRes);

        Assert.assertEquals(accRes,"Summary:\n" +
                "Weekly every "+int1+" week on Monday, Friday");
    }

    @When("Select “By {string} {int}, {int}” as an “Ends” option.")
    public void select_by_nov_as_an_ends_option(String str, Integer day, Integer year) {
        calendarEventsPage.end_byRadioButton.click();
        calendarEventsPage.end_by_dateEnter.click();
        calendarEventsPage.pickDate(str,day,year);


    }

    @Then("Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by {string} {int}, {int}")
    public void verify_that_following_message_as_a_summary_is_displayed_summary_daily_every_day_end_by_nov(String str, Integer int2, Integer int3) {
        Assert.assertEquals(calendarEventsPage.summaryMessage.getText(),"Summary:\n" +
                "Daily every 1 day, end by "+str+" "+int2+", "+int3+"");

    }

}
