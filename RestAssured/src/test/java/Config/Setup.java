package Config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static io.restassured.RestAssured.*;

public class Setup extends Authentication{

//    @Test
//    @Before
//    public void BasicAuthentication(){
//
//
//        given()
//                .auth().preemptive()
//                .basic(username,password)
//                .get("https://mpadmin.hepsiburada.com/v2/login")
//                .then()
//                .statusCode(200)
//                .log().all();
//    }

    @Test
    @Before
    public void JirenHealth(){
        given()
                .when()
                .get(jirenPROD+"/health")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
