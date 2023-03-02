package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;

import static io.restassured.RestAssured.given;

public class RotaCancels extends Authentication {

    @Test
    public void RotaProductCancels(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/product/cancels")
                .then()
                .assertThat()
                .body("items[]",everyItem(hasValue("averagePrice")))
                .body("items[]",everyItem(hasValue("lostFromCancels")))
                .body("items[]",everyItem(hasValue("totalQuantity")))
                .body("items[]",everyItem(hasValue("totalCancels")))
                .body("items[]",everyItem(hasValue("cancelRate")))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void RotaBrandCancels(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/brand/cancels")
                .then()
                .assertThat()
                .body("totalCount",greaterThan(0))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void RotaCategoryCancels(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/category/cancels")
                .then()
                .assertThat()
                .body("totalCount",greaterThanOrEqualTo(0))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void RotaSummaryCancels(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/summary/cancels")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }



}
