package com.hrm.page.leave;

import java.util.concurrent.TimeUnit;

import com.hrm.entity.Employee;
import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/leave/addLeaveEntitlement")
public class AssignLeavePage extends BasePage {

	@FindBy(id = "entitlements_employee_empName")
	WebElementFacade empName;
	@FindBy(id = "entitlements_leave_type")
	WebElementFacade leaveType;
	@FindBy(id = "entitlements_entitlement")
	WebElementFacade entitlement;
	@FindBy(id = "btnSave")
	WebElementFacade btnSave;
	@FindBy(id = "dialogUpdateEntitlementConfirmBtn")
	WebElementFacade btnConfirmBtn;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.LEAVE_ADD_ENTITLEMENTS;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(empName).waitUntilVisible();
		waitABit(2000);
	}

	public void assignLeaves(Employee employee, String strleaveType, Integer numleaves) {
		String empFullname = employee.getFirstName() + " " + employee.getLastName();
		searchAndEnter(empName, empFullname);
		leaveType.selectByVisibleText(strleaveType);
		entitlement.type(numleaves.toString());
		btnSave.click();
		if (true == btnConfirmBtn.withTimeoutOf(2, TimeUnit.SECONDS).isVisible()) {
			btnConfirmBtn.click();
		}
	}

}
