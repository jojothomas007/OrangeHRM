package com.hrm.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import com.hrm.enums.MenuItems;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/dashboard")
public abstract class BasePage extends PageObject {
	@FindBy(id = "welcome")
	WebElementFacade userWelcome;
	@FindBy(xpath = "//div[@id='welcome-menu']//a[text()='Logout']")
	WebElementFacade logout;

	MenuItems menuItems = null;

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element("//div[@id='mainMenu']//li[contains(@class,'first-level')]/a[.='Leave']").waitUntilVisible();
	}

	public BasePage navigateToPage() {
		/*
		 * waiting a bit to wait for 1 second before selecting menu usually this kind of
		 * explicit waiting is not advised. Keeping this to showcase for the assignment.
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setPageMenu();
		String menuXpath = "//div[@id='mainMenu']//li[contains(@class,'first-level')]/a[.='" + menuItems.getMainMenu()
				+ "']";
		element(menuXpath).click();
		String getSecondLvlMenuXpath = menuXpath + "/..//li/a[.='" + menuItems.getSecondLvlMenu() + "']";
		element(getSecondLvlMenuXpath).withTimeoutOf(10, TimeUnit.SECONDS).waitUntilClickable().click();
		if (!menuItems.getThirdLvlMenu().equals("")) {
			String getThirdLvlMenuXpath = getSecondLvlMenuXpath + "/..//li/a[.='" + menuItems.getThirdLvlMenu() + "']";
			element(getThirdLvlMenuXpath).waitUntilClickable().click();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public void logout() {
		userWelcome.click();
		logout.withTimeoutOf(1, TimeUnit.SECONDS).waitUntilClickable().click();

	}

	private void setPageMenu() {
		menuItems = getPageMenu();
	}

	protected abstract MenuItems getPageMenu();

	public WebElementFacade searchAndEnter(final WebElementFacade element, String value) {
		element.waitUntilEnabled().clear();
		element.sendKeys(value);
		getClock().pauseFor(1000);
		element.sendKeys(Keys.ENTER);
		return element;
	}
}
