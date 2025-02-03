package driversetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import parameters.PropertiesReader;

import java.util.Scanner;

public class DriverSetup {

    private WebDriver driver;
    static int option;  // To store user's choice for browser
    
    // Static block to read user's choice
    static {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Browser :\n 1: Chrome\n 2: Edge");
        option = sc.nextInt();
        sc.close();
    }

    // Method to initialize the WebDriver
    public WebDriver getDriver() {
        PropertiesReader cfs = new PropertiesReader();  // Assuming PropertiesReader is available
        
        // Initialize WebDriver based on user's choice
        if (option == 1) {
            System.setProperty(cfs.getChromeDriverName(), cfs.getChromeDriverPath());
            driver = new ChromeDriver();
        } else if (option == 2) {
            System.setProperty(cfs.getEdgeDriverName(), cfs.getEdgeDriverPath());
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid choice! Defaulting to Chrome.");
            System.setProperty(cfs.getChromeDriverName(), cfs.getChromeDriverPath());
            driver = new ChromeDriver();  // Default to Chrome if invalid input is provided
        }

        // Open the main URL and maximize window
        driver.get(cfs.getMainURL());
        driver.manage().window().maximize();

        return driver;  // Return WebDriver instance
    }
}
