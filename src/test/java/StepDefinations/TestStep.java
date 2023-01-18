package StepDefinations;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonValue;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.apache.http.client.methods.RequestBuilder.post;
import java.util.Properties;

public class TestStep {

    Properties prop=new Properties();
    FileInputStream file;
    {
        try {
            file = new FileInputStream("./src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    private static final String USEREMAIL = "stalin.neurotrade.tst.1@mailinator.com";
    private static final String PASSWORD = "Tt123#123#";
    private static final String BASE_URL = "https://api.tst.auws.cloud";
    private static String token ;
    private static Response response;
    private static String jsonString;
    private static String responseBody;


    @Given("a valid Authorization key")
    public void iAmAnAuthorizedUser() {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = given();

        request.header("Content-Type", "application/json");

        response=request.get("/v2/auth/csrf");
       jsonString = response.asString();
        token = JsonPath.from(jsonString).get().toString();
        System.out.println(token);



    }

    @Given("user login into v2")
    public void iLoginUser(){

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = given();


        request.header("Content-Type", "application/json");


        response = request.body("{\"email\":\"" + USEREMAIL + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/v2/auth/login");

         String jsonString = response.asString();
         token = JsonPath.from(jsonString).get().toString();
        System.out.println(token);

    }
    }
