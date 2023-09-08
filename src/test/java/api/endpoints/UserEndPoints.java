package api.endpoints;
import static io.restassured.RestAssured.*;
import api.payloads.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	
	  public static Response createUser(UserPayload payload){
		  
		Response response = given()
		  .accept(ContentType.JSON)
		  .contentType(ContentType.JSON)
		  .body(payload)
		  .when()
		  .post(Routes.post_url);
		  
		return response;
		  
	  }
	  
	  public static Response getUser(String userName){
		  
			Response response = given()
			  .accept(ContentType.JSON)
			  .pathParam("username", userName)
			   .when()
			  .get(Routes.get_url);
			  
			return response;
			  
		  }
	  
	  public static Response updateUser(UserPayload payload,String userName){
		  
			Response response = given()
			  .accept(ContentType.JSON)
			  .contentType(ContentType.JSON)
			  .pathParam("username", userName)
			  .body(payload)
			  .when()
			  .put(Routes.put_url);
			  
			return response;
			  
		  }
	  
	  public static Response deleteUser(String userName){
		  
			Response response = given()
			  .accept(ContentType.JSON)
			  .pathParam("username", userName)
			   .when()
			  .delete(Routes.delete_url);
			  
			return response;
			  
		  }


}
