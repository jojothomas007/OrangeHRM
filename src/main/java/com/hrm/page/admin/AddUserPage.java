package com.hrm.page.admin;

import com.hrm.entity.Employee;
import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser")
public class AddUserPage extends BasePage {

	@FindBy(id = "systemUser_employeeName_empName")
	WebElementFacade empName;
	@FindBy(id = "systemUser_userType")
	WebElementFacade userRole;
	@FindBy(id = "systemUser_userName")
	WebElementFacade userName;
	@FindBy(id = "systemUser_password")
	WebElementFacade password;
	@FindBy(id = "systemUser_confirmPassword")
	WebElementFacade confirmPassword;
	@FindBy(id = "btnSave")
	WebElementFacade btnSave;

	@Override
	protected MenuItems getPageMenu() {
		// cannot navigate to this page from menu
		return null;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(empName).waitUntilVisible();
	}

	public void enterUserDetails(Employee employee) {
		userRole.selectByVisibleText(employee.getUser().getUserRole().toString());
		empName.type(employee.getFirstName() + employee.getLastName());
		userName.type(employee.getUser().getUsername());
		password.type(employee.getUser().getPassword());
		confirmPassword.type(employee.getUser().getPassword());
		btnSave.click();
	}

}
