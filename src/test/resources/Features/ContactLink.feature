#Author: jaganmohan.be@gmail.com
#Date: 21.07.2021
#Keywords Summary :
#Feature: Feature is to test the navigation of contact form functionality of the application
#Scenario: Select the 'Contact' link of the application
#Given: that I am on the Irish Life website homepage
#When: I click on the Contact link in then top navigation
#Then: a new page loads which contains a contact form
#Scenario Outline: List of steps for this test
## Step 1: Open the browser
## Step 2: Navigate to the weblink 'https:://www.irishlife.ie'
## Step 3: Click on the Contact link of the home page
## Step 4: Validate whether contact form loaded successfully

Feature: Feature is to test the navigation of contact form functionality of the application

  Scenario: Select the 'Contact' link of the application
    Given that I am on the Irish Life website homepage
    When I click on the Contact link in then top navigation
    Then a new page loads which contains a contact form