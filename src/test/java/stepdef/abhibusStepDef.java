package stepdef;

import java.awt.AWTException;
import java.awt.Button;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import driversetup.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingPage;

public class abhibusStepDef {
	static WebDriver driver;
	DriverSetup setup;
	BookingPage bookingPage;
	
	public abhibusStepDef() throws AWTException {
        setup = new DriverSetup();
        driver = setup.getDriver();  // Initialize WebDriver
        bookingPage = new BookingPage(driver);
        PageFactory.initElements(driver, this);  // Initialize page objects
    }
	
	@Given("I open the AbhiBus website")
	public void i_open_the_abhi_bus_website() throws InterruptedException {
		 bookingPage.openAbhiBusWebsite();
		 Thread.sleep(2000);
	}

	@Given("I select Bangalore as the from station")
	public void i_select_bangalore_as_the_from_station() throws InterruptedException {
		bookingPage.enterFromStation("Bangalore");
		
	}

	@Given("I select Coimbatore as the to station")
	public void i_select_coimbatore_as_the_to_station() throws InterruptedException {
		bookingPage.enterToStation("Coimbatore");
	}

	@Given("I select travel date")
	public void i_select_the_travel_date() throws InterruptedException {
		  bookingPage.selectTravelDate();
	}

	@When("I click on the Search button")
	public void i_click_on_the_search_button() throws InterruptedException {
            bookingPage.clickSearchButton();
	}

	@Then("I should be redirected to the AbhiBus search results page")
	public void i_should_be_redirected_to_the_abhi_bus_search_results_page() throws InterruptedException {
		 bookingPage.validateAbhiBusLogo();
	}

	@Then("I should see the AbhiBus logo on the page")
	public void i_should_see_the_abhi_bus_logo_on_the_page() throws InterruptedException {
		 bookingPage.validateAbhiBusLogo();
	}
	@When("I select the seat")
	public void i_select_the_seat() throws InterruptedException {
		 bookingPage.selectSeat();
	}
	@When("I select Majestic as the boarding point")
	public void i_select_majestic_as_the_boarding_point() throws InterruptedException {
		 bookingPage.selectBoardingPoint("Majestic");
	}
//
//	@When("I select Thudiyalur as the dropping point")
//	public void i_select_thudiyalur_as_the_dropping_point() {
//		bookingPage.selectDroppingPoint("Thudiyalur");
//	}
	
	@When("I select choose seat")
	public void i_select_choose_seat() throws InterruptedException {
		bookingPage.chooseseat();
	}
	
	@When("I Enter name")
	public void i_enter_name() throws InterruptedException {
		bookingPage.entername("Pavilaa");
	}
	
	@When("I Enter gender")
	public void i_enter_gender() throws InterruptedException {
		bookingPage.entergender();
	}
	
	@When("I Enter number")
	public void i_enter_number() throws InterruptedException {
		bookingPage.enternumber("9988765410");
	}
	
	@When("I Enter email")
	public void i_enter_email() throws InterruptedException {
		bookingPage.enteremail("abc@gmail.com");
	}
	
	@AfterStep
	public static void screenShot(Scenario scenario) {
		final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
