package storeTests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.testng.Assert;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Store_CRUD {
    String id ;
	@org.testng.annotations.Test(priority = 1)
	@Test
	public void placeOrderForPet() throws IOException {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	 String response =	given()
			 .header("Content-Type", "application/json")
			 .body(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\src\\test\\java\\storeTests\\store.json"))))
		.when()
		     .post("/store/order")
		 .then()
		      .assertThat()
		      .log().all()
              .statusCode(200)
              .extract().response().asString(); 		        
		JsonPath js = new JsonPath(response);
		id = js.getString("id");
		System.out.println(id);
	}
	
	
	@org.testng.annotations.Test(priority = 2)
	@Test
	public void getPurchaseOrderByID() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		given()
		      .header("Content-Type", "application/json")
		      .pathParam("id", id)
	   .when()
	        
		    .get("/store/order/{id}")
		    
	   .then()
	        .assertThat()
	        .log().all()
	        .statusCode(200);
	}
	
	
	@org.testng.annotations.Test(priority = 2)
	@Test
	public void getPetInventories() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		given()
		      .header("Content-Type", "application/json")
	   .when()
	        
		    .get("/store/inventory")
		    
	   .then()
	        .assertThat()
	        .statusCode(200);
	}
	
	@org.testng.annotations.Test(priority = 3)
	@Test
	public void deletePurchaseOrderByID() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	 String reponse =	given()
		      .header("Content-Type", "application/json")
		      .pathParam("id", id)
	   .when()
	        
		    .delete("/store/order/{id}")
		    
	   .then()
	        .assertThat()
	        .log().all()
	        .statusCode(200)
	        .extract().response().asString();
	 JsonPath js = new JsonPath(reponse);
	 String messageValue =  js.getString("message");
	 Assert.assertEquals(messageValue, id);
	}
}
