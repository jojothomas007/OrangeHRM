package com.hrm.control;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class TxtSearchBox extends WebElementFacadeImpl implements WebElementFacade {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebElementFacadeImpl.class);
	private final EnvironmentVariables environmentVariables;

	public TxtSearchBox(final WebDriver driver, final ElementLocator locator, final WebElement webElement,
			final long implicitTimeoutInMilliseconds) {
		super(driver, locator, webElement, implicitTimeoutInMilliseconds, implicitTimeoutInMilliseconds);
		this.environmentVariables = Injectors.getInjector().getProvider(EnvironmentVariables.class).get();
	}

	private void logIfVerbose(String logMessage) {
		if (useVerboseLogging()) {
			LOGGER.debug(logMessage + " : " + toString());
		}
	}

	private boolean useVerboseLogging() {
		return ThucydidesSystemProperty.THUCYDIDES_VERBOSE_STEPS.booleanFrom(environmentVariables);
	}

	/**
	 * Type a value into a field and then press Enter, making sure that the field is
	 * empty first.
	 *
	 * @param value
	 */
	@Override
	public WebElementFacade typeAndEnter(final String value) {
		logIfVerbose("Type and enter '" + value + "'");
		System.out.println("********************************************");
		if (driverIsDisabled()) {
			return this;
		}

		clear();
		getElement().sendKeys(value);
		getClock().pauseFor(1000);
		getElement().sendKeys(Keys.ENTER);
		shouldContainText(value);
		notifyScreenChange();
		return this;
	}
}
