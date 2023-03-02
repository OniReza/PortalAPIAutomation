package StepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.github.javafaker.App;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SignUpStep {



    private static String bearerToken ;
    Properties prop=new Properties();

    FileInputStream file;
    {
        try {
            file = new FileInputStream("./src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    RequestSpecification request;

    @When("User hit the end point fo sign up")
    public void User_input_signup_information() throws Exception {

        RestAssured.baseURI = "https://api.dev.auws.cloud";
        Response response = given().headers(
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON
                )
                .when().get("/v2/auth/csrf")
                .then().assertThat().statusCode(200).body("status", equalTo("success"))
                .extract().response();
         bearerToken = response.getBody().path("data.csrfToken.token");



    }

    @Then("User should see status code 200")
    public void User_input_signup_information_Test(){

        RestAssured.baseURI = "https://api.dev.auws.cloud/";
        Response response3 = given().headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .body("{\n" +
                        "    \"email\":\"karlos.aubitpay.dev.41@mailinator.com\",\n" +
                        "    \"password\": \"Tt123#123#\",\n" +
                        "    \"firstName\": \"Jane\",\n" +
                        "    \"lastName\": \"Rasmus\",\n" +
                        "    \"latinFirstName\": \"Janek\",\n" +
                        "    \"latinLastName\": \"Rasmuss\",\n" +
                        "    \"countryCode\": \"GB\",\n" +
                        "    \"dateOfBirth\": \"1990-11-24\",\n" +
                        "    \"addressLine1\": \"someplace\",\n" +
                        "    \"addressLine2\": \"\",\n" +
                        "    \"city\": \"somewhere \",\n" +
                        "    \"postCode\": \"1516\",\n" +
                        "    \"doNotEmail\": true,\n" +
                        "    \"mobileNumber\": \"+4479405089359\",\n" +
                        "    \"preferredDisplayLanguage\": \"en\",\n" +
                        "    \"isTermsAgreed\": true\n" +
                        "}")
                .when().post("v2/auth/onboarding/signup")
                .then().extract().response();

        Assert.assertEquals(200,response3.getStatusCode());
    }
}

