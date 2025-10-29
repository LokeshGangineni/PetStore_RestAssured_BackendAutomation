package User;

import org.testng.annotations.Test;

import com.petStore.api.baseClass.BaseApiClass;
import com.petStore.api.endpoints.IendPoints;

import static io.restassured.RestAssured.*;



public class OperationsAboutUserTest extends BaseApiClass {
	
	IendPoints endpoints;
	
	@Test
	public void cretaeUser()
	{

		UserPOJO user= new UserPOJO(53,"LOKI", "Lokesh", "Gangineni", "lokesh@gmail.com", "loki@1304", "9876543210", 0);
		
		
		given()
			.spec(reqBuild)
			.body(user)
		.when().post(endpoints.createUser)
		.then()
			.log().all();
	}

}
