package com.hrm.steps.admin;

import com.hrm.entity.Employee;
import com.hrm.page.admin.AddUserPage;
import com.hrm.page.admin.SystemUsersPage;
import com.hrm.page.pim.EmployeeListPage;
import com.hrm.steps.BaseSteps;

import net.thucydides.core.annotations.Step;

public class UserManagementSteps extends BaseSteps {
	SystemUsersPage systemUsersPage;
	AddUserPage addUserPage;
	EmployeeListPage employeeListPage;

	@Step
	public void addNewUser(Employee employee) {
		systemUsersPage.navigateToPage();
		systemUsersPage.addUser();
		addUserPage.enterUserDetails(employee);
	}

	public int getTotalRows() {
		systemUsersPage.navigateToPage();
		int totalRowNum = systemUsersPage.getTotalRows();
		return totalRowNum;
	}

	@Step
	public void identifyUserDetailsUsingCSS(int totalRowNum) {
		systemUsersPage.printUserDetailsUsingCSS(totalRowNum);
	}

	@Step
	public void identifyUserDetailsUsingXpath(int totalRowNum) {
		systemUsersPage.printUserDetailsUsingXpath(totalRowNum);
	}
}
