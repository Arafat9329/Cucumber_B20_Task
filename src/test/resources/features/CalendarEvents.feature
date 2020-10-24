Feature: Calendar Events

  Background:common steps
    Given user in login page
     When user login as "store manager"
      And user naivest to "Activities" and "Calendar Events"


  @TC1 @objectTest
    Scenario: Verify that “view”, “edit” and “delete” options are available
       And Hover on three dots “...” for “Testers meeting” calendar event
      Then Verify that “view”, “edit” and “delete” options are available

  @TC2 @objectTest
    Scenario: Verify that “Title” column still displayed
       And Click on “Grid Options” button
       And Deselect all options except “Title”
      Then Verify that “Title” column still displayed

  @TC3
    Scenario: Verify that “Save And Close”, “Save And New” and “Save” options are available
       And Click on “Create Calendar Event” button
       And Expand “Save And Close” menu
      Then Verify that “Save And Close”, “Save And New” and “Save” options are available

  @TC4
    Scenario:Verify that “All Calendar Events” page subtitle is displayed
       And Click on “Create Calendar Event” button
       And Click on “Cancel” button
      Then Verify that “All Calendar Events” page subtitle is displayed

  @TC5 @later
    Scenario: Verify that difference between end and start time is exactly 1 hour
       And Click on “Create Calendar Event” button
      Then Verify that difference between end and start time is exactly 1 hour

  @TC6 @later
    Scenario: Verify that end time is equals to “10:00 PM”
      And Click on “Create Calendar Event” button
      And Select “9:00 PM” as a start time
     Then Verify that end time is equals to “10:00 PM”

  @TC7
    Scenario: Verify that start and end date input boxes are displayed
       And Click on “Create Calendar Event” button
       And Select “All-Day Event” checkbox
      Then Verify that “All-Day Event” checkbox is selected
      Then Verify that start and end time input boxes are not displayed
      Then Verify that start and end date input boxes are displayed

  @TC8
    Scenario: Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:
       And Click on “Create Calendar Event” button
       And Select “Repeat” checkbox
      Then Verify that “Repeat” checkbox is selected
      Then Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:

  @TC9
    Scenario: Verify that following message as a summary is displayed: “Summary: Daily every 1 day”
       And Click on “Create Calendar Event” button
       And Select “Repeat” checkbox
      Then Verify that “Repeat” checkbox is selected
      Then Verify that “Repeat Every” radio button is selected
      Then Verify that “Never” radio button is selected as an “Ends” option.
      Then Verify that following message as a summary is displayed: “Summary: Daily every 1 day”

  @TC10
    Scenario: Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”
       And Click on “Create Calendar Event” button
       And Select “Repeat” checkbox
       And Select “After 10 occurrences” as an “Ends” option.
      Then Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”

  @TC11 @later
    Scenario: Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”
       And Click on “Create Calendar Event” button
       And Select “Repeat” checkbox
       And Select “By Nov 18, 2021” as an “Ends” option.
      Then Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”

  @TC12
    Scenario: Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”
       And Click on “Create Calendar Event” button
       And Select “Repeat” checkbox
       And Select "Weekly" options as a “Repeat” option
       And Select “Monday and Friday” options as a “Repeat On” options
      Then Verify that “Monday and Friday” options are selected
      Then Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”





