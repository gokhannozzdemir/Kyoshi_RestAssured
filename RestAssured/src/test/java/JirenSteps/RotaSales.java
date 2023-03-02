package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class RotaSales extends Authentication {

    @Test
    public void RotaProductSales(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/product/sales")
                .then()
                .assertThat()
                .body(("items.totalQuantity"),everyItem(greaterThanOrEqualTo(1)))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test
    public void RotaBrandSales(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/brand/sales")
                .then()
                .assertThat()
                .body("items.totalQuantity",everyItem(greaterThanOrEqualTo(1)))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test
    public void RotaCategorySales(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/category/sales")
                .then()
                .assertThat()
                .body("items.totalQuantity",everyItem(greaterThanOrEqualTo(1)))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test
    public void RotaSummarySales(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/summary/sales")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }


}
