package com.framework.qa.baseTest;

import java.io.File;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.framework.qa.utils.Constants;
import com.framework.qa.utils.DriverFactory;
import com.framework.qa.utils.PropUtils;

public class BaseTest {
	public WebDriver driver;
	public static File configFile = PropUtils.getPropFile(Constants.CONFIG_DIR, Constants.CONFIG_FILE_NAME);
	public static Properties configProp = PropUtils.getProps(configFile);
	public DriverFactory driverFactory;

	@BeforeTest(alwaysRun = true)
	public void initializeDriver() {

		driverFactory = new DriverFactory();
		driver = driverFactory.initialiseDriver("chrome");
		driver.get(PropUtils.getPropValue(configProp, "applicationURL"));
	}

	@AfterTest(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
