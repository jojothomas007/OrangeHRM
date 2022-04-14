package starter.stepdefinitions.leave;

import java.util.Random;

import com.hrm.entity.Employee;
import com.hrm.steps.leave.ConfigureLeaveSteps;
import com.hrm.steps.leave.LeaveEntitlementSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EntitlementsStepDefinitions {
	@Steps
	LeaveEntitlementSteps leaveEntitlementSteps;
	@Steps
	ConfigureLeaveSteps configureLeaveSteps;
	@Steps(shared = true)
	Employee employee;

	@When("the admin user add new leave entitlement")
	public void the_admin_user_add_new_leave_entitlement() {
		String leaveType = configureLeaveSteps.getRandomLeaveType();
		int leaveAddition = new Random().nextInt(5);
		leaveEntitlementSteps.addEntitlement(employee, leaveType, leaveAddition);
	}

	@Then("the employee entitlement must get listed correctly")
	public void the_employee_entitlement_must_get_listed_correctly() {
		leaveEntitlementSteps.verifyEmployeeLeaveEntitlement(employee);
	}

	@Given("the admin user fetch current leave entitlement")
	public void the_admin_user_fetch_current_leave_entitlement() {
		leaveEntitlementSteps.fetchTheEmployeeLeaveEntitlement(employee);
	}

}
