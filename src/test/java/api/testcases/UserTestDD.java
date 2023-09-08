package api.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.UserPayload;
import api.utilities.DataProvider2;
import io.restassured.response.Response;

public class UserTestDD {
	
	UserPayload up;
	
	
	@Test(priority = 1,dataProvider = "AllData", dataProviderClass = DataProvider2.class)
	public void testCreateUserUsingDD(String id, String username, String firstname, String lastname, String email, String password, String phone, String status) {
		
		
		up = new UserPayload();
		up.setId(Long.parseLong(id));
		up.setUsername(username);
		up.setFirstName(firstname);
		up.setLastName(lastname);
		up.setEmail(email);
		up.setPassword(password);
		up.setPhone(phone);
		up.setUserStatus(Integer.parseInt(status));
		
		Response response = UserEndPoints.createUser(up);
		
		//log response
		response.then().log().all();
		response.prettyPrint();
		
		System.out.println(this.up.getUsername());
		
		//Assertion  Validating Response Code
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		
	}
	@Test(priority = 2,dataProvider = "UserNamesData",dataProviderClass = DataProvider2.class)
	public void testGetValidUserUsingDD(String username) {
		
		Response response = UserEndPoints.getUser(username);
		//Response response = UserEndPoints.getUser("glynis.ziemann");
		
		
		//log response
		response.then().log().all();
		response.prettyPrint();
		
		//Assertion  Validating Response Code
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		
	}

}
