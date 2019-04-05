Feature: SearchByLocation

  Scenario: User doesn't allow to access the location
    When Startpage int has finished loading
    And User declines to access location
    Then Display shows an error message

  Scenario: User allows to access the location
    When Start has finished loading
    And User submites to access location
    Then Display show the map with surrounding farmer shops


