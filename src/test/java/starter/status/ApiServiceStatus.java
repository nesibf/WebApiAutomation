package starter.status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.JsonConverter;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static net.serenitybdd.rest.SerenityRest.expect;
import static net.serenitybdd.rest.SerenityRest.get;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
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
