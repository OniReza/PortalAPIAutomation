package StepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SignUpStep {
    private static String bearerToken ;
    Properties prop=new Properties();
    Response response=new RestAssuredResponseImpl();
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
    public void User_input_signup_information()throws Exception{
        prop.load(file);
        RestAssured.baseURI  = prop.getProperty("baseUrl");
        String origin=prop.getProperty("origin");
        String public_csrf=prop.getProperty("CRFTokenEndPoint");

    response = given().headers(
                        "origin" , origin,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON
                )
                .when().get(public_csrf)
                .then().assertThat().statusCode(200).body("status", equalTo("success"))
                .extract().response();
         bearerToken = response.getBody().path("data.csrfToken.token");

        String SignupEndPoint=prop.getProperty("SignUpEndPoint");

         response= given().headers(

                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .body("{\n" +
                        "    \"email\":\"markpiter.hodl.tst.41@mailinator.com\",\n" +
                        "    \"password\": \"Tt123#123#\",\n" +
                        "    \"firstName\": \"Mack\",\n" +
                        "    \"lastName\": \"Markas\",\n" +
                        "    \"latinFirstName\": \"Kanek\",\n" +
                        "    \"latinLastName\": \"Rasmuss\",\n" +
                        "    \"countryCode\": \"GB\",\n" +
                        "    \"dateOfBirth\": \"1990-11-24\",\n" +
                        "    \"addressLine1\": \"someplace\",\n" +
                        "    \"addressLine2\": \"\",\n" +
                        "    \"city\": \"somewhere \",\n" +
                        "    \"postCode\": \"1516\",\n" +
                        "    \"doNotEmail\": true,\n" +
                        "    \"mobileNumber\": \"+4479405086866\",\n" +
                        "    \"preferredDisplayLanguage\": \"en\",\n" +
                        "    \"isTermsAgreed\": true\n" +
                        "}")

                .when().post(SignupEndPoint)
                .then().extract().response();
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Then("User should see portal sign up complete")
    public void User_input_signup_information_Test(){
        Assert.assertEquals(200,response.getStatusCode());
    }
}

