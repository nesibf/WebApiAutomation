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
                .then().body("data[0].id", equalTo(1))
                .and().body("data[0].name", equalTo("Geek Squad Services"))
                .and().body("data[0].createdAt", equalTo("2016-11-17T17:56:35.881Z"))
                .and().body("data[0].updatedAt", equalTo("2016-11-17T17:56:35.881Z"));
    }
}
