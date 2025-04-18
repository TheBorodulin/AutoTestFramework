package api;

import org.junit.Assert;
import org.junit.Test;

import api.constants.RequestPaths;
import api.models.GetSingleUserResponseDTO;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static io.restassured.http.ContentType.JSON;

public class SingleUserApiTest {
    @Test
    public void verifySingleUserData() {
        useRelaxedHTTPSValidation();

        GetSingleUserResponseDTO response = RestAssured.given()
                .baseUri(RequestPaths.BASE_URL)
                .basePath(RequestPaths.SINGLE_USER)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().as(GetSingleUserResponseDTO.class);

        Assert.assertEquals(2, response.getData().getId());
        Assert.assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
        Assert.assertEquals("Janet", response.getData().getFirst_name());
        Assert.assertEquals("Weaver", response.getData().getLast_name());
        Assert.assertEquals("https://reqres.in/img/faces/2-image.jpg", response.getData().getAvatar());
        Assert.assertEquals("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral",
                response.getSupport().getUrl());
        Assert.assertEquals("Tired of writing endless social media content? Let Content Caddy generate it for you.",
                response.getSupport().getText());
    }
}