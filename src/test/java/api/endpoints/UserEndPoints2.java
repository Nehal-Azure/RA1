package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payloads.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	static ResourceBundle getUrl() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		return rb;
	}
	
	
	  public static Response createUser(UserPayload payload){
		  
		String post_url = getUrl().getString("post_url");
		  Response response = given()
		  .accept(ContentType.JSON)
		  .contentType(ContentType.JSON)
		  .body(payload)
		  .when()
		  .post(post_url);
		  
		return response;
		  
	  }
	  
	  public static Response getUser(String userName){
		  
		  String get_url = getUrl().getString("get_url");	
		  Response response = given()
			  .accept(ContentType.JSON)
			  .pathParam("username", userName)
			   .when()
			  .get(get_url);
			  
			return response;
			  
		  }
	  
	  public static Response updateUser(UserPayload payload,String userName){
		  
		  String put_url = getUrl().getString("put_url");		
		  Response response = given()
			  .accept(ContentType.JSON)
			  .contentType(ContentType.JSON)
			  .pathParam("username", userName)
			  .body(payload)
			  .when()
			  .put(put_url);
			  
			return response;
			  
		  }
	  
	  public static Response deleteUser(String userName){
		  
		  String delete_url = getUrl().getString("delete_url");	
			Response response = given()
			  .accept(ContentType.JSON)
			  .pathParam("username", userName)
			   .when()
			  .delete(delete_url);
			  
			return response;
			  
		  }


}
