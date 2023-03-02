package JirenSteps;

import Config.Authentication;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.joda.time.Interval;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ProductAnalytics extends Authentication {
    @Test
    public void ProductAnalytics(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("startDate", "2022-11-01")
                .queryParam("endDate","2022-12-04")
                .queryParam("skus","HBCV00002G9WMP") //Koton skus
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/product-analytics")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test
    public void Search(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("startDate", "2022-11-20")
                .queryParam("endDate","2022-12-09")
                .queryParam("skus","HBCV00001DQHDA") //Koton skus
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/product-analytics/search")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void Logs(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/product-analytics/logs")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void Limit(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/product-analytics/limit")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
}
