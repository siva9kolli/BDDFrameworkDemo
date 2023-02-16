Feature: Login Tests

  Background:
    Given I'm on Launch screen
  @sauce
  Scenario Outline: Verify Login

    Then I login with email "<email>" and password "<password>"

    Examples:
      | email         | password     |
      | standard_user | secret_sauce |