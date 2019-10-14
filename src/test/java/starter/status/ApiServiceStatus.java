package starter.status;

import io.restassured.RestAssured;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.get;
import static starter.WebServiceEndPoints.USERS;

public class ApiServiceStatus {

    public ServiceStatus currentStatus() {
        int statusCode = RestAssured.get(USERS.getUrl()).statusCode();
        return (statusCode == 200) ? ServiceStatus.RUNNING : ServiceStatus.DOWN;
    }

    @Step("Get current status message")
    public void readStatusMessage() {
        get(USERS.getUrl());
    }

    @Step("Get specific user")
    public void getSpecificUser(String username) {
//        get(USERS + "/" + username);
    }
}
