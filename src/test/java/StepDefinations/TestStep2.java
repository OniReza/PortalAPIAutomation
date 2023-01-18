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
    private static final String BASE_URL = "https://api.tst.auws.cloud";
    private static String token ;
    private static String token2 ;
    private static String jsonString;
    private static String responseBody;


    RequestSpecification request;
    @Given("^Login API is provided$")
    public void login_API_is_provided() throws Exception {

        prop.load(file);
        RestAssured.baseURI  = prop.getProperty("baseUrl");
        request = RestAssured.given();
        response=request.get("/v2/auth/csrf");

        jsonString = response.asString();
        token = JsonPath.from(jsonString).get().toString();
        System.out.println(token);
        Utils.setEnvVariable(token);

        String jsonstring=response.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonstring).get("token");
        request.header("Authorization","Bearer"+ tokenGenerated ).header("Content-Type", "application/json");

        String Appis="{\n" +
                "\t\"email\": \"stalin.neurotrade.tst.1@mailinator.com\",\n" +
                "\t\"password\": \"Tt123#123#\"\n" +
                "}";

       Response rs= request.body(Appis).post("/v2/auth/login");
       Assert.assertEquals(201,rs.getStatusCode());

    }
    Response response;

    @When("^User call login API$")
    public void user_call_customer_list_API() throws Exception {
//       Header authorizationHeader = new Header("Authorization",(token));
//        request.header(authorizationHeader);
//
//        response = request.body("{\"email\":\"" + USEREMAIL + "\", \"password\":\"" + PASSWORD + "\"}")
//                .post("/v2/auth/login");

        RestAssured.baseURI  = prop.getProperty("baseUrl");
        request = RestAssured.given();


    }


    @Then("^a token will be generated$")
    public void a_token_will_be_generated() throws Exception {
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.print(response.asString());
        token= response.jsonPath().getString("token");
       // System.out.println(token);
       // Utils.setEnvVariable(token);

    }


}
