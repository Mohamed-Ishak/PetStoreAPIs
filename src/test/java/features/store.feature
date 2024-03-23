Feature: 
  Verify Operation about User

  Scenario: Validate that CRUD oprations on Store
    Given Place and order for a pet
    When Get purchase order by Id
    And Get pet inventories by status
    Then Delete purchase order by Id
