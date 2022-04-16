package com.hrm.page.admin;

import org.openqa.selenium.By;

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

	public int getTotalRows() {
		int totalRowNum = getDriver().findElements(By.cssSelector("#resultTable > tbody > tr")).size();
		return totalRowNum;
	}

	public void printUserDetailsUsingCSS(int totalRowNum) {
		for (int rowIndex = 1; rowIndex <= totalRowNum; rowIndex++) {
			for (int colIndex = 1; colIndex < 4; colIndex++) {
				System.out.println(getDriver().findElement(By.cssSelector(
						"#resultTable > tbody > tr:nth-child(" + rowIndex + ") > td:nth-child(" + colIndex + ")"))
						.getText());
			}
		}
	}

	public void printUserDetailsUsingXpath(int totalRowNum) {
		for (int rowIndex = 1; rowIndex <= totalRowNum; rowIndex++) {
			for (int colIndex = 1; colIndex < 4; colIndex++) {
				System.out.println(getDriver()
						.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"))
						.getText());
			}
		}
	}

}
