package StepDefinations;

import io.cucumber.java.en.When;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Origin {


    private CloseableHttpClient client;
    private CloseableHttpResponse response;
    private String origin;

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String url) throws IOException {
        client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        response = client.execute(request);
        origin = response.getFirstHeader("Origin").getValue();
    }
}
