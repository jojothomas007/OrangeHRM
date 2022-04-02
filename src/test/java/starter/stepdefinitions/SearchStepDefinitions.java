package starter.stepdefinitions;

import com.hrm.steps.LoginSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchStepDefinitions {
	@Steps
	LoginSteps loginSteps;

	@When("user logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
		loginSteps.openApplication();
		loginSteps.enterValidCredentials();
	}

	@Then("home page should be displayed")
	public void home_page_should_be_displayed() {

	}
}
