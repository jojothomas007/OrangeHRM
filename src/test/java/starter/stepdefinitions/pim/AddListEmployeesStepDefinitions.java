package starter.stepdefinitions.pim;

import com.hrm.datagen.EmployeeDatagen;
import com.hrm.entity.Employee;
import com.hrm.steps.LoginSteps;
import com.hrm.steps.pim.AddListEmployeeSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class AddListEmployeesStepDefinitions {
	@Steps
	LoginSteps loginSteps;
	@Steps
	AddListEmployeeSteps addListEmployeeSteps;
	@Steps(shared = true)
	Employee employee;

	@Given("the user adds a new employee with user role")
	public void the_user_adds_a_new_employee_with_user_role() {
		new EmployeeDatagen().createEmployeeWithUser(employee);
		addListEmployeeSteps.addNewEmployee(employee);
	}

	@Given("the user adds a new employee without user role")
	public void the_user_adds_a_new_employee_without_user_role() {
		new EmployeeDatagen().createEmployeeWithoutUser(employee);
		addListEmployeeSteps.addNewEmployee(employee);
	}

	@Then("the employee must get listed correctly")
	public void the_employee_must_get_listed_correctly() {
		addListEmployeeSteps.searchForEmployee(employee);
	}

	@Given("the admin user finds an active employee")
	public void the_admin_user_finds_an_active_employee() {
		addListEmployeeSteps.getARandomEmployee(employee);
		addListEmployeeSteps.postInformationInReport("Employee selected as",
				employee.getFirstName() + " " + employee.getLastName());
	}

}
