package com.hrm.steps;

import java.security.InvalidParameterException;

import com.hrm.datagen.EmployeeDatagen;
import com.hrm.entity.Employee;
import com.hrm.entity.User;
import com.hrm.enums.UserRole;
import com.hrm.page.DashboardPage;
import com.hrm.page.LoginPage;
import com.hrm.page.admin.LocalizationPage;
import com.hrm.page.pim.AddEmployeePage;
import com.hrm.utils.ConfigUtils;

import net.thucydides.core.annotations.Step;

public class LoginSteps {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AddEmployeePage addEmployeePage;
	LocalizationPage localizationPage;

	@Step
	public void loginAsUser(UserRole userRole) {
		String username = "", password = "";
		switch (userRole) {
		case Admin:
			username = ConfigUtils.getAdminUsername();
			password = ConfigUtils.getAdminUserPassword();
			break;
		case ESS:
			username = ConfigUtils.getEssUsername();
			password = ConfigUtils.getEssUserPassword();
			break;
		default:
			throw new InvalidParameterException();
		}
		loginPage.enterLoginCredentials(username, password);
		if (userRole == UserRole.ESS && loginPage.isCredentialError()) {
			loginAsUser(UserRole.Admin);
			addEmployeePage.navigateToPage();
			Employee employee = new EmployeeDatagen().createEmployeeWithUser(new Employee());
			employee.getUser().setUsername(username);
			employee.getUser().setPassword(password);
			addEmployeePage.addNewEmployeeWithLoginDetails(employee);
			addEmployeePage.logout();
			loginPage.enterLoginCredentials(username, password);
		}
		dashboardPage.shouldBeDisplayed();
		localizationPage.open();
		localizationPage.setDefaultLanguage();
	}

	@Step
	public void loginAsUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		loginPage.enterLoginCredentials(username, password);
		dashboardPage.shouldBeDisplayed();
		localizationPage.open();
		localizationPage.setDefaultLanguage();
	}

	@Step
	public void openLoginPage() {
		loginPage.open();
		loginPage.shouldBeDisplayed();
	}

	@Step
	public void checkMenusInHomePage(UserRole userRole) {
		dashboardPage.checkForMenusDisplayed(userRole);
	}

	@Step
	public void loginPageShoudBeDisplayed() {
		loginPage.shouldBeDisplayed();
	}

}
