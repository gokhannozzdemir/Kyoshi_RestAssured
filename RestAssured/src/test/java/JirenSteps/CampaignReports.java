package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.hamcrest.number.BigDecimalCloseTo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CampaignReports extends Authentication {


    @Test
    public void Campaigns(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD+ "/api/v1/campaigns")
                .then()
                .assertThat()
//                .body(allOf(containsString("offerCode")))
//                .body(anyOf(containsString("variantCount")))
//                .body(anyOf(containsString("preDiscountDiff")))
//                .body(anyOf(containsString("postDiscount")))
//                .body(anyOf(containsString("preDiscount")))
//                .body(anyOf(containsString("discountRate")))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }

//    @Test
//    public void CampaignDownload(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .queryParam("startDate","2022-08-01T00:00:00.000Z")
//                .queryParam("endDate","2022-09-01T00:00:00.000Z")
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD + "/api/v1/campaigns/download")
//                .then()
//                .statusCode(202)
//                .log().all();
//    }

    @Test
    public void CampaignDetail(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("offerCode",561911)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD + "/api/v1/campaigns/detail")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test
    public void CampaignSummary(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer " + token)
                .when()
                .get(jirenPROD + "/api/v1/campaigns/summary")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }


}













