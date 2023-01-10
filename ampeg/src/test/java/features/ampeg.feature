@tag
Feature: FAQ Page

  @tag1
  Scenario: FAQ Page Navigation
    Given I am on the home page
    And Click on products link
    And Click on contact link
    When I click on FAQ link
    Then I should see the FAQ title 
