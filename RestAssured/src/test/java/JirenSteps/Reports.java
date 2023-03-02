package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class Reports extends Authentication {
    @Test
    public void AddView(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("skus","HBCV0000166Z1K")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/reports/add-view")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void AddViewHeader(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/reports/add-view/header")
                .then()
                .assertThat()
                .body("totalViewCount",greaterThanOrEqualTo(1))
                .body("distinctViewCount",greaterThanOrEqualTo(1))
                .body("addCounts",greaterThanOrEqualTo(1))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }

}
