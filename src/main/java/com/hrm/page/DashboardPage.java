package com.hrm.page;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.InvalidArgumentException;

import com.hrm.enums.MenuItems;
import com.hrm.enums.UserRole;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@At(urls = { "#HOST/index.php/dashboard" })
@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/dashboard")
public class DashboardPage extends BasePage {

	@FindBy(xpath = "//table[@class='quickLaungeContainer']//a/span[text()='My Leave']")
	WebElementFacade myLeaveQLaunch;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.DASHBOARD;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(myLeaveQLaunch).withTimeoutOf(5, TimeUnit.SECONDS).waitUntilVisible();
	}

	public void checkForMenusDisplayed(UserRole userRole) {
		List<String> mainMenus = null;
		switch (userRole) {
		case Admin:
			mainMenus = new ArrayList<>();
			mainMenus.addAll(MenuItems.getMainMenuSet());
			break;
		case ESS:
			mainMenus = Arrays.asList("Leave", "Time", "My Info", "Performance", "Dashboard", "Directory", "Buzz");
			break;
		default:
			throw new InvalidArgumentException(userRole.toString());
		}
		ListOfWebElementFacades webElementFacades = findAll(
				"//div[@id='mainMenu']//li[contains(@class,'main-menu-first-level-list-item')]/a/b");
		List<String> displayedMainMenus = webElementFacades.texts();
		assertThat(displayedMainMenus).as("Displayed Main menu").hasSameElementsAs(mainMenus);

	}

}
