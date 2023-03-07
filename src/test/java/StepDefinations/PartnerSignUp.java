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

public class PartnerSignUp {

    private static String bearerToken ;

    Response response=new RestAssuredResponseImpl();
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

    @When("User hit the end point for partner sign up")
    public void User_input_signup_information_Test()throws Exception{

        prop.load(file);
        RestAssured.baseURI  = prop.getProperty("pbaseUrl");

        String PSignupEndPoint=prop.getProperty("PSignUpEndPoint");
        String key = prop.getProperty("key");
        String token = prop.getProperty("ptoken");

        response = given().headers(
                        "X-AU-Key" , key,
                        "X-AU-Token", token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .body("{\n" +
                        "\t\"email\": \"saimond.icc.tst.9@sharklasers.com\",\n" +
                        "\t\"password\": \"Tt123#123\",\n" +
                        "    \"brand\" : \"INFINITYCLUBCARDSUS\",\n" +
                        "    \"preferredCardCurrency\": \"USD\",\n" +
                        "    \"title\": \"\",\n" +
                        "    \"firstName\": \"samual\",\n" +
                        "    \"lastName\": \"con\",\n" +
                        "    \"latinFirstName\": \"jems\",\n" +
                        "    \"latinLastName\": \"romi\",\n" +
                        "    \"dateOfBirth\": \"1995-01-01\",\n" +
                        "    \"phone\": \"+8801745254833\",\n" +
                        "    \"province\": \"\",\n" +
                        "    \"postCode\": \"55555\",\n" +
                        "    \"countryCode\": \"US\",\n" +
                        "    \"city\": \"New york\",\n" +
                        "    \"addressLine1\": \"test\",\n" +
                        "    \"state\": \"Texas\",\n" +
                        "    \"ssn\": \"\"\n" +
                        "}")

                .when().post(PSignupEndPoint)
                .then().extract().response();

        Assert.assertEquals(200,response.getStatusCode());
    }
     @Then("User should see partner sign up complete")
    public void User_input_signup_information()throws Exception{
         Assert.assertEquals(200,response.getStatusCode());

    }
}
