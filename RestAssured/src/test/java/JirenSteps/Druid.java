package JirenSteps;

import Config.Authentication;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Druid extends Authentication {

    @Test
    public void DruidOrdersFeedbacks(){
        RestAssured
                .given()
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD +"/api/v1/druid/orders/feedbacks")
                .then()
                .assertThat()
                .body("overallExperience",lessThanOrEqualTo(10F))
                .body("overallExperience",greaterThanOrEqualTo(8F))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void DruidRatingHistorical(){
        given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+ token)
                .get(jirenPROD + "/api/v1/druid/rating/historical")
                .then()
                .assertThat()
//                .body("rating",everyItem(greaterThanOrEqualTo(8F)))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test
    public void DruidOrderHistory(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+ token)
                .get(jirenPROD + "/api/v1/druid/merchant/order/history")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void DruidReviewHistory(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+ token)
                .get(jirenPROD + "/api/v1/druid/merchant/review/history")
                .then()
                .assertThat()
                .body(anyOf(containsString("review")))
                .body(anyOf(containsString("overallExperience")))
                .body(anyOf(containsString("timeliness")))
                .body(anyOf(containsString("packaging")))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void DruidMerchantProduct(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/druid/merchant/product?type=claim")
                .then()
                .assertThat()
//                .body(anyOf(containsString("sku")))
//                .body(anyOf(containsString("orderno")))
//                .body(anyOf(containsString("productName")))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();

    }
    @Test
    public void DruidClaimReasons(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("sku","HBV00000IR040")
                .queryParam("startDate","2021-01-01T00:00:00.000Z")
                .queryParam("endDate","2022-09-01T00:00:00.000Z")
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/druid/claim-reasons")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void Commission(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/commission")
                .then()
                .assertThat()
                .body(anyOf(containsString("totalPrice")))
                .body(anyOf(containsString("totalQuantity")))
                .body(anyOf(containsString("totalLineItems")))
                .body(anyOf(containsString("merchantId")))
                .body(anyOf(containsString("startDate")))
                .body(anyOf(containsString("endDate")))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }




}
