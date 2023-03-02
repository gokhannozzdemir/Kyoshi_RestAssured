package JirenSteps;

import Config.Authentication;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.lessThan;


public class Product extends Authentication {

    @Test
    public void Buybox(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("sku","HBV0000032ZXU")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/product/buybox")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
}
