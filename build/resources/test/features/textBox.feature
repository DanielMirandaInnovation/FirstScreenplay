Feature: Practice text box

  @regression
  Scenario: Full text box
    Given that a web user wants to practice text box in demoqa
    When he fills all the requested fields in text box section
    Then he should see him data down.

  @smokeTest
  Scenario: Full text box with excel
    Given that a web user wants to practice text box in demoqa
    When he fills all the requested fields in text box section with data excel
    Then he should see him data down.