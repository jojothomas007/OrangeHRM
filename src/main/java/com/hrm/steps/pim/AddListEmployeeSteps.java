package com.hrm.steps.pim;

import com.hrm.entity.Employee;
import com.hrm.page.pim.AddEmployeePage;
import com.hrm.page.pim.EmployeeListPage;
import com.hrm.steps.BaseSteps;

import net.thucydides.core.annotations.Step;

public class AddListEmployeeSteps extends BaseSteps {
	AddEmployeePage addEmployeePage;
	EmployeeListPage employeeListPage;

	@Step
	public void addNewEmployee(Employee employee) {
		addEmployeePage.navigateToPage();
		if (employee.getUser() == null) {
			addEmployeePage.addNewEmployeeWithoutLoginDetails(employee);
		} else {
			addEmployeePage.addNewEmployeeWithLoginDetails(employee);
		}
	}

	@Step
	public void searchForEmployee(Employee employee) {
		employeeListPage.navigateToPage();
		employeeListPage.searchEmployeeWithId(employee);
	}

	@Step
	public Employee getARandomEmployee(Employee employee) {
		employeeListPage.navigateToPage();
		employeeListPage.getARandomEmployee(employee);
		return employee;
	}
}
