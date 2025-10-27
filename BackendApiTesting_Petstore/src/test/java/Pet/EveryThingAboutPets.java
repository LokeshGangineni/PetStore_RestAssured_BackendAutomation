package Pet;

import org.testng.annotations.Test;

import com.petStore.api.PojoClass.PetPojo;
import com.petStore.api.baseClass.BaseApiClass;
import com.petStore.api.endpoints.IendPoints;
import com.petStore.api.genericUtility.JsonUtility;

import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.List;


public class EveryThingAboutPets extends BaseApiClass {

	JsonUtility jsonutil = new JsonUtility();
	
	@Test
	public void addNewPetToStoreTest() {
		
		List<String> photo = Arrays.asList("https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?cs=srgb&dl=pexels-chevanon-1108099.jpg&fm=jpg");
		PetPojo petpojo = new PetPojo("Charile",photo);
		
		String addPet = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \""+"Charile"+"\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		Response resp = given()
			.spec(reqBuild)
			.body(petpojo)
		.when()
			.post(IendPoints.addnewPetToStore);
		resp.then()
			.spec(respBuild)
			.log().all();
		
		 Object petId = jsonutil.getDataOnJsonPath(resp, ".id");
		 System.out.println(petId);
	}
}
