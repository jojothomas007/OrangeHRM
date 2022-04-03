package com.hrm.steps.pim;

import com.hrm.entity.Employee;
import com.hrm.page.pim.AddEmployeePage;
import com.hrm.page.pim.EmployeeListPage;

public class AddListEmployeeSteps {
	AddEmployeePage addEmployeePage;
	EmployeeListPage employeeListPage;

	public void createNewEssUser(Employee employee) {
		addEmployeePage.navigateToPage();
		addEmployeePage.addNewEmployeeWithLoginDetails(employee);
	}

	public void searchForEmployee(Employee employee) {
		employeeListPage.navigateToPage();
		employeeListPage.searchEmployeeWithId(employee);
	}

}
