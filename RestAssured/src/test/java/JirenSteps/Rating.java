package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Rating extends Authentication {


    @Test
    public void RatingMerchantSummary(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/rating/merchant/summary")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void Rating(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/rating")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test
    public void RatingMerchantScore(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD + "/api/v1/rating/merchant/score")
                .then()
                .assertThat()
                .body("overallExperience",greaterThanOrEqualTo(4F))
                .body("packaging",greaterThanOrEqualTo(4F))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }

}
