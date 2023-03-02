package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SalesAssistant extends Authentication {

    @Test
    public void StockRecommendation() {
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+ token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/stock-recommendations")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void SalesPotential(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/sales-potentials")
                .then()
                .assertThat()
                .body("items.reviewScore",hasItems(greaterThanOrEqualTo(3)))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
//    @Test
//    public void Download(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/sales-assistant/sales-potentials/down")
//                .then()
//                .assertThat()
//                .log()
//                .all();
//    }
    @Test
    public void Custom(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/lists/custom")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }

    @Test
    public void Favorites(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/lists/favorites")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void PriceDropAlarm(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/lists/price-drop-alarm")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void SaveForLater(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/lists/save-for-later")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void Chart(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("sku","HBCV000027RCYE")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/lists/chart")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void PriceAlertRecommendation(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/lists/price-alert-recommendation")
                .then()
                .assertThat()
                .body("items.buyboxOrder",everyItem(greaterThanOrEqualTo(1)))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void PriceAlertRecommendationFeedbacks(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/lists/price-alert-recommendation/feedbacks")
                .then()
                .assertThat()
                .body("items.price.action",anyOf(hasItems("accepted","liked","disliked")))
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void PriceAlertRecommendationAccepted(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/lists/price-alert-recommendation/accepted")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void LivePerformanceCount(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/live-performance/counts")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void PreviousDayPerformanceCounts(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/previous-day-performance/counts")
                .then()
                .assertThat()
                .body("previousDayTotalCount.totalPrice",notNullValue())
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void RecommendationsBySkus(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("skus","HBCV00000AIQYF")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/recommendations-by-skus")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();

    }
    @Test
    public void BuyboxLost(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("limit","100")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/buybox/lost")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
//    @Test //POST Method
//    public void ViewSuggestions(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .post(jirenPROD+"/api/v1/sales-assistant/view-suggestions")
//                .then()
//                .body("sku",equalTo(""))
//                .body("listingId",equalTo(""))
//                .body("mainCategoryId",equalTo(""))
//                .body("totalViewCount",equalTo(""))
//                .body("orderConversionRate",equalTo(""))
//                .body("warehouseStock",equalTo(""))
//                .body("stock",equalTo(""))
//                .statusCode(200)
//                .log()
//                .all();
//    }

    @Test
    public void RecommendationNotifications(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/recommendation-notifications")
                .then()
                .assertThat()
                .body("items.isRead",everyItem(comparesEqualTo(true)))
                .statusCode(200)
                .time(lessThan(11000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void OnePagerSummary(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("startDate","2022-09-04T00:00:00.000Z")
                .queryParam("endDate","2022-09-10T00:00:00.000Z")
                .queryParam("startDateCampaignHunt","2022-09-04T00:00:00.000Z")
                .queryParam("endDateCampaignHunt","2022-09-10T00:00:00.000Z")
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/one-pager/summary-campaign-period")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void OnePagerExtras(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/one-pager/extras")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void OnePagerDetails(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/claim-report/details")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test
    public void OnePagerClaimReport(){
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .get(jirenPROD+"/api/v1/sales-assistant/claim-report")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
}
