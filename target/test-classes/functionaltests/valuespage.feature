#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Values page

 Background:
		Given user launches the browser and opens url
    When user is on values page

  @tag1
  Scenario: Right count of values page
    Then verify the right count of values
    And close the browser
    
    @tag1
  Scenario: values on the screen greater than zero
    Then verify the values on the screen are greater than zero
    And close the browser
    
      @tag1
  Scenario: Total balance is correct
    Then verify the total balance is correct
    And close the browser
    
      @tag1
  Scenario: Values are formatted as currencies
    Then verify the values are formatted as currencies
    And close the browser