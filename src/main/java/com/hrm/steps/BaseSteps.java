package com.hrm.steps;

import java.security.InvalidParameterException;

import com.hrm.enums.UserRole;
import com.hrm.page.HomePage;
import com.hrm.page.LoginPage;
import com.hrm.utils.ConfigUtils;

public class BaseSteps {
	LoginPage loginPage;
	HomePage homePage;

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
		if (loginPage.isCredentialError()) {
			loginAsUser(UserRole.Admin);
		}
		homePage.shouldBeDisplayed();
	}

	public void openLoginPage() {
		loginPage.open();
	}

	public void checkMenusInHomePage(UserRole userRole) {
		homePage.checkForMenusDisplayed(userRole);
	}

}
