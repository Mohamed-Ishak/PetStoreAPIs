package testSteps;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import storeTests.Store_CRUD;

public class StoreSteps extends Store_CRUD{

	
	@Given("Place and order for a pet")
	public void place_and_order_for_a_pet() throws IOException {
     placeOrderForPet();
	}

	@When("Get purchase order by Id")
	public void get_purchase_order_by_id() {
      getPurchaseOrderByID();
	}

	@When("Get pet inventories by status")
	public void get_pet_inventories_by_status() {
       getPetInventories();
	}

	@Then("Delete purchase order by Id")
	public void delete_purchase_order_by_id() {
      deletePurchaseOrderByID();
	}

}
