package com.android.browser.WalmartShopping;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.PrintStream;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class SearchAndAddToCart  {


	private PrintStream verificationErrors;
	private String baseUrl;
	private Navigation navigate;
	
	private static WebDriver driver = null;
	private static util util = new util();

	
	@Before
	public void setUp() throws Exception {		
		
		driver = util.getAndroidDriver(driver);
		
		baseUrl = "http://mobile.walmart.com"; 
		navigate = driver.navigate();
		// navigate home page
		navigate.to(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			
		System.out.println("done before");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	/**
	 * 1. Perform a search on home page from a pool of key words given below
	 * 2. Identify an item from the result set that you can add to cart
	 * 3. Add the item to cart and then login using existing account, which is set up with at least one shipping address
	 * 4. Validate that item added is present in the cart and is the only item in the cart
	 */
	
	
	@Test
	public void testWalmartMobileSite() throws Exception {
		

		System.out.println("1. Perform a search on home page from a pool of key words given below ");
		
		WebElement searchbar= driver.findElement(By.name("query"));
		
		searchbar.clear();
		searchbar.sendKeys("dvd");
		
		System.out.println("done sending key");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement SubmitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		SubmitButton.click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// search list
		
		WebElement searchProduct = driver.findElement(By.xpath("//li[2]/a/div[2]/div"));
				try {

					Assert.assertTrue(searchProduct.isDisplayed());
				} catch (Error e) {
					verificationErrors.append(e.toString());
				}

					Thread.sleep(3000);
			

		 // product detail page
					
		  searchProduct.click();
		  System.out.println("Selected the product");
		  Thread.sleep(2000);

		 /* step 2 */
				
		  System.out.println("2. Identify an item from the result set that you can add to cart");
		  
				
		  // add item to cart
		  
		   WebElement AddToCartBtn = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
		   AddToCartBtn.click();
		   
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   

		  // Step 3 
		   
		  // Login page
		   
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/form/div[2]/div/a[2]")).click();
			
				// clear and input email
				WebElement email = driver.findElement(By.name("email"));
				email.clear();
				email.sendKeys("testHomework@gmail.com");
				
						
				// clear and input password
				WebElement password = driver.findElement(By.name("password"));
				password.clear();
				password.sendKeys("TestWalmart");
				driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
				

				// Step 4
				// Check if the item added is the only item in the cart
				
				try {
					assertEquals("Items in cart (1)",
							driver.findElement(By.cssSelector("div.item-count"))
									.getText());
				} catch (Error e) {
					verificationErrors.append(e.toString());
				}

				assertEquals("1",
						driver.findElement(By.id("quantity")).getAttribute("value"));

				
}

}



