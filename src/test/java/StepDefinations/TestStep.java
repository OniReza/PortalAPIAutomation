package StepDefinations;


import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestStep {

    //private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    //private static final String USERNAME = "TOOLSQA-Test";
    //private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://api.tst.auws.cloud";

    private static String token ;
    private static Response response;
    private static String jsonString;
    private static String bookId;


    @Given("a valid Authorization key")
    public void iAmAnAuthorizedUser() {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

//        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
//                .get("/v2/auth/csrf");

        response=request.get("/v2/auth/csrf");

        jsonString = response.asString();
        token = JsonPath.from(jsonString).get("token");

        System.out.println(jsonString);

    }
}
