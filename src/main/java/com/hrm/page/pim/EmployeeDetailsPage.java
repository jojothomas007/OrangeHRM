package com.hrm.page.pim;

import java.util.concurrent.TimeUnit;

import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/dashboard")
public class EmployeeDetailsPage extends BasePage {

	@FindBy(id = "personal_txtEmpFirstName")
	WebElementFacade firstName;

	@Override
	protected MenuItems getPageMenu() {
//		Cannot navigate to this page from menu
		return null;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(firstName).withTimeoutOf(5, TimeUnit.SECONDS).waitUntilVisible();
	}

}
