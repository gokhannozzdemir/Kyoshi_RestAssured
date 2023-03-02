package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class RotaRating extends Authentication {
    @Test
    public void EvalReport(){
        given()
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/eval-report")
                .then()
                .assertThat()
                .body("AvgOverallExperience30Day",lessThanOrEqualTo(5F))
                .body("AvgOverallExperience60Day",lessThanOrEqualTo(5F))
                .body("AvgOverallExperience90Day",lessThanOrEqualTo(5F))
                .body("AvgOverallExperience180Day",lessThanOrEqualTo(5F))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void EvalReportChart(){
        given()
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/eval-report/chart")
                .then()
                .assertThat()
//                .body("items.ShippingScore",everyItem(lessThanOrEqualTo(10F)))
                .body("items.Score",everyItem(lessThanOrEqualTo(10F)))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();

    }
    @Test
    public void EvalReportDetail(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/eval-report/details")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().body();
    }
}
