package StepDefinations;

import Utility.SignupBody;
import Utility.SubscriptionBody;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SubscriptionStep {

    private static String bearerToken ;
    Properties prop=new Properties();
    SubscriptionBody.Subscription sub=new SubscriptionBody.Subscription();

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
    @When("User hit the end point for partner subscription")
    public void User_input_signup_information()throws Exception{
        prop.load(file);
        RestAssured.baseURI  = prop.getProperty("pbaseUrl");

        String SubscriptionEndPoint=prop.getProperty("SubscriptionEndPoint");
        String key = prop.getProperty("key");
        String token = prop.getProperty("ptoken");
        String contactID = prop.getProperty("contactID");

        response = given().headers(
                        "X-AU-Key" , key,
                        "X-AU-Token", token,
                        "contactId" , contactID,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .body(sub.sub_body())
                .when().post(SubscriptionEndPoint)
                .then().extract().response();

        Assert.assertEquals(200,response.getStatusCode());
    }

    @Then("User should see subscription complete successfully")
    public void User_input_signup_information_Test(){
        Assert.assertEquals(200,response.getStatusCode());
        Data2 =response.getBody().prettyPrint();
        System.out.println(Data2);

    }
}
