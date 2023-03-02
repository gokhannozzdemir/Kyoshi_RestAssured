package JirenSteps;

import Config.Authentication;
import org.apache.http.message.TokenParser;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.*;

public class Hermes extends Authentication {


    @Test
    public void HermesBrands(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/hermes/brands")
                .then()
                .assertThat()
                .body(anyOf(containsString("id")))
                .body(anyOf(containsString("name")))
                .body(anyOf(containsString("brandId")))
                .body(anyOf(containsString("createdAt")))
                .body(anyOf(containsString("updatedAt")))
                .statusCode(200)
                .log().all();
    }

    @Test
    public void HermesCategories(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/hermes/categories")
                .then()
                .assertThat()
                .body(anyOf(containsString("id")))
                .body(anyOf(containsString("mainCategoryId")))
                .body(anyOf(containsString("categoryName")))
                .body(anyOf(containsString("h1Desc")))
                .body(anyOf(containsString("h1")))
                .body(anyOf(containsString("createdAt")))
                .body(anyOf(containsString("updatedAt")))
                .body("totalCount",greaterThan(0))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();

    }

    @Test
    public void HermesCategoryName(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/hermes/category-names")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }

    @Test
    public void HermesProductSummary(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/hermes/products-summary")
                .then()
                .assertThat()
                .body(anyOf(containsString("name")))
                .body(anyOf(containsString("sku")))
                .body(anyOf(containsString("variantOption")))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();

    }
    @Test
    public void HermesSearchBrandCategory(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("categoryIds","1515737")
                .header("Authorization", "Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/hermes/search/brand-category")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }

    @Test // Koton Brand
    public void HermesSearchBrand(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("name","Koton")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/hermes/search/brand")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void HermesSearchCategory(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("name","Kulaklik")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/hermes/search/category")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void HermesSearchProduct(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("name","apple")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/hermes/search/product")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }

    @Test
    public void HermesMinPriceLost(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/hermes/min-price/lost")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();

    }
}
