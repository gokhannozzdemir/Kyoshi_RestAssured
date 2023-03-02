package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class CouponReport extends Authentication {

    @Test
    public void CouponReport(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("from","2023-01-01")
                .queryParam("to","2023-01-31")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/coupon-report")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void CouponReportSummary(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/coupon-report/summary")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
}
