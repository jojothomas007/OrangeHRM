package com.hrm.page.admin;

import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser")
public class SystemUsersPage extends BasePage {

	@FindBy(id = "btnAdd")
	WebElementFacade btnAdd;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.ADMIN_USERS;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(btnAdd).waitUntilVisible();
	}

	public void addUser() {
		btnAdd.click();
	}

}
