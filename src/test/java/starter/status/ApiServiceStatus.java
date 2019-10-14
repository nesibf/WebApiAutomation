package starter.status;

import io.restassured.RestAssured;
import net.serenitybdd.rest.Ensure;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.SerenityRest.get;

public class ApiServiceStatus {

    @Step("Get status message")
    public ServiceStatus currentStatus(String url) {
        int statusCode = RestAssured.get(url).statusCode();
        return (statusCode == 200) ? ServiceStatus.RUNNING : ServiceStatus.DOWN;
    }

    @Step("Get message content")
    public void readStatusMessage(String url) {
        get(url).body();
        Ensure.that("Total is returned: ", response -> response.body("total", Matchers.equalTo(21)));
        Ensure.that("Limit is returned: ", response -> response.body("limit", Matchers.equalTo(10)));
        Ensure.that("Skip is returned: ", response -> response.body("skip", Matchers.equalTo(0)));
    }
}
