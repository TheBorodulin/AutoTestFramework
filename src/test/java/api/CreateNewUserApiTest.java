package api;

import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static io.restassured.http.ContentType.JSON;

import org.junit.Assert;
import org.junit.Test;

import api.constants.RequestPaths;
import api.models.CreateNewUserDTO;
import api.models.CreatedUserDTO;
import io.restassured.RestAssured;


public class CreateNewUserApiTest {
	@Test
	public void verifyThatNewUserCanBeCreatedApiTest() {
		final String name = "Andriy";
		final String job = "QA";
		CreateNewUserDTO newUserDTO = CreateNewUserDTO.builder().name(name).job(job).build();

		useRelaxedHTTPSValidation();

		CreatedUserDTO createdUser = RestAssured.given()
				.baseUri(RequestPaths.BASE_URL)
				.basePath(RequestPaths.CREATE_USER)
				.contentType(JSON)  // Set content type to application/json
				.body(newUserDTO)
				.when()
				.post()
				.then()
				.statusCode(201)
				.log().all()
				.extract().as(CreatedUserDTO.class);


		Assert.assertEquals("The response is not as expected", name, createdUser.getName());
	}
}
