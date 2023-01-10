@sometag
Feature: feature feature
	feature feature feature
	
  @FAQTest
  Scenario: FAQ Page Navigation
    Given I am on the home page
    And I Click on products link
    And I Click on contact link
    When I click on FAQ link
    Then I should see the FAQ title 
