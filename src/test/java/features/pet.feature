Feature:
Pet Store APIs

Scenario: Validate CRUD oprations on Pet
Given  User has a new Pet to Store
When   User Post this new Pet to Store
When   User Update the Pet
And    User get the pet data
And    User delete  the pet
Then   The pet is removed  from the store successfully

      
