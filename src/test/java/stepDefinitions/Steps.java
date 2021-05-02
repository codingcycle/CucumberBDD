package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.ConfigFileReader;
import junit.framework.Assert;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageobjects.ValuesPage;

public class Steps {
	private static WebDriver driver;
	ValuesPage valuesPage;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
	PageObjectManager pageObjectManager = new PageObjectManager(driver);

	@Given("^user launches the browser and opens url$")
	public void user_launches_the_browser_and_opens_url() throws Throwable {
//		configFileReader = new ConfigFileReader();
//		System.setProperty("webdriver.chrome.driver",
//				FileReaderManager.getInstance().getConfigReader().getDriverPath());
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
//				TimeUnit.SECONDS);
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get("https://www.exercise1.com/values ");
	}

	@When("^user is on values page$")
	public void user_is_on_values_page() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "values");
	}

	@Then("^verify the right count of values$")
	public void verify_the_right_count_of_values() throws Throwable {
		PageObjectManager pageObjectManager = new PageObjectManager(driver);
		valuesPage = pageObjectManager.getValuesPage();
		int countOfValues = valuesPage.getCountOfValues();
		Assert.assertEquals(5, countOfValues);
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}

	@Then("^verify the values on the screen are greater than zero$")
	public void verify_the_values_on_the_screen_are_greater_than_zero() throws Throwable {
		valuesPage = pageObjectManager.getValuesPage();
		Assert.assertTrue(valuesPage.veifyThatValuesAreGreaterThanZero());
	}

	@Then("^verify the total balance is correct$")
	public void verify_the_total_balance_is_correct() throws Throwable {
		valuesPage = pageObjectManager.getValuesPage();
		Assert.assertTrue(valuesPage.verifyTheTotalBalance());
	}

	@Then("^verify the values are formatted as currencies$")
	public void verify_the_values_are_formatted_as_currencies() throws Throwable {
		valuesPage = pageObjectManager.getValuesPage();
		Assert.assertTrue(valuesPage.verifyValuesAreForamttedAsCurrencies());
	}
}
