//package JirenSteps;
//
//import Config.Authentication;
//import io.restassured.http.ContentType;
//import org.junit.jupiter.api.Test;
//import static org.hamcrest.Matchers.*;
//
//
//import static io.restassured.RestAssured.given;
//
//public class Coupons extends Authentication {
//
////    @Test //Post Method
////    public void MerchantCoupon(){
////        given()
////                .contentType(ContentType.JSON)
////                .accept(ContentType.JSON)
////                .header("Authorization","Bearer "+token)
////                .when()
////                .post(jirenPROD+"/api/v1/coupon-api/merchant-coupons")
////                .then()
////                .body("campaignEndDate",equalTo(""))
////                .body("campaignLimit",equalTo(""))
////                .body("campaignStartDate",equalTo(""))
////                .statusCode(200)
////                .log()
////                .all();
////    }
//
//    @Test
//    public void Merchants(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/merchant-coupons/merchants")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//    @Test
//    public void Coupons(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/coupons")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//    @Test
//    public void limits(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/limits")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//    @Test
//    public void Pending(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/merchant-coupons/merchants/pending")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//    @Test
//    public void Categories(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/merchant-categories")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//    @Test
//    public void AvailableCoupons(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/merchant-available-coupons")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//    @Test
//    public void Basic(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/merchant-categories/basic")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//    @Test
//    public void CouponIds(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .queryParam("couponId","22762699")
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/merchant-coupons/coupon")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//    @Test
//    public void Accepts(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/merchant-coupons/merchants/accept")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//    @Test
//    public void Banner(){
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .header("Authorization","Bearer "+token)
//                .when()
//                .get(jirenPROD+"/api/v1/coupon-api/merchant-coupons/merchants/banner")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .all();
//    }
//}
