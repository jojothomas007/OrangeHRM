package com.hrm.page.admin;

import com.hrm.enums.MenuItems;
import com.hrm.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/admin/localization")
public class LocalizationPage extends BasePage {

	@FindBy(id = "localization_dafault_language")
	WebElementFacade language;
	@FindBy(id = "localization_use_browser_language")
	WebElementFacade chkLocalization;
	@FindBy(id = "btnSave")
	WebElementFacade btnSave;

	@Override
	protected MenuItems getPageMenu() {
		return MenuItems.ADMIN_LOCALIZATION;
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(btnSave).waitUntilVisible();
	}

	public void setDefaultLanguage() {
		String selectedLanguage = language.getSelectedValue();
		if (!selectedLanguage.equals("en_US")) {
			btnSave.click();
//			chkLocalization.click();
			language.selectByValue("en_US");
			btnSave.click();
		}
	}

}
