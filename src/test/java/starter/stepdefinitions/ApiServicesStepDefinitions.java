package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.Ensure;
import net.thucydides.core.annotations.Steps;
import starter.status.ApiServiceStatus;

import static net.serenitybdd.rest.SerenityRest.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static starter.status.ServiceStatus.RUNNING;

public class ApiServicesStepDefinitions {

    @Steps
    private ApiServiceStatus apiService;

    @Given("the end point is alive")
    public void the_end_point_is_alive() {
        assertThat(apiService.currentStatus()).isEqualTo(RUNNING);
    }

    @When("I check the API status")
    public void i_check_the_API_status() {
        apiService.readStatusMessage();
    }

    @Then("the API returns user '(.*)'")
    public void the_API_returns_user(String username) {
        apiService.getSpecificUser(username);
    }
}
