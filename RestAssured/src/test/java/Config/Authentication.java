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

    public String token = "";
//
//    public String username = "***********";
//    public String password = "***********";


    //public String jirenPROD = System.getenv("jirenPROD");
    
    public String jirenPROD = "http://localhost:3000";


}


