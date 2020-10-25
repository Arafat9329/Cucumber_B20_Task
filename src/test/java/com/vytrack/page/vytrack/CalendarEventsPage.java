package com.vytrack.page.vytrack;

import com.vytrack.utils.Browser;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CalendarEventsPage extends BasePage {

    @FindBy(id = "prependedInput")
    private WebElement enterUsername;

    @FindBy(id = "prependedInput2")
    private WebElement enterPassword;

    @FindBy(id = "_submit")
    private WebElement logIn;

    @FindBy(xpath = "//tbody/tr[1]/td[9]//div")
    private WebElement threeDots;

    @FindBy(xpath = "//div[@class='loader-mask']/following-sibling::*/li//li[1]")
    public WebElement threeDots_view;

    @FindBy(xpath = "//div[@class='loader-mask']/following-sibling::*/li//li[2]")
    public WebElement threeDots_edit;

    @FindBy(xpath = "//div[@class='loader-mask']/following-sibling::*/li//li[3]")
    public WebElement threeDots_delete;

    @FindBy(xpath = "//div[@class='column-manager dropdown']")
    private WebElement gridOptions;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[1]/td[3]/input")
    private WebElement gridOptions_titleBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[2]/td[3]/input")
    private WebElement gridOptions_calendarBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[3]/td[3]/input")
    private WebElement gridOptions_startBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[4]/td[3]/input")
    private WebElement gridOptions_endBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[5]/td[3]/input")
    private WebElement gridOptions_recurrentBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[6]/td[3]/input")
    private WebElement gridOptions_recurrenceBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[7]/td[3]/input")
    private WebElement gridOptions_invitationBox;

    @FindBy(xpath = "//a[@class='grid-header-cell__link'][.='Title']")
    public WebElement columnTitle;

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@class='btn-group pull-right']/a")
    private WebElement saveAndClose_expand;

    @FindBy(xpath = "//div[@class='btn-group pull-right open']//ul//li[1]")
    public WebElement saveAndClose_expand_saveAndClose;

    @FindBy(xpath = "//div[@class='btn-group pull-right open']//ul//li[2]")
    public WebElement saveAndClose_expand_saveAndNew;

    @FindBy(xpath = "//div[@class='btn-group pull-right open']//ul//li[3]")
    public WebElement saveAndClose_expand_save;

    @FindBy(xpath = "//div[@class='pull-left btn-group icons-holder']")
    private WebElement cancel;

    @FindBy(xpath = "//input[starts-with(@id,'time_selector_oro_calendar_event_form_start')]")
    public WebElement startsTimeInput;

    @FindBy(xpath = "//input[starts-with(@id,'time_selector_oro_calendar_event_form_end')]")
    public WebElement endTimeInput;

    @FindBy(xpath = "//div[@id='oro-dropdown-mask']/following-sibling::div[1]//li[.='1:00 AM']")
    public WebElement startsTimeSelector;

    @FindBy(xpath = "//div[@id='oro-dropdown-mask']/following-sibling::div[1]//li[.='11:00 AM']")
    public WebElement endTimeSelector11AM;

    @FindBy(xpath = "//input[starts-with(@id,'oro_calendar_event_form_allDay')]" )
    public WebElement allDayCheckBox;

    @FindBy(xpath = "//input[starts-with(@id,'recurrence-repeat')]")
    public WebElement repeatCheckBox;

    @FindBy(xpath = "//select[starts-with(@id,'recurrence-repeat')]")
    public WebElement repeatsSelector;

    @FindBy(xpath = "//div[@class='controls recurrence-subview-control__items']//label[@class='fields-row']/input[@type='radio']")
    public WebElement repeatEveryRadioButton;

    @FindBy(xpath = "//input[@type='radio']/following-sibling::span[.='Never']")
    public WebElement end_neverRadioButton;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    public WebElement summaryMessage;

    @FindBy(xpath = "//span[.='After']/following-sibling::input")
    private WebElement end_afterEnter;

    @FindBy (xpath = "//span[.='After']/preceding-sibling::input")
    private WebElement end_afterRadioButton;

    @FindBy (xpath = "//span[.='By']/preceding-sibling::input")
    public WebElement end_byRadioButton;

    @FindBy(xpath = "//input[@class='datepicker-input hasDatepicker']")
    public WebElement end_by_dateEnter;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement end_by_dateEnter_monthsSelector;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public WebElement end_by_dateEnter_yearSelector;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//span[.='1']")
    public WebElement end_by_dateEnter_datePikerDay1;

    @FindBy(xpath = "//input[@value='monday']")
    public WebElement repeatOn_monday;

    @FindBy(xpath = "//input[@value='friday']")
    public WebElement repeatOn_friday;

    /**
     *
     * @param role: store manager,
     */
    public void login(String role){
        if (role.equalsIgnoreCase("store manager")) {
            enterUsername.sendKeys(ConfigurationReader.getProperty("userName"));
            enterPassword.sendKeys(ConfigurationReader.getProperty("password"));
            logIn.click();
        }else {
            System.out.println("Error: create that role");
        }
    }

    public void threeDotsHover(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(threeDots).perform();
    }

    public void click_gridOptions(){
        gridOptions.click();
    }

    public void selectTitleOnly(){
        gridOptions_calendarBox.click();
        gridOptions_startBox.click();
        gridOptions_endBox.click();
        gridOptions_recurrentBox.click();
        gridOptions_recurrenceBox.click();
        gridOptions_invitationBox.click();

    }

    public void click_createCalendarEvent(){
        createCalendarEvent.click();
    }

    public void click_saveAndClose_expand(){
        saveAndClose_expand.click();
    }

    public void click_cancel(){
        cancel.click();
    }

    public void end_afterEnter(int day){
        end_afterRadioButton.click();
        Browser.wait(1);
        String enter = day+"";
        end_afterEnter.sendKeys(enter, Keys.ENTER);
    }

    public void repeatsSelector_select(String type){
        Select select = new Select(repeatsSelector);
        repeatsSelector.click();
        select.selectByVisibleText(type);
    }

    public WebElement endTimeSelector11AMorEnter(String timeAmOnly){
        return  Driver.getDriver().findElement(By.xpath("//div[@id='oro-dropdown-mask']/following-sibling::div[1]//li[.='"+timeAmOnly+":00 AM']"));
    }

    /**
     * month:MUST BE Current or futureMonths
     * @param month:Oct, Nov, Dec ......
     * @param year:2020, 2021, 2022....
     * @param day: 1,2,3,4,5,6
     */
    public void pickDate(String month, Integer day, Integer year){
        Select selectMonth = new Select(end_by_dateEnter_monthsSelector);
        Select selectYear = new Select(end_by_dateEnter_yearSelector);
        selectMonth.selectByVisibleText(month);
        Browser.wait(1);
        selectYear.selectByVisibleText((year+""));
        Browser.wait(1);

        Driver.getDriver().findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[.='"+(day+"")+"']")).click();

    }

}
