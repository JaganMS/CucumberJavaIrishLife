#Author: jaganmohan.be@gmail.com
#Date: 21.07.2021
#Keywords Summary :
#Feature: Feature is to test the navigation of Find out more functionality of the application
#Scenario: Select the 'Find out more' link of the application
#Given: that I am on the Irish Life website
#When: I click on the Find out more link in then top navigation
#Then: I see a form which contains the text 'I want to cover'
#Scenario Outline: List of steps for this test
## Step 1: Open the browser
## Step 2: Navigate to the weblink 'https:://www.irishlife.ie'
## Step 3: Click on the Find out more link of the home page
## Step 4: Validate whether home page loaded with 'I want to cover' option


Feature: Feature is to test the navigation of Find out more functionality of the application


  Scenario: Select the 'Find out more' link of the application
    Given that I am on the Irish Life website
    When I click on the Find out more link in then top navigation
    Then I see a form which contains the text 'I want to cover'