package StepDefinations;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.util.Properties;
import org.apache.http.impl.client.CloseableHttpClient;
import static io.restassured.RestAssured.given;


public class CsrfTokenStep {

    private CloseableHttpClient client;

    private String origin;
    Properties prop=new Properties();
    FileInputStream file;
    {
        try {
            file = new FileInputStream("./src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

   private static String token ;
   private static String jsonString;

    RequestSpecification request;
    @Given("A valid csrf token")
    public void a_valid_csrf_token() throws Exception {

        RequestSpecification request = given().headers("Path","https://api.tst.auws.cloud/");
       // Response response = request.when().get("https://example.com");

        prop.load(file);

        RestAssured.baseURI  = prop.getProperty("baseUrl");

        String ENDPOINT=prop.getProperty("CRFTokenEndPoint");
        request  = given();
        response=request.get(ENDPOINT);

        jsonString = response.asString();
        token = JsonPath.from(jsonString).get().toString();
        Utils.setEnvVariable(token);

    }
    Response response;

    @When("User hit the end point")
    public void user_hit_the_end_point() throws Exception {

        jsonString = response.asString();
        token = JsonPath.from(jsonString).get().toString();
        System.out.println(token);
    }

    @Then("The response code should {int}")
    public void theResponseCodeIs(int statusCode) {
        int status = response.getStatusCode();
        Assert.assertEquals(statusCode,status);
    }

    @Then("User should see CRF token is generated")
    public void User_should_see_CRF_token_generated() throws Exception {

        int statusCode = response.getStatusCode();
        Assert.assertEquals(200,statusCode);
        System.out.println(statusCode);
    }

//    @When("User hit the end point {string}")
//        public void test(String endpoint)
//        {
//
//        }
//
//        @Then("User choose {string}")
//        public void test2(String us)
//        {
//
//        }

}
