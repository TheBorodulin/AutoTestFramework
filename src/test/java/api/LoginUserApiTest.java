package api;

import org.junit.Assert;
import org.junit.Test;
import api.constants.RequestPaths;
import api.models.LoginUserDTO;
import api.models.LoginSuccessResponseDTO;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static io.restassured.http.ContentType.JSON;

public class LoginUserApiTest {
    @Test
    public void verifySuccessfulUserLogin() {
        final String email = "eve.holt@reqres.in";
        final String password = "cityslicka";

        LoginUserDTO loginUserDTO = LoginUserDTO.builder()
                .email(email)
                .password(password)
                .build();

        useRelaxedHTTPSValidation();

        LoginSuccessResponseDTO response = RestAssured.given()
                .baseUri(RequestPaths.BASE_URL)
                .basePath(RequestPaths.LOGIN)
                .contentType(JSON)
                .body(loginUserDTO)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().as(LoginSuccessResponseDTO.class);

        Assert.assertNotNull(response.getToken());
    }
}