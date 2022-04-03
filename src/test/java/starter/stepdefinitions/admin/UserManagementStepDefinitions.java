package starter.stepdefinitions.admin;

import com.hrm.enums.UserRole;
import com.hrm.steps.LoginSteps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UserManagementStepDefinitions {
	@Steps
	LoginSteps loginSteps;

	@ParameterType(".*")
	public UserRole userRole(String userRole) {
		return Enum.valueOf(UserRole.class, userRole);
	}

	@Given("a user with role '{userRole}' logs in")
	@When("a user with role '{userRole}' logs in with valid credentials")
	public void a_user_with_role_logs_in_with_valid_credentials(UserRole userRole) {
		loginSteps.openLoginPage();
		loginSteps.loginAsUser(userRole);
	}

	@Then("home page should be displayed according to the '{userRole}'")
	public void home_page_should_be_displayed_according_to_the(UserRole userRole) {
		loginSteps.checkMenusInHomePage(userRole);
	}

	@When("the admin user adds a ESS user role to the employee")
	public void the_admin_user_adds_a_ess_user_role_to_the_employee() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the new user should be able to login to the application")
	public void the_new_user_should_be_able_to_login_to_the_application() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
