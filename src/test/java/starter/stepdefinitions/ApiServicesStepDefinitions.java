package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.status.ApiServiceStatus;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;
import static starter.WebServiceEndPoints.SERVICES;
import static starter.status.ServiceStatus.RUNNING;

public class ApiServicesStepDefinitions {

    @Steps
    private ApiServiceStatus apiService;

    @Given("the end point is alive")
    public void the_end_point_is_alive() {
        assertThat(apiService.currentStatus(SERVICES.getUrl())).isEqualTo(RUNNING);
    }

    @When("I check the API status")
    public void i_check_the_API_status() {
        apiService.readMessageContent(SERVICES.getUrl());
    }

    @Then("the API returns data")
    public void the_API_returns_data() {
        apiService.readMessageData(SERVICES.getUrl());
    }
}
