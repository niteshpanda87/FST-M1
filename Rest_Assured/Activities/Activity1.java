package Activity;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Activity1 {
	
	// Set base URL
	final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";
  @Test(priority=1)
  public void addPet() {
	  // Create JSON Request
	  String reqBody = "{"
			  +"\"id\": 77232,"
			  +"\"name\": \"Riley\","
			  +"\"status\": \"alive\""
		+ "}";
	  
	  Response response =
			  given().contentType(ContentType.JSON)
			  .body(reqBody)
			  .log().all()
			  .when().post(ROOT_URI);
	  
	  // Assertion
	  response.then().log().all();
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status", equalTo("alive"));
  }

  @Test(priority=2)
  public void getPet() {
	  
	  Response response =
			  given().contentType(ContentType.JSON)
			  .when().pathParam("petId", "77232")
			  .get(ROOT_URI+ "/{petId}");
	  
	  // Assertion
	  response.then().log().all();
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status", equalTo("alive"));
  }
  
  @Test(priority=3)
  public void deletePet() {
	  
	  Response response =
			  given().contentType(ContentType.JSON)
			  .when().pathParam("petId", "77232")
			  .log().all()
			  .delete(ROOT_URI+ "/{petId}");
	  
	  // Assertion
	  response.then().log().all();
	  response.then().body("code", equalTo(200));
	  response.then().body("message", equalTo("77232"));
  }
}
