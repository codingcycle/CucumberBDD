package pageobjects;

import java.util.Currency;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ValuesPage {
	private WebDriver driver;

	public ValuesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "lbl_val_1")
	private WebElement labelVal1;
	@FindBy(how = How.ID, using = "lbl_val_2")
	private WebElement labelVal2;
	@FindBy(how = How.ID, using = "lbl_val_3")
	private WebElement labelVal3;
	@FindBy(how = How.ID, using = "lbl_val_4")
	private WebElement labelVal4;
	@FindBy(how = How.ID, using = "lbl_val_5")
	private WebElement labelVal5;
	@FindBy(how = How.ID, using = "lbl_ttl_val")
	private WebElement labelTotalVal;
	@FindBy(how = How.ID, using = "txt_val_1")
	private WebElement TextVal1;
	@FindBy(how = How.ID, using = "txt_val_2")
	private WebElement TextVal2;
	@FindBy(how = How.ID, using = "txt_val_4")
	private WebElement TextVal4;
	@FindBy(how = How.ID, using = "txt_val_5")
	private WebElement TextVal5;
	@FindBy(how = How.ID, using = "txt_val_6")
	private WebElement TextVal6;
	@FindBy(how = How.ID, using = "txt_ttl_val")
	private WebElement TextTotalVal;

	public int getCountOfValues() {
		List<WebElement> findElements = driver.findElements(By.cssSelector("ID"));
		int size = findElements.size();
		return size;
	}

	public boolean veifyThatValuesAreGreaterThanZero() {
		List<WebElement> textValues = driver.findElements(By.xpath("//*[contains(@id,'txt_val')"));
		for (int i = 0; i < textValues.size(); i++) {
			String attribute = textValues.get(i).getAttribute("value");
			if (attribute.indexOf(i) == 0)
				return false;
		}
		return true;
	}

	public boolean verifyTheTotalBalance() {
		List<WebElement> textValAmount = driver.findElements(By.xpath("//*[contains(@id,'txt_val')"));
		int sum = 0;
		for (int i = 0; i < textValAmount.size(); i++) {
			String attribute = textValAmount.get(i).getAttribute("value");
			int parseInt = Integer.parseInt(attribute);
			sum = sum + parseInt;
		}
		String totalBal = TextTotalVal.getText();
		int parseIntTotal = Integer.parseInt(totalBal);
		if (parseIntTotal == sum)
			return true;
		else
			return false;
	}

	public boolean verifyValuesAreForamttedAsCurrencies() {
		List<WebElement> findElements = driver.findElements(By.xpath("//*[contains(@id,'txt_val')"));
		for (int i = 0; i < findElements.size(); i++) {
			String text = findElements.get(i).getText();
			Currency currency = Currency.getInstance("USD");
			String symbol = currency.getSymbol();
			if (!(text.contains(symbol)))
				return false;
		}
		return true;
	}
}
