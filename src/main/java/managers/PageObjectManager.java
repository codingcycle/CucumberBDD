package managers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjects.ValuesPage;

public class PageObjectManager {
	private WebDriver driver;
	private ValuesPage valuesPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public ValuesPage getValuesPage() {
		return (valuesPage == null) ? valuesPage = new ValuesPage(driver) : valuesPage;
	}

}
