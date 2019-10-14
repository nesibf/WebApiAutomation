Feature: Check available services

  The end point returns:
  - a status message to indicate that the application is running successfully
  - general data
  - content of each service

  Scenario: WEB API assignment status of services
    Given the end point is alive
    When I check the API status
    Then the API returns data
