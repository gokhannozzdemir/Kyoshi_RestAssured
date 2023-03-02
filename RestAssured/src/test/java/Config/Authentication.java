package Config;

import Config.Authentication;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import java.lang.*;

public class Authentication {
    //token = DeFacto


    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZXJjaGFudElkIjoiYzgwYjdkOTctMDY1OC00ZWZlLTkzYjEtYjJmMmFhOWY3YjdlIiwiVXNlcm5hbWUiOiJEZUZhY3RvIiwiaXAiOiIxODguMTE5LjM5LjE0MyIsImhiYWRtaW4iOiJnb2toYW4ub3pkZW1pciIsImFkbWluSWQiOiJlMDJhNmZlYy0yODBlLTRhMTYtYWRhMC1iNjdlZTllNjIxMWUiLCJpYXQiOjE2Nzc1Njc2MzYsImlzcyI6ImVudjpwcm9kdWN0aW9uIiwidXNlcklkIjoiYzg1MmUzNTAtOWQ2My00MzQ4LTk3N2EtOWM0OWM1YWU5MWFmIiwiZXhwIjoxNjc3NjU0MDM2fQ.krsUtFs_r5I-3pXUER-KS3Y6ZiS7nrW-girUPQpUfdw";
//
//    public String username = "gokhan.ozdemir";
//    public String password = "***********";


    //public String jirenPROD = System.getenv("jirenPROD");
    public String jirenPROD = "http://localhost:3000";
    public String localProd = "http://localhost:3000";


}


