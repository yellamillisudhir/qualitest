package cucumber.test.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.test.Helper.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class stepDefination {
	HomePage hp;
	Utils ut;
	WebDriver driver;

	@Given("I add four ramdon items to my cart")
	public void i_add_four_ramdon_items_to_my_cart() {
		Utils.launch();
		for (int i = 0; i <= 4; i++) {
			int value = ut.randomPick();
			System.out.println("**************"  +value);
			driver.findElement(By.xpath("//*[@id='main']/div[2]/ul/li[" + value + "]/div/a[2]")).click();

		}

	}

	@When("I view my cart")
	public void i_view_my_cart() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I find total four items listed in my cart")
	public void i_find_total_four_items_listed_in_my_cart() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I search for lowest price item")
	public void i_search_for_lowest_price_item() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
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
