package com.hrm.page.leave;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.hrm.entity.Employee;
import com.hrm.entity.Leave;
import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/leave/viewLeaveBalanceReport")
public class LeaveReportPage extends BasePage {

	@FindBy(id = "leave_balance_report_type")
	WebElementFacade generateFor;
	@FindBy(id = "leave_balance_employee_empName")
	WebElementFacade empName;
	@FindBy(id = "viewBtn")
	WebElementFacade viewBtn;
	@FindBy(css = "table.table.nosort")
	WebElementFacade resultTable;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.LEAVE_REPORT;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(generateFor).withTimeoutOf(2, TimeUnit.SECONDS).waitUntilVisible();
	}

	public void fetchReportForEmployee(Employee employee) {
		generateFor.waitUntilEnabled().selectByVisibleText("Employee");
		String empFullname = employee.getFirstName() + " " + employee.getLastName();
		searchAndEnter(empName, empFullname);
		viewBtn.click();
		resultTable.withTimeoutOf(2, TimeUnit.SECONDS).shouldBeVisible();
		ListOfWebElementFacades rowList = resultTable.thenFindAll(".//tbody/tr");
		Map<String, Leave> leaves = employee.getLeaves();
		leaves.clear();
		for (WebElementFacade row : rowList) {
			String leaveType = row.thenFind("./td[1]").getText();
			Float entitlement = Float.parseFloat(row.thenFind("./td[2]").getText());
			Float balance = Float.parseFloat(row.thenFind("./td[6]").getText());
			Leave leave = new Leave(leaveType, entitlement, balance);
			leaves.put(leaveType, leave);
		}
	}

}
