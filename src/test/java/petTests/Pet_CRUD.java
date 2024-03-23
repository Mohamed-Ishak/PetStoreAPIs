package petTests;

import io.restassured.RestAssured;


import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;
public class Pet_CRUD {
	String  id ;
	@org.testng.annotations.Test(priority =1)  // TestNG annotations
	@Test                                      // JUnit  annotations
 	public void AddNewPet() throws IOException {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
	   String response = given()
			                    .header("Content-Type", "application/json")
			                    .body(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\src\\test\\java\\petTests\\addPet.json"))))
			            .when()
			                    .post("/pet")
			            .then() 
			                    .assertThat()
			                              
			                              .statusCode(200)                       
			                              .extract().response().asString();
	                                       
	   JsonPath js = new JsonPath(response);
	   id = js.getString("id");
	   System.out.println(id);
			                        
	}
	
	@org.testng.annotations.Test(priority = 2)
	@Test
	public void findPetsByStatus() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		given().header("Content-Type", "application/json").queryParam("status", "sold").when().get("/pet/findByStatus")
				.then().log().all().assertThat().statusCode(200);
	}
	
	@org.testng.annotations.Test(priority = 3)
	@Test
	public void updatePet() throws IOException {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		String updateResponse = given()
				.header("Content-Type", "application/json")
				.body(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\src\\test\\java\\petTests\\updatePet.json"))))
		.when()
		        .put("/pet")
		.then()
		       .assertThat()
		       .statusCode(200)
		       .extract().response().asString();
		System.out.println(updateResponse);
	}
	
	@org.testng.annotations.Test(priority = 3)
	@Test
	public void getPetByStatus() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		given()
				.header("Content-Type", "application/json")
				.queryParam("status","sold")
		.when()
		        .get("/pet/findByStatus")
		.then()
		        .log().all()
		.assertThat()
		        .statusCode(200);
	}
	
	@org.testng.annotations.Test(priority = 4)  
	@Test
	public void deletePet() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		String deletePet = given()
				.header("Content-Type", "application/json")
		.when()
		        .delete("/pet"+id)
		.then()
		        .assertThat()
		        .statusCode(404)
		        .extract().response().asString();
		System.out.println(deletePet);

	}
	

}
