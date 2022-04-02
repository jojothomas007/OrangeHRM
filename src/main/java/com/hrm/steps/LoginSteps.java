package com.hrm.steps;

import com.hrm.page.LoginPage;
import com.hrm.utils.configUtils;

public class LoginSteps {
	LoginPage loginPage;

	public void enterValidCredentials() {
		loginPage.enterLoginCredentials(configUtils.getUsername(), configUtils.getUserPassword());
	}

	public void openApplication() {
		loginPage.open();

	}
}
