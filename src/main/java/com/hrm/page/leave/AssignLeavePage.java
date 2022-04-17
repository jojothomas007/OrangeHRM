package com.hrm.page.leave;

import com.hrm.entity.Employee;
import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;
import com.hrm.utils.CommonUtils;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/leave/addLeaveEntitlement")
public class AssignLeavePage extends BasePage {

	@FindBy(id = "assignleave_txtEmployee_empName")
	WebElementFacade empName;
	@FindBy(id = "assignleave_txtLeaveType")
	WebElementFacade leaveType;
	@FindBy(id = "assignleave_txtFromDate")
	WebElementFacade fromDate;
	@FindBy(id = "assignleave_txtToDate")
	WebElementFacade toDate;
	@FindBy(id = "assignBtn")
	WebElementFacade btnAssign;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.LEAVE_ASSIGN;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(empName).waitUntilVisible();
		waitABit(2000);
	}

	public void assignRandomLeaves(Employee employee, String strleaveType, Integer numleaves) {
		String empFullname = employee.getFirstName() + " " + employee.getLastName();
		searchAndEnter(empName, empFullname);
		leaveType.selectByVisibleText(strleaveType);
//		click calendar element
		fromDate.click();
		waitABit(500);
		WebElementFacade calendar = $("//div[@id='ui-datepicker-div']");
//		select random month
		calendar.thenFind(".//select[@class='ui-datepicker-month']").selectByIndex(CommonUtils.getRandomInteger(12));
		waitABit(500);
		// select random from date and to date value
		int fromDayIndex = CommonUtils.getRandomInteger(10) + 1;
		String strFromDate = calendar.thenFind("(.//td[@class=' '])[" + fromDayIndex + "]").getText();
		int toDayIndex = fromDayIndex + numleaves - 1;
		String strToDate = calendar.thenFind("(.//td[@class=' '])[" + toDayIndex + "]").getText();
		calendar.thenFind(".//td[.='" + strFromDate + "']").click();
//		click calendar element
		toDate.click();
		waitABit(500);
		calendar = $("//div[@id='ui-datepicker-div']");
		calendar.thenFind(".//td[.='" + strToDate + "']").click();
		btnAssign.click();
		waitABit(2000);
	}

}
