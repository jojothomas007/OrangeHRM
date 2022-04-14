package starter.stepdefinitions.leave;

import java.util.Random;

import com.hrm.entity.Employee;
import com.hrm.entity.LeaveEntitlement;
import com.hrm.steps.leave.AssignLeaveSteps;
import com.hrm.steps.leave.LeaveEntitlementSteps;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AssignLeaveStepDefinitions {
	@Steps
	AssignLeaveSteps assignLeaveSteps;
	@Steps
	LeaveEntitlementSteps leaveEntitlementSteps;
	@Steps(shared = true)
	Employee employee;
	String[] saa = new String[2];

	@When("the admin user assign leave to a user")
	public void the_admin_user_assign_leave_to_a_user() {
		LeaveEntitlement aLeaveEntitlement = leaveEntitlementSteps.getRandomLeaveEntitlement(employee);
		int intLeaveBalance = Math.round(aLeaveEntitlement.getBalance());
		int numLeaves = new Random().nextInt(intLeaveBalance) + 1;
		assignLeaveSteps.assignLeaves(employee, aLeaveEntitlement.getType(), numLeaves);
	}

}
