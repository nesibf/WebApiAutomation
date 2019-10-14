package starter.status;

import io.restassured.RestAssured;
import net.serenitybdd.rest.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.get;
import static org.hamcrest.Matchers.equalTo;

public class ApiServiceStatus {

    @Step("Get status message")
    public ServiceStatus currentStatus(String url) {
        int statusCode = RestAssured.get(url).statusCode();
        return (statusCode == 200) ? ServiceStatus.RUNNING : ServiceStatus.DOWN;
    }

    @Step("Get message content")
    public void readMessageContent(String url) {
        get(url).body();
        Ensure.that("Total is returned: ", response -> response.body("total", equalTo(21)));
        Ensure.that("Limit is returned: ", response -> response.body("limit", equalTo(10)));
        Ensure.that("Skip is returned: ", response -> response.body("skip", equalTo(0)));
    }

    @Step("Get message data")
    public void readMessageData(String url) {
        get(url)
                .then().body("total", equalTo(21))
                .and().body("limit", equalTo(10))
                .and().body("skip", equalTo(0));
    }
}
