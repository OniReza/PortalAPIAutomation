package StepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.util.Properties;

public class SignUpStep {

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
        request = RestAssured.given();

        String tokenGenerated = prop.getProperty("token");
        request.header("Authorization","Bearer"+ tokenGenerated ).header("Content-Type", "application/json");

        String Appis="{\n" +
                "    \"email\":\"sahin.aubitpay.dev.41@mailinator.com\",\n" +
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
                "    \"mobileNumber\": \"+447940406909\",\n" +
                "    \"preferredDisplayLanguage\": \"en\",\n" +
                "    \"isTermsAgreed\": true\n" +
                "}";

        Response rs= request.body(Appis).post(ENDPOINT);
        System.out.println(rs.getStatusCode());
        Assert.assertEquals(200,rs.getStatusCode());
        System.out.println(rs.getStatusCode());

    }
    @Then("User should see status code 200")
    public void user_should_see_status_code_200() throws Exception {
//        prop.load(file);
//        String ENDPOINT=prop.getProperty("SignUpEndPoint");
//        request = RestAssured.given();
//
//
//        String Appis="{\n" +
//                "    \"email\":\"sahin.aubitpay.dev.41@mailinator.com\",\n" +
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
//                "    \"mobileNumber\": \"+447940406909\",\n" +
//                "    \"preferredDisplayLanguage\": \"en\",\n" +
//                "    \"isTermsAgreed\": true\n" +
//                "}";
//        String tokenGenerated = prop.getProperty("token");
//        request.header("Authorization","Bearer"+ tokenGenerated ).header("Content-Type", "application/json");
//
//        Response rs= request.body(Appis).post(ENDPOINT);
//        Assert.assertEquals(200,rs.getStatusCode());




    }
}
