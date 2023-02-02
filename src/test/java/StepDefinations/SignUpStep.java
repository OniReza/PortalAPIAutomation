package StepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.github.javafaker.App;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SignUpStep {

    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private String origin;


    private static String jsonString;
    private static String token ;
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

    @When("User hit the end point with input signup information")
    public void User_input_signup_information() throws Exception {

        prop.load(file);
        String ENDPOINT=prop.getProperty("SignUpEndPoint");
        request = given();

        String tokenGenerated = prop.getProperty("token");
        request.header("Authorization","Bearer"+ tokenGenerated ).header("Content-Type", "application/json");

        System.out.println(tokenGenerated);

        String Appis="{\n" +
                "    \"email\":\"motin.aubitpay.dev.41@mailinator.com\",\n" +
                "    \"password\": \"Tt123#123#\",\n" +
                "    \"firstName\": \"Jane\",\n" +
                "    \"lastName\": \"Rasmussen\",\n" +
                "    \"latinFirstName\": \"Jane\",\n" +
                "    \"latinLastName\": \"Rasmussen\",\n" +
                "    \"countryCode\": \"GB\",\n" +
                "    \"dateOfBirth\": \"1990-11-24\",\n" +
                "    \"addressLine1\": \"someplace\",\n" +
                "    \"addressLine2\": \"\",\n" +
                "    \"city\": \"somewhere \",\n" +
                "    \"postCode\": \"1516\",\n" +
                "    \"doNotEmail\": true,\n" +
                "    \"mobileNumber\": \"+447940406309\",\n" +
                "    \"preferredDisplayLanguage\": \"en\",\n" +
                "    \"isTermsAgreed\": true\n" +
                "}";

      //  given().headers("Authorization","Bearer" + tokenGenerated).request().body(Appis).when().post(ENDPOINT).then().statusCode(200);

        RequestSpecification request = given().headers("Path","https://api.tst.auws.cloud/");

        Response rs= request.body(Appis).post(ENDPOINT);
        System.out.println(rs.getStatusCode());
        Assert.assertEquals(200,rs.getStatusCode());
        System.out.println(rs.getStatusCode());
    }
//    @Then("User should see status code 200")
//    public void user_should_see_status_code_200() throws Exception {
//        prop.load(file);
//        String ENDPOINT=prop.getProperty("SignUpEndPoint");
//        request = given();
//
//        String tokenGenerated = prop.getProperty("token");
//        request.header("Authorization","Bearer"+ tokenGenerated ).header("Content-Type", "application/json");
//
//        String Appis="{\n" +
//                "    \"email\":\"clubswana_us_devxmqo@.41@mailinator.com\",\n" +
//                "    \"password\": \"Tt123#123#\",\n" +
//                "    \"firstName\": \"Jane\",\n" +
//                "    \"lastName\": \"Rasmussen\",\n" +
//                "    \"latinFirstName\": \"Jane\",\n" +
//                "    \"latinLastName\": \"Rasmussen\",\n" +
//                "    \"countryCode\": \"GB\",\n" +
//                "    \"dateOfBirth\": \"1990-11-24\",\n" +
//                "    \"addressLine1\": \"someplace\",\n" +
//                "    \"addressLine2\": \"\",\n" +
//                "    \"city\": \"somewhere \",\n" +
//                "    \"postCode\": \"1516\",\n" +
//                "    \"doNotEmail\": true,\n" +
//                "    \"mobileNumber\": \"+447940406309\",\n" +
//                "    \"preferredDisplayLanguage\": \"en\",\n" +
//                "    \"isTermsAgreed\": true\n" +
//                "}";
//
//        Response rs= request.body(Appis).post(ENDPOINT);
//        System.out.println(rs.getStatusCode());
//        Assert.assertEquals(200,rs.getStatusCode());
//        System.out.println(rs.getStatusCode());
//
//    }

//    @When("I send a GET request to {string}")
//    public void iSendAGETRequestTo(String url) throws IOException {
//        client = HttpClients.createDefault();
//        HttpGet request = new HttpGet(url);
//        response = client.execute(request);
//        origin = response.getFirstHeader("Origin").getValue();
//    }

}

