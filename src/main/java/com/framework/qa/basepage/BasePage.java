package com.framework.qa.basepage;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.framework.qa.baseTest.BaseTest;

public class BasePage extends BaseTest {
	final static Logger logger = Logger.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitUntilElementDisplayed(final WebElement webElement) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return true;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisplayed);
	}

	public boolean waitForElementTobeClickable(WebElement element, long timeOut) {

		WebElement isElementClickable = null;

		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			isElementClickable = wait.until(ExpectedConditions.elementToBeClickable(element));
			logger.error("element present");
		} catch (Exception e) {
			logger.error(" Exception in the wait for 10 seconds for the  Element To Appear" + e);
		}

		return isElementClickable.isDisplayed();
	}

	public void isDisplayed(WebElement locator, String message) {
		try {
			if (locator != null) {
				waitUntilElementDisplayed(locator);
				if (locator.isDisplayed()) {
					logger.info(message + " is Displayed");
				} else {
					logger.error(message + " is Not Displayed");
				}
			}

			else {
				logger.info("Locator is Null");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	public void isDisplayedThenClick(WebElement locator, String message) {
		try {
			waitForElementTobeClickable(locator, 5);
			if (locator.isDisplayed()) {
				locator.click();
				logger.info(message + " id Displayed and Clicked on it.");
			} else {
				logger.error(message + " is Not Displayed");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	public void isDisplayedThenEnterText(WebElement locator, String message, String sendText) {
		try {
			waitUntilElementDisplayed(locator);
			System.out.println("element present ----- ");
			isDisplayed(locator, message);
			locator.click();
			locator.sendKeys(sendText);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	public void scrollDownPage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,390)", "");
	}

	public String getText(WebElement locator) {
		try {
			String text = "";

			if (locator.isDisplayed()) {
				waitUntilElementDisplayed(locator);
				text = locator.getText().trim();
			}
			return text;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
	}

	public void waitForPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	public void verifyPageTitle(String title) {
		waitForPageLoad(driver);
		String pageTitle = driver.getTitle();
		if (pageTitle.equals(title)) {
			logger.info("Expected Title is displayed");
		} else {
			logger.error("Expected title Page is not displayed");
		}
	}

	public void MouseHover(WebElement locator) {
		try {

			System.out.print("Mouse Hover Action");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(locator));
			Actions act = new Actions(driver);
			act.moveToElement(locator).build().perform();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
