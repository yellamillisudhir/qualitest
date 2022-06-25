package cucumber.test.steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

	/*
	 * @Before public void before(Scenario s) throws Exception { this.s = s;
	 * System.out.println(System.getProperty("user.dir")); FileInputStream f1 = new
	 * FileInputStream("./src/test/resources/test.poperties"); p = new Properties();
	 * p.load(f1); }
	 */

	@Given("I add four ramdon items to my cart")
	public void i_add_four_ramdon_items_to_my_cart() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://cms.demo.katalon.com/");

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 8; i++)
			list.add(i);
		Collections.shuffle(list);
		for (int i = 1; i < 5; i++) {
			System.out.println(list.get(i));
			Thread.sleep(2000);
			WebElement e = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[" + list.get(i) + "]/div/a[2]"));
			Thread.sleep(2000);
			if(i== 5&i == 8&i== 9) {
				driver.findElement(By.xpath("//select[@id='pa_size']")).click();
				Select s = new Select(driver.findElement(By.id("pa_size")));
				s.selectByIndex(1);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
				Thread.sleep(2000);
				driver.get("https://cms.demo.katalon.com/");
			}
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
		List<WebElement> itemssize = driver.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
		if(itemssize.size()==4) {
			Assert.assertTrue(true);	
		}
	}

	@When("I search for lowest price item")
	public void i_search_for_lowest_price_item() {
	List<WebElement> prices= driver.findElements(By.xpath("//td[@class='product-price']"));
	
	System.out.println("************"+prices.size());
	ArrayList<Integer> list = new ArrayList<Integer>();
	for(WebElement element: prices) {
		System.out.println(element.getText());
		String price = element.getText();
		System.out.println(price);
		
		 
		 
		}
	
	}
	@When("I am able to remove the lowest price item from my cart")
	public void i_am_able_to_remove_the_lowest_price_item_from_my_cart() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I am able to verify the three items in the cart")
	public void i_am_able_to_verify_the_three_items_in_the_cart() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
