package StepDefinations;

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
import org.junit.Assert;
import java.util.Properties;
import static io.restassured.RestAssured.given;


public class PartnerSignUp {
    Response response=new RestAssuredResponseImpl();

    private Scenario scenario;
    public static String Data2;
    SignupBody.PortalSignup partner = new SignupBody.PortalSignup();
    Properties prop=new Properties();

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
                .body(partner.partner_body())
                .when().post(PSignupEndPoint)
                .then().extract().response();

        Assert.assertEquals(200,response.getStatusCode());
    }
     @Then("User should see partner sign up complete")
    public void User_input_signup_information(){
         Assert.assertEquals(200,response.getStatusCode());

         Data2 =response.getBody().prettyPrint();

         System.out.println(Data2);

         writeInReport();
    }

    public void writeInReport()
    {
        String consoleOutput = Data2;
        System.out.println(consoleOutput);
        scenario.log(consoleOutput);
    }

}
