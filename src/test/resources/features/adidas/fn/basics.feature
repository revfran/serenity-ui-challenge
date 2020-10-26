@user_acceptance @basic_navigation
Feature: Basic navigation

  @basic_navigation:001 @smoke
  Scenario: Access web page accepting modal windows
    Given Maria opens adidas Finland home page
    When she closes delivery modal popup
    And she accepts cookies modal popup
    Then she should see that the title contains the values "adidas Official Website FI"

  @basic_navigation:002 @smoke
  Scenario: Search for item and see suggestions
    Given Maria opens adidas Finland home page closing modal windows
    Then she should see that the title contains the values "adidas Official Website FI"

    When she types in search section "ultraboost"
    Then she should see that the product suggestions should contain the word "ultraboost"
    And she should see that the overlay suggestions should contain the word "ultraboost"

  @basic_navigation:003
  Scenario: Search for item and go to results page
    Given Maria opens adidas Finland home page closing modal windows
    Then she should see that the title contains the values "adidas Official Website FI"

    When she searches for "ultraboost"
    Then she should see that the search title contains the values "adidas Online Shop"
    And she should see that the search results are related to "ultraboost"

  @Pending @basic_navigation:004
  Scenario Outline: Add an item to the cart
    Given Maria opens adidas Finland store page closing modal windows for "<articleNumber>"
    Then she should see that the title contains the values "adidas Official Website FI"

    When she searches for "ultraboost"
    Then she should see that the title contains the values "adidas Online Shop"
    And she should see that the search results are related to "ultraboost"
    Examples:
      | articleNumber |
      | EH2861        |