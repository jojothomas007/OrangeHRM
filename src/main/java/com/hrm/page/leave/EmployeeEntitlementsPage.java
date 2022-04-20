package com.hrm.page.leave;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.HashedMap;

import com.hrm.entity.Employee;
import com.hrm.entity.Leave;
import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@At(urls = { "#HOST/index.php/leave/viewLeaveEntitlements.*" })
@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/leave/viewLeaveEntitlements")
public class EmployeeEntitlementsPage extends BasePage {

	@FindBy(id = "entitlements_employee_empName")
	WebElementFacade empName;
	@FindBy(xpath = "//table[@id='resultTable']//td[text()='No Records Found']")
	WebElementFacade noLeaves;
	@FindBy(id = "entitlements_leave_type")
	WebElementFacade leaveType;
	@FindBy(id = "resultTable")
	WebElementFacade resultTable;
	@FindBy(id = "searchBtn")
	WebElementFacade btnSearch;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.LEAVE_EMP_ENTITLEMENTS;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(empName).withTimeoutOf(2, TimeUnit.SECONDS).waitUntilEnabled();
	}

	public Map<String, Leave> getLeaveEntitlements(Employee employee) {
		String empFullname = employee.getFirstName() + " " + employee.getLastName();
		searchAndEnter(empName, empFullname);
		btnSearch.waitUntilClickable().click();
		if (noLeaves.withTimeoutOf(2, TimeUnit.SECONDS).isVisible()) {
			employee.setLeaves(new HashedMap());
			return employee.getLeaves();
		}
		Map<String, Leave> leaveEntitlements = employee.getLeaves();
		ListOfWebElementFacades tableRows = resultTable.thenFindAll("./tbody/tr");
		for (WebElementFacade tableRow : tableRows) {
			String leaveType = tableRow.thenFind("./td[2]").getText();
			Float leaveEntitlementFloat = Float.parseFloat(tableRow.thenFind("./td[6]/a").getText());
			leaveEntitlements.put(leaveType, new Leave(leaveType, leaveEntitlementFloat, null));
		}
		return leaveEntitlements;
	}

}
