package com.hrm.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/dashboard")
public class HomePage extends PageObject {

	@FindBy(id = "div_graph_display_emp_distribution")
	WebElementFacade graph;

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		element(graph).waitUntilVisible();
	}
}
