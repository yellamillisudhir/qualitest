package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="(//button[@type='submit'])[2]")
	public WebElement insideCart;
	@FindBy(xpath ="//div[@class='menu']//a[contains(text(),'Cart')]")
	public WebElement clickCart;
	@FindBy(xpath ="/html/body/div/div/div[2]/div/main/article/div/div/form/table/tbody/tr[1]/td[1]/a")
	public WebElement removeitemfromcart;
	@FindAll(@FindBy(xpath="//tr[@class='woocommerce-cart-form__cart-item cart_item']"))
	public List<WebElement> total_itemsaddedtocat;
	@FindAll(@FindBy(xpath="//tr[@class='woocommerce-cart-form__cart-item cart_item']"))
	public List<WebElement> total_itemslefttocat;
	
	
	
	public void submitcart()
	{
		insideCart.click();
	}
	public void clickoncart()
	{
		clickCart.click();
	}
	public void launchURL() {
		driver.get("https://cms.demo.katalon.com/");
	}
	public void itemSelect() throws InterruptedException {
		for (int i = 1; i <= 4; i++) {
			// System.out.println(list.get(i));
			//Thread.sleep(2000);
			WebElement e = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[" + i + "]/div/a[2]"));
			Thread.sleep(2000);
			selectActions(e);
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	public void viewitemsincart() {
	    int itemstobevisible =4;
		for(int i=1; i<=total_itemsaddedtocat.size();i++) {
		if(total_itemsaddedtocat.equals(itemstobevisible)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
		}
	}
	public void removeItem() throws InterruptedException
	{
		removeitemfromcart.click();
		Thread.sleep(2000);
		selectActions(removeitemfromcart);
	}
	public void selectActions(WebElement element) throws InterruptedException {
		
		Actions b = new Actions(driver);
		Thread.sleep(1000);
		b.moveToElement(element);
		Thread.sleep(1000);
		b.click().build().perform();
		Thread.sleep(2000);
		
	}
	@SuppressWarnings("unlikely-arg-type")
	public void leftitemsincart() {
	    int itemstobevisible =3;
		for(int i=1; i<=total_itemsaddedtocat.size();i++) {
		if(total_itemsaddedtocat.equals(itemstobevisible)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
		}
	}
}
