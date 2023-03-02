package JirenSteps;

import Config.Authentication;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Marketplace extends Authentication {

    @Test
    public void Marketplace(){

        RestAssured.given()
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/marketplace/brand-preference")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();

    }
}
