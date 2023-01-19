package StepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginStep {

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

    RequestSpecification request;

    @Then("User should see status code 401")
    public void user_should_see_status_code_401() throws Exception {

        prop.load(file);
        request = RestAssured.given();

        String tokenGenerated = prop.getProperty("token");
        request.header("Authorization","Bearer"+ tokenGenerated ).header("Content-Type", "application/json");

        String Appis="{\"email\":\"" + USEREMAIL + "\", \"password\":\"" + PASSWORD + "\"}";
        Response rs= request.body(Appis).post("/v2/auth/login");
        Assert.assertEquals(401,rs.getStatusCode());

//        prop.load(file); Data retreave form config
//        System.out.println(prop.getProperty("baseUrl"));
//        System.out.println(prop.getProperty("token"));


    }
}
