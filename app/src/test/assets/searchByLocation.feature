Feature: SearchByLocation
  As a User
  I will look after some shops and they need my location

  Scenario: User doesn't allow to access the location
    When Startpage has finished loading
    And User declines to access location with answer
    Then Display shows an error message

  Scenario: User allows to access the location
    When Startpage has finished loading
    And User submits to access location with answer
    Then Display show the map with surrounding farmer shops


