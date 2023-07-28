package StepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
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
    RequestSpecification request;
    @Then("User should see status code 401")
    public void user_should_see_status_code_401() throws Exception {
        prop.load(file);
        String USEREMAIL=prop.getProperty("email");
        String PASSWORD=prop.getProperty("password");
        String ENDPOINT=prop.getProperty("LoginEndPoint");
        request = RestAssured.given();
        String tokenGenerated = prop.getProperty("token");
        request.header("Authorization","Bearer"+ tokenGenerated ).header("Content-Type", "application/json");
        String Appis="{\"email\":\"" + USEREMAIL + "\", \"password\":\"" + PASSWORD + "\"}";
        Response rs= request.body(Appis).post(ENDPOINT);
        Assert.assertEquals(401,rs.getStatusCode());
        System.out.println(rs.getStatusCode());

    }



}
