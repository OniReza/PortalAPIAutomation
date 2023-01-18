package StepDefinations;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.apache.http.client.methods.RequestBuilder.post;
import java.util.Properties;
import org.json.JSONObject;


public class TestStep2 {
    Properties prop=new Properties();
    FileInputStream file;
    {
        try {
            file = new FileInputStream("./src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String USEREMAIL = "stalin.neurotrade.tst.1@mailinator.com";
    private static final String PASSWORD = "Tt123#123#";

    private static String token ;
   private static String jsonString;

    RequestSpecification request;
    @Given("A valid csrf token")
    public void a_valid_csrf_token() throws Exception {

        prop.load(file);
        RestAssured.baseURI  = prop.getProperty("baseUrl");
        request = RestAssured.given();
        response=request.get("/v2/auth/csrf");

        jsonString = response.asString();
        token = JsonPath.from(jsonString).get().toString();
        System.out.println(token);
        Utils.setEnvVariable(token);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }
    Response response;

    @When("User hit the end point")
    public void user_hit_the_end_point() throws Exception {

        String jsonstring=response.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonstring).get("token");
        request.header("Authorization","Bearer"+ tokenGenerated ).header("Content-Type", "application/json");

        String Appis="{\"email\":\"" + USEREMAIL + "\", \"password\":\"" + PASSWORD + "\"}";
        Response rs= request.body(Appis).post("/v2/auth/login");

        System.out.println(rs.getStatusCode());
        Assert.assertEquals(401,rs.getStatusCode());

    }
    @Then("User should see status code 401")
    public void user_should_see_status_code_401() throws Exception {

        String Appis="{\"email\":\"" + USEREMAIL + "\", \"password\":\"" + PASSWORD + "\"}";
        Response rs= request.body(Appis).post("/v2/auth/login");
        Assert.assertEquals(401,rs.getStatusCode());
    }

}
