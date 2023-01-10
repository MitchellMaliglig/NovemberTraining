@sometag
Feature: feature feature
  feature feature feature

  @FAQTest
  Scenario: FAQ Page Navigation
    Given I am on the home page
    And I click on products link
    And I click on contact link
    When I click on FAQ link
    Then I should see the FAQ title

  @V4BQuickStartGuideTest
  Scenario: V4B Contact Info
    Given I am on the home page
    And I click on products link
    And I click on contact link
    And I click on product manuals link
    And I click on V4B link
    When I click on quick start guide english
    Then I should see contact info listed
