package com.hrm.page;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com")
public class LoginPage extends PageObject {

	@FindBy(id = "txtUsername")
	WebElementFacade txtUsername;
	@FindBy(id = "txtPassword")
	WebElementFacade txtPassword;
	@FindBy(id = "btnLogin")
	WebElementFacade btnLogin;
	@FindBy(xpath = "//span[@id='spanMessage'][text()='Invalid credentials']")
	WebElementFacade lblLoginErr;

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(txtUsername).waitUntilVisible();
	}

	public void enterLoginCredentials(String username, String password) {
		txtUsername.type(username);
		txtPassword.type(password);
		btnLogin.click();
	}

	public boolean isCredentialError() {
		return lblLoginErr.withTimeoutOf(2, TimeUnit.SECONDS).isVisible();
	}

}
