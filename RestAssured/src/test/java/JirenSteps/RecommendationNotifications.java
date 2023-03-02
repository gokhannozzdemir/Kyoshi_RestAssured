package JirenSteps;

import Config.Authentication;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class RecommendationNotifications extends Authentication {

    @Test
    public void RecommendationNotifications (){

        RestAssured.given()
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD +"/api/v1/sales-assistant/recommendation-notifications")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(11000L)) // Milliseconds
                .log()
                .all();
    }


}
