package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="(//button[@type='submit'])[2]")
	public WebElement insideCart;
	@FindBy(xpath ="//div[@class='menu']//a[contains(text(),'Cart')]")
	public WebElement clickCart;
	
	
	public void submitcart()
	{
		insideCart.click();
	}
	public void cartoncart()
	{
		clickCart.click();
	}
}
