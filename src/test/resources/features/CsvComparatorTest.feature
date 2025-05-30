@CsvComparison
Feature: Compare two csv files and identify differences

  @TestID-1234
  Scenario Outline: Identify the differences between two CSV files - with column-to-column approach
    Given user has csv file named "<filename1>"
    And user has another csv file named "<filename2>"
    When user compares two csv files
    Then the system should identify differences
    Examples:
      | filename1 | filename2 |
      | File1_ExpectedEmployeeData.csv | File2_ActualEmployeeData.csv |
      | File1_ExpectedEmployeeData.csv | File3_HappyPathData.csv |
      | File1_ExpectedEmployeeData.csv | File4_Empty.csv |
