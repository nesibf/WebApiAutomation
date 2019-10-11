import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseClass {

    CloseableHttpClient client;
    CloseableHttpResponse response;

    private static final String SERVER = "ec2-3-15-24-92.us-east-2.compute.amazonaws.com";
    private static final String PORT = "3030";
    protected static final String BASE_ENDPOINT = "http://" + SERVER + ":" + PORT;

    @BeforeMethod
    public void setup(){
        client  = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }

}
