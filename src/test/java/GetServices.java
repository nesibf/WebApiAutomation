import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class GetServices extends BaseClass {

    @Test
    public void getServices() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/services");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void rateLimitReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }

    @Test
    public void searchReposReturns200() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/search/repositories?q=java");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();

        assertEquals(actualStatus, 200);
    }
}
