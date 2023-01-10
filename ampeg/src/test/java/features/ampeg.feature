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

 # @Svt810eNavigationTest
  #Scenario: Svt810e through Justin Pearson
   # Given I am on the home page
    #And I click on the artists link
   	#And I click on Justin Pearson
    #When I click on SVT810E link
    #Then I should be able to see SVT810E product
    
    @ClassicProducts
    Scenario: Navigate to classic page
    Given I am on the home page
    And I click on products link
    When I click classic bass heads and enclosures
    Then I should see the classic page
