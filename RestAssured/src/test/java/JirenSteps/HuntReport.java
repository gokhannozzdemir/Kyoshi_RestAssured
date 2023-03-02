package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.joda.time.Seconds;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class HuntReport extends Authentication {

    @Test
    public void Hunts(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/hunts")
                .then()
                .assertThat()
                .time(lessThan(3000L)) // Milliseconds
                .log().ifStatusCodeIsEqualTo(200);
    }
//    @Test
//    public void HuntsDownload(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/hunts/download")
//                .then()
//                .statusCode(202)
//                .log().all();
    @Test
    public void HuntsDetail(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("offerCode","587621")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+ "/api/v1/hunts/detail")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();

    }
    @Test
    public void HuntsSummary(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("startDate","2022-06-19T00:00:00.000Z")
                .queryParam("endDate","2022-06-22T00:00:00.000Z")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/hunts/summary")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
}
