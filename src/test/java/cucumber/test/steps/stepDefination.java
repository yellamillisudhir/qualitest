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
	public HomePage homepage;

	@Given("I add four ramdon items to my cart")
	public void i_add_four_ramdon_items_to_my_cart() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		homepage = new HomePage(driver);
		homepage.launchURL();
		homepage.itemSelect();
	}

	@When("I view my cart")
	public void i_view_my_cart() {
		homepage.clickoncart();
	}

	@Then("I find total four items listed in my cart")
	public void i_find_total_four_items_listed_in_my_cart() {
		homepage.viewitemsincart();
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
		homepage.removeItem();
	}

	@Then("I am able to verify the three items in the cart")
	public void i_am_able_to_verify_the_three_items_in_the_cart() {
		homepage.leftitemsincart();
		// driver.close();
	}

}
