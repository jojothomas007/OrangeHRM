package com.hrm.steps;

import com.hrm.entity.Employee;
import com.hrm.page.admin.AddUserPage;
import com.hrm.page.admin.SystemUsersPage;
import com.hrm.page.pim.EmployeeListPage;

import net.thucydides.core.annotations.Step;

public class DashboardSteps extends BaseSteps {
	SystemUsersPage systemUsersPage;
	AddUserPage addUserPage;
	EmployeeListPage employeeListPage;

	@Step
	public void addNewUser(Employee employee) {
		systemUsersPage.navigateToPage();
		systemUsersPage.addUser();
		addUserPage.enterUserDetails(employee);
	}

}
