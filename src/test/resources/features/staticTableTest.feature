@Test
Feature: Test different actions on table web app.

  Rule: The user can return values from the table and validate them

Background: Navigate to table web app
    Given I navigate to the static table
@Smoke
  Scenario: As a Tester, I want to retrieve the value of a static table.
    Then I can return to value i wanted

  Scenario: As a Tester, I want to validate the static table is displayed
    Then I can validate the table is displayed