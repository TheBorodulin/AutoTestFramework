package api;

import org.junit.Assert;
import org.junit.Test;
import api.constants.RequestPaths;
import api.models.RegisterUserDTO;
import api.models.RegisterSuccessResponseDTO;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static io.restassured.http.ContentType.JSON;

public class RegisterUserApiTest {
    @Test
    public void verifySuccessfulUserRegistration() {
        final String email = "eve.holt@reqres.in";
        final String password = "pistol";

        RegisterUserDTO registerUserDTO = RegisterUserDTO.builder()
                .email(email)
                .password(password)
                .build();

        useRelaxedHTTPSValidation();

        RegisterSuccessResponseDTO response = RestAssured.given()
                .baseUri(RequestPaths.BASE_URL)
                .basePath(RequestPaths.REGISTER)
                .contentType(JSON)
                .body(registerUserDTO)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().as(RegisterSuccessResponseDTO.class);

        Assert.assertTrue(response.getId() > 0);
        Assert.assertNotNull(response.getToken());
    }
}