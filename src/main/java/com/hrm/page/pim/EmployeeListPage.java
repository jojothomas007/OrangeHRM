package com.hrm.page.pim;

import java.util.Random;

import com.hrm.entity.Employee;
import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/dashboard")
public class EmployeeListPage extends BasePage {

	@FindBy(id = "empsearch_id")
	WebElementFacade empIdsearch;
	@FindBy(id = "searchBtn")
	WebElementFacade btnsearch;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.PIM_EMP_LIST;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(empIdsearch).waitUntilVisible();
	}

	public void searchEmployeeWithId(Employee employee) {
		empIdsearch.type(employee.getEmpId());
		btnsearch.click();
	}

	public Employee getARandomEmployee(Employee employee) {
		int rowNum = new Random().nextInt(20) + 3;
		WebElementFacade empRow = $("//tr[" + rowNum + "]");
		employee.setEmpId(empRow.thenFind(".//td[2]").getText());
		employee.setFirstName(empRow.thenFind(".//td[3]").getText());
		employee.setLastName(empRow.thenFind(".//td[4]").getText());
		return employee;
	}

}
