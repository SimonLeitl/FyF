Feature: setProfileData

  Scenario: User creates a new farm shop
    When the user clicks new farm shop button
    Then Display shows the view to create new profile
    And it should contain a name textfield
    And it should contain a owner textfield
    And it should contain a adress textfield
    And it should contain a telefonenumber textfield
    And it should contain a email textfield
    And it should contain a safe button to write information in database

    Scenario: required fields are completed
      When all required fields are completed
      And User clicks on the safe button
      Then farm shop will be displayed
      And information is written in database

    Scenario: required fields are not completed
      When all required fields are not completed
      And User clicks on the safe button
      Then error message will be displayed