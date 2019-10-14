Feature: Check on services

  The end point returns a status message to indicate that the application is running successfully.

  Scenario: WEB API assignment status end-point
    Given the end point is alive
    When I check the API status
    Then the API returns data
