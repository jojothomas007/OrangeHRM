package starter.stepdefinitions.leave;

import java.util.Random;

import com.hrm.entity.Employee;
import com.hrm.entity.Leave;
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

	@When("the admin user assign leave to the employee")
	public void the_admin_user_assign_leave_to_the_employee() {
		Leave leave = leaveEntitlementSteps.getLeaveWithNonZeroBalanceForTheEmployee(employee);
		int intLeaveBalance = Math.round(leave.getEntitlement());
		int numLeaves = new Random().nextInt(intLeaveBalance) + 1;
		assignLeaveSteps.assignLeaves(employee, leave.getType(), numLeaves);
	}

}
