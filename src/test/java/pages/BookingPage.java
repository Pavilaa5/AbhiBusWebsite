package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.event.InputEvent;
import static org.junit.Assert.*;

public class BookingPage {

    static WebDriver driver;
    static Robot robo;
    static Actions act;
    static JavascriptExecutor js;
    
    // Constructor to initialize the driver
    public BookingPage(WebDriver driver) throws AWTException {
        BookingPage.driver = driver;
        PageFactory.initElements(driver, this);
        robo = new Robot();
        act = new Actions(driver);
        js=(JavascriptExecutor) driver;
        }

    // Locator for the 'From Station'
    @FindBy(xpath= "//input[@placeholder=\"From Station\"]")
    private static WebElement fromStation;

    // Locator for the 'To Station'
    @FindBy(xpath = "//input[@placeholder=\"To Station\"]")
    private static WebElement toStation;

    // Locator for the 'Date Picker'
    @FindBy(xpath = "//input[@placeholder=\"Onward Journey Date\"]")
    private static WebElement travelDate;

    // Locator for the 'Search' button
    @FindBy(xpath = "//button[@class=\"btn btn-search filled primary lg inactive button\"]")
    private static WebElement searchButton;

    // Locator for AbhiBus logo
    @FindBy(xpath = "//div[@id='header-left-nav' and contains(@class, 'col')]")
    private static WebElement abhiBusLogo;

//    Locator for the bus name 
//    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div[4]/div[3]/div/div/div[1]/div/div[2]/div[1]/h5")
//    private static WebElement busName;

    // Locator for the seat
    @FindBy(xpath="//div[@id=\"service-operator-select-seat-2559674063\"]/button[@class=\"btn bus-info-btn filled primary sm inactive button\" and text()=\"Select Seats\"]")
    private static WebElement seat;

    // Locator for boarding point 
    @FindBy(xpath = "//input[@placeholder=\"Search Boarding Point\"]")
    private static WebElement boardingPoint;

//    Locator for dropping point
//    @FindBy(xpath = "//div[@id='place-select-container']//div[@class='container search-bar-container ']/div[@class=' col']/input[@placeholder='Search Boarding Point']")
//    private WebElement droppingPoint;
    
 // Locator for chooseseat
    @FindBy(xpath = "//button[@class=\"seat sleeper\"]")
    private static WebElement chooseseat;
    
 // Locator for  entername
    @FindBy(xpath = "//input[@placeholder=\"Name\"]")
    private static WebElement  entername;
    
    
 // Locator for  entergender
    @FindBy(xpath = "//button[@class=\"btn btn-gender outlined tertiary md inactive button\"]")
    private static WebElement  entergender;

    
 // Locator for  enternumber
    @FindBy(xpath = "//input[@class=\"true mobileNo-input\"]")
    private static WebElement  enternumber;

    
    // Locator for  enteremail
    @FindBy(xpath = "//input[@placeholder=\"Enter Email Address\"]")
    private static WebElement  enteremail;
    

    // Method to open AbhiBus website
    public static void openAbhiBusWebsite() {
        driver.get("https://www.abhibus.com/");
    }

    // Method to enter From Station
    public static void enterFromStation(String from) throws InterruptedException {
    	fromStation.click();
    	fromStation.sendKeys(from);
    	Thread.sleep(3000);
    	robo.mouseMove(235, 525);
    	robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    	
        Thread.sleep(3000);
    }

    // Method to enter To Station
    public static void enterToStation(String to) throws InterruptedException {
        toStation.click();
        toStation.sendKeys(to);
        Thread.sleep(2000);
        robo.mouseMove(435, 525);
    	robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        
        Thread.sleep(3000);
    }

    // Method to select travel date
    public static void selectTravelDate() throws InterruptedException {
    	travelDate.click();
    	js.executeScript("window.scrollBy(0,110)");
		Thread.sleep(2000);
        
		robo.mouseMove(1000, 400);
		robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1000);
		
		
      	robo.mouseMove(835, 525);
//		Thread.sleep(1000);
		robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//		act.click().perform();
    }
    
    
    // Method to click on the 'Search' button
    public static void clickSearchButton() throws InterruptedException {
        searchButton.click();
        Thread.sleep(1000);
        act.click().perform();
    }
    

    // Method to validate that we are on the correct page by checking the logo
    public static void validateAbhiBusLogo() throws InterruptedException {
        assertTrue(abhiBusLogo.isDisplayed());
        Thread.sleep(2000);
    //    js.executeScript("window.scrollBy(0,315)");
        robo.mouseMove(1200, 440);
//        Thread.sleep(2000);
//          seat.click();
		
    }
//
//  Method to select the seat
    public static void selectSeat() throws InterruptedException {
         js.executeScript("window.scrollBy(0,315)");
         robo.mouseMove(1200, 445);
         robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
 		robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
         Thread.sleep(3000);
	     seat.click();
    }

    // Method to select boarding point
    public static void selectBoardingPoint(String point) throws InterruptedException {
    	Thread.sleep(3000);
    	 js.executeScript("window.scrollBy(0,150)");
    	 Thread.sleep(4000);
    	boardingPoint.click();
    	boardingPoint.sendKeys(point);
    	robo.mouseMove(1000, 500);
        robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 Thread.sleep(2000);
    }

//    // Method to select dropping point
//    public void selectDroppingPoint(String point) {
//    	droppingPoint.click();
//    	droppingPoint.sendKeys(point);
//    }

    
  //Method to select chooseseat
  public static void chooseseat() throws InterruptedException {
	  chooseseat.click();
	  js.executeScript("window.scrollBy(0,150)");
	  robo.mouseMove(1000, 600);
	  Thread.sleep(2000);
      robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	 robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	 Thread.sleep(2000);
	 robo.mouseMove(970, 190);
	 Thread.sleep(2000);
	 robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	 robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	 
  }

  
//Method to select entername
  public static void entername(String name) throws InterruptedException {
	  entername.click();
	  Thread.sleep(3000);
	  entername.sendKeys(name);
  }
  
//Method to select entergender
  public static void entergender(){
	  entergender.click();
  }
  
 // Method to select enternumber
  public static void enternumber(String number) throws InterruptedException {
	  enternumber.click();
	  Thread.sleep(3000);
	  enternumber.sendKeys(number);
  } 
  
//Method to select enteremail
 public static void enteremail(String email) throws InterruptedException {
	  enteremail.click();
	  Thread.sleep(3000);
	  enteremail.sendKeys(email);
	  Thread.sleep(3000);
	  js.executeScript("window.scrollBy(0,540)");
	  Thread.sleep(2000);
 } 
  



}
