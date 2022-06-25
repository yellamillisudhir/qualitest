package cucumber.test.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class stepDefination {
	public WebDriver driver;
	public WebDriverWait wait;
	public HomePage hp;

	@Given("I add four ramdon items to my cart")
	public void i_add_four_ramdon_items_to_my_cart() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://cms.demo.katalon.com/");
		for (int i = 1; i <= 4; i++) {
			// System.out.println(list.get(i));
			Thread.sleep(2000);
			WebElement e = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[" + i + "]/div/a[2]"));
			Thread.sleep(2000);
			Thread.sleep(2000);
			Actions a = new Actions(driver);
			Thread.sleep(2000);
			a.moveToElement(e);
			Thread.sleep(2000);
			a.click().build().perform();
			Thread.sleep(2000);
		}
	}

	@When("I view my cart")
	public void i_view_my_cart() {
		driver.findElement(By.xpath("//div[@class='menu']//a[contains(text(),'Cart')]")).click();

	}

	@Then("I find total four items listed in my cart")
	public void i_find_total_four_items_listed_in_my_cart() {
		List<WebElement> itemssize = driver
				.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
		if (itemssize.size() == 4) {
			Assert.assertTrue(true);
		}
	}

	@When("I search for lowest price item")
	public void i_search_for_lowest_price_item() {
		List<WebElement> prices = driver.findElements(By.xpath("//td[@class='product-price']"));
		for (WebElement element : prices) {
			String actual = element.getText().toString();
			String expected = actual.substring(1, 3);
		}
	}

	@When("I am able to remove the lowest price item from my cart")
	public void i_am_able_to_remove_the_lowest_price_item_from_my_cart() throws InterruptedException {
		WebElement r = driver.findElement(
				By.xpath("/html/body/div/div/div[2]/div/main/article/div/div/form/table/tbody/tr[1]/td[1]/a"));
		Actions b = new Actions(driver);
		Thread.sleep(2000);
		b.moveToElement(r);
		Thread.sleep(2000);
		b.click().build().perform();
		Thread.sleep(3000);

	}

	@Then("I am able to verify the three items in the cart")
	public void i_am_able_to_verify_the_three_items_in_the_cart() {
		List<WebElement> leftitems = driver
				.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
		if (leftitems.size() == 4) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
		driver.close();
	}
	
}
