package testSteps;


import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import petTests.Pet_CRUD;
public class PetSteps extends Pet_CRUD{

	
	@Given("User has a new Pet to Store")
	public void user_has_a_new_pet_to_store() throws IOException {
     //getPet();
	}

	@When("User Post this new Pet to Store")
	public void user_post_this_new_pet_to_store() throws IOException {
      AddNewPet();
	}

	@When("User Update the Pet")
	public void user_update_the_pet() throws IOException {
      updatePet();
	}

	@When("User get the pet data")
	public void user_get_the_pet_data() {
     //  getPet();
	}

	@Then("User delete  the pet")
	public void user_delete_the_pet() {
       deletePet();
	}

	


		
}

