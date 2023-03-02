package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;

public class RotaReturns extends Authentication {

    @Test
    public void ProductReturns(){
        given()
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/product/returns")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void BrandRetuns(){
        given()
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/brand/returns")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test
    public void CategoryReturns(){
        given()
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/category/returns")
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test
    public void SummaryReturns(){
        given()
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/rota/merchant/summary/returns")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }

}
