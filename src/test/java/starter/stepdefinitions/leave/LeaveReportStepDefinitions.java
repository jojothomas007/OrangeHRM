package starter.stepdefinitions.leave;

import com.hrm.entity.Employee;
import com.hrm.steps.leave.LeaveReportSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class LeaveReportStepDefinitions {
	@Steps
	LeaveReportSteps leaveReportSteps;
	@Steps(shared = true)
	Employee employee;

	@Given("the admin user fetch current leave information")
	public void the_admin_user_fetch_current_leave_information() {
		leaveReportSteps.fetchReportForEmployee(employee);
	}

	@Then("the employee leave balance must get updated correctly")
	public void the_employee_leave_balance_must_get_updated_correctly() {
		leaveReportSteps.verifyEmployeeLeaveReport(employee);
	}

}
