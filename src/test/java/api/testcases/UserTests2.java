package api.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payloads.UserPayload;
import io.restassured.response.Response;

public class UserTests2 {
	
	//Create Method to generate test data
	
	Faker faker;
	UserPayload up;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData() {
		
		faker = new Faker();
		up = new UserPayload();
		up.setId(faker.idNumber().hashCode());
		up.setUsername(faker.name().username());
		up.setFirstName(faker.name().firstName());
		up.setLastName(faker.name().lastName());
		up.setEmail(faker.internet().safeEmailAddress());
		up.setPassword(faker.internet().password(5, 10));
		up.setPhone(faker.phoneNumber().cellPhone());
		up.setUserStatus(faker.number().numberBetween(1, 3));
		
		//Obtain Logger
		logger = LogManager.getLogger("RAFramework2");
			
	}
	
	@Test(priority = 1)
	public void testCreateUser() {
		
		Response response = UserEndPoints2.createUser(up);
				//log response
		response.then().log().all();
		response.prettyPrint();		
		System.out.println(this.up.getUsername());
		
		//Assertion  Validating Response Code
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		logger.info("Create user test executed succesfully");
		
	}
	@Test(priority = 2)
	public void testGetValidUser() {
		
		Response response = UserEndPoints2.getUser(this.up.getUsername());
		//Response response = UserEndPoints.getUser("glynis.ziemann");
		
		
		//log response
		response.then().log().all();
		response.prettyPrint();
		
		//Assertion  Validating Response Code
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		logger.info("Get user test executed succesfully");
		
	}
	@Test(priority = 3)
	public void testGetInValidUser() {
		
		Response response = UserEndPoints2.getUser("Fakeuser");
		
		//log response
		response.then().log().all();
		response.prettyPrint();
		
		//Assertion  Validating Response Code
		AssertJUnit.assertEquals(response.getStatusCode(),404);
		logger.info("Get user2 test executed succesfully");
		
	}
	@Test(priority = 4)
	public void testUpdateUser() {
		
		up.setFirstName(faker.name().firstName());
		Response response = UserEndPoints2.updateUser(this.up, up.getUsername());
		
		//log response
		response.then().log().all();
		response.prettyPrint();
		
		//Assertion  Validating Response Code
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		Response responseafterUpdate = UserEndPoints2.getUser(this.up.getUsername());
		responseafterUpdate.prettyPrint();
		logger.info("Update user test executed succesfully");
		
	}
	
	@Test(priority = 5)
	public void testGetUpdatedUser() {
		
		Response response = UserEndPoints2.getUser(this.up.getUsername());
		
		//log response
		response.then().log().all();
		response.prettyPrint();
		
		//Assertion  Validating Response Code
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		logger.info("Get updated user test executed succesfully");
		
	}
	@Test(priority = 6)
	public void testDeleteUser() {
		
		Response response = UserEndPoints2.deleteUser(this.up.getUsername());
		
		//log response
		response.then().log().all();
		response.prettyPrint();
		
		//Assertion  Validating Response Code
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		logger.info("delete user test executed succesfully");
		
	}

}
