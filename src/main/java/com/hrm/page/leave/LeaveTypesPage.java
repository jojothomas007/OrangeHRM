package com.hrm.page.leave;

import java.util.List;

import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/leave/addLeaveEntitlement")
public class LeaveTypesPage extends BasePage {

	@FindBy(id = "resultTable")
	WebElementFacade tblLeaveTypes;
	@FindBy(id = "btnAdd")
	WebElementFacade btnAdd;
	@FindBy(id = "btnDelete")
	WebElementFacade btnDelete;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.LEAVE_TYPES;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(btnAdd).waitUntilVisible();
	}

	public final List<String> getLeaveTypes() {
		List<String> leaveTypes = tblLeaveTypes.thenFindAll(".//a").texts();
		return leaveTypes;
	}

}
