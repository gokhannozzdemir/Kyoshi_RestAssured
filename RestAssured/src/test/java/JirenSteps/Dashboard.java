package JirenSteps;

import Config.Authentication;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.*;

public class Dashboard extends Authentication {



    @Test //Assert to totalMissedSales
    public void DashboardSummary(){
        given()
                .header("Authorization", "Bearer "+ token)
                .when()
                .get(jirenPROD + "/api/v1/rota/dashboard/summary")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log().all();
    }
    @Test // Daily parameters using at Overall endpoint
    public void DashboardOverall(){
        given()
                .queryParam("overallPerformanceDateFilter","daily")
                .queryParam("viewReportDateFilter","daily")
                .queryParam("evaluationDateFilter","daily")
                .queryParam("pageVisitDateFilter","daily")
                .header("Authorization","Bearer " +token)
                .when()
                .get(jirenPROD + "/api/v1/rota/dashboard/overall")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }
    @Test // Dashboard recommendation endpoint
    public void DashboardRecommendations(){
        given()
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Authorization","Bearer "+ token)
                .when()
                .get("https://jiren.hepsiburada.com/health")
                .then()
                .assertThat()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();

    }
    @Test
    public void DashboardMostViewed(){
        given()
                .header("Authorization","Bearer "+token)
                .queryParam("periods","1")
                .when()
                .get(jirenPROD + "/api/v1/dashboard/products/most-viewed")
                .then()
                .statusCode(200)
                .time(lessThan(3000L)) // Milliseconds
                .log()
                .all();
    }


}
