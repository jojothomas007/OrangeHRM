package com.hrm.page.pim;

import java.util.concurrent.TimeUnit;

import com.hrm.entity.Employee;
import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/dashboard")
public class AddEmployeePage extends BasePage {

	@FindBy(id = "firstName")
	WebElementFacade firstName;
	@FindBy(id = "lastName")
	WebElementFacade lastName;
	@FindBy(id = "employeeId")
	WebElementFacade employeeId;
	@FindBy(id = "chkLogin")
	WebElementFacade chkLogin;
	@FindBy(id = "user_name")
	WebElementFacade username;
	@FindBy(id = "user_password")
	WebElementFacade userpassword;
	@FindBy(id = "re_password")
	WebElementFacade repassword;
	@FindBy(id = "btnSave")
	WebElementFacade btnSave;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.PIM_ADD_EMP;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(firstName).waitUntilVisible();
	}

	public void addNewEmployeeWithLoginDetails(Employee employee) {
		firstName.type(employee.getFirstName());
		lastName.type(employee.getLastName());
		employee.setEmpId(employeeId.getValue());
		chkLogin.click();
		username.withTimeoutOf(2, TimeUnit.SECONDS).type(employee.getUser().getUsername());
		userpassword.type(employee.getUser().getPassword());
		repassword.type(employee.getUser().getPassword());
		btnSave.click();
	}
}
