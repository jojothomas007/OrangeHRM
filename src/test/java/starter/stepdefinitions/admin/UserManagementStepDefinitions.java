package starter.stepdefinitions.admin;

import com.hrm.datagen.UserDatagen;
import com.hrm.entity.Employee;
import com.hrm.entity.User;
import com.hrm.enums.UserRole;
import com.hrm.steps.LoginSteps;
import com.hrm.steps.admin.UserManagementSteps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UserManagementStepDefinitions {
	@Steps
	LoginSteps loginSteps;
	@Steps
	UserManagementSteps userManagementSteps;
	@Steps(shared = true)
	Employee employee;
	@Steps(shared = true)
	User user;

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
		new UserDatagen().addUser(employee);
		userManagementSteps.addNewUser(employee);
	}

	@When("the current user logs out from OrangeHRM")
	public void the_current_user_logs_out_from_orange_hrm() {
		userManagementSteps.logout();
		loginSteps.loginPageShoudBeDisplayed();
	}

	@Then("the new user should be able to login to the application")
	public void the_new_user_should_be_able_to_login_to_the_application() {
		loginSteps.loginAsUser(employee.getUser());
	}

	@Then("print all user details using xpath and CSS")
	public void print_all_user_details_using_xpath_and_CSS() {
		int totalRowNum = userManagementSteps.getTotalRows();
		System.out.println(String.format("Total Elements to be identified %d", totalRowNum * 4));
		System.out.println("Elements identified by xpath");
		userManagementSteps.identifyUserDetailsUsingXpath(totalRowNum);
		System.out.println("Elements identified by CSS");
		userManagementSteps.identifyUserDetailsUsingCSS(totalRowNum);
	}

}
