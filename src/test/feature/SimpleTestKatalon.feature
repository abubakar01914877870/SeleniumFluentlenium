Feature: Test for Katalon website

  Scenario:Check Home page
    When I go to katalon home page
    Then I verify page title
    Then I verify page url

  Scenario: Check login functionality
    Given I go to katalon home page
    And I click on home page burger menu login button
    When I fill up userId and password
    And I click on login button
    Then I verify user successfully login

  Scenario: Check make an appointment functionality
    Given I go to katalon home page
    And I click on home page burger menu login button
    And I fill up userId and password
    And I click on login button
    And I verify user successfully login
    When I fill up make appointment form
    And I click in book appointment button
    Then I check for appointment confirmation

  Scenario: Check number of menu items before login and after login
    Given I go to katalon home page
    When I click on home page burger menu
    Then I check for menu items before login
    When I login katalon demo site
    And I go to katalon home page
    And I click on home page burger menu
    Then I check for menu items after login

  @severity=blocker
  Scenario: Check history page and verify previously created appointment record
    Given I login katalon demo site
    When I fill up make appointment form
    And I click in book appointment button
    Then I check for appointment confirmation
    Given I go to katalon home page
    And I click on home page burger menu
    When I go to history page
    Then I check for previously created appointment record

  Scenario: Check logout functionality
    Given I login katalon demo site
    When I logout from katalon demo site
    Then I verify user successfully logout

  @severity=minor
  Scenario: Check logout functionality duplicate
    Given I login katalon demo site
    When I logout from katalon demo site
    Then I verify user successfully logout