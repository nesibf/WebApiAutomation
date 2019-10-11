import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class GetServices extends BaseClass{

    @Test
    public void getServices() throws IOException {

        HttpGet get = new HttpGet(BASE_ENDPOINT + "/services");

        response = client.execute(get);

        int actualStatus = response.getStatusLine().getStatusCode();
        String actualValues = response.getStatusLine().toString();

        assertEquals(actualStatus, 200);
    }
}
