package com.vytrack.page;

import com.vytrack.utils.Browser;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

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
    public WebElement starts;

    @FindBy(xpath = "//input[starts-with(@id,'time_selector_oro_calendar_event_form_end')]")
    public WebElement end;

    /////////////////////////////AC5//////////////////////////////

    /////////////////////////////AC6/////////////////////////////////

    //////////////////////////////AC7//////////////////////////////////////

    @FindBy(xpath = "" )
    private WebElement allDayCheckBox;


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
}
