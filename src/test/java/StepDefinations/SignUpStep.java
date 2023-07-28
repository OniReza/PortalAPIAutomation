package StepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import Utility.SignupBody;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Assert;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SignUpStep {
    private static String bearerToken ;
    Properties prop=new Properties();


    private Scenario scenario;
    public static String Data2;
    Response response=new RestAssuredResponseImpl();
    SignupBody.PortalSignup portal = new SignupBody.PortalSignup();

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }
    FileInputStream file;
    {
        try {
            file = new FileInputStream("./src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
                 .body(portal.portal_body())
                .when().post(SignupEndPoint)
                .then().extract().response();
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Then("User should see portal sign up complete")
    public void User_input_signup_information_Test(){
        Assert.assertEquals(200,response.getStatusCode());
        Data2 =response.getBody().prettyPrint();
        System.out.println(Data2);
        writeInReport(Data2);


        Logger.getLogger(Data2);

    }

    public void writeInReport(String reportPrint)
    {
        String consoleOutput = reportPrint;
        String escapedOutput = StringEscapeUtils.escapeHtml4(consoleOutput);
        String redColorMarkup = "<span style ='color: blue; height: auto; '>" + escapedOutput + "</span>";
        scenario.log(redColorMarkup);
    }


}

