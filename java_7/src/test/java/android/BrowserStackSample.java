package android;

import java.net.URL;
import java.util.List;
import java.util.function.Function;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserStackSample {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
    	DesiredCapabilities caps = new DesiredCapabilities();
    	
    	// Set your access credentials
    	caps.setCapability("browserstack.user", "surendragangwar_uPasdU");
    	caps.setCapability("browserstack.key", "sboWCXprD79UKqRB78sX");
    	
    	// Set URL of the application under test
    	cap.setCapability("deviceName", "OnePlus Nord CE 2");
			cap.setCapability("udid", "6PYDAMBYAYOJUOCA");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "12");
//			cap.setCapability("appPackage", "com.oneplus.calculator");
//			cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");
			cap.setCapability("appPackage", "com.cdac.qrticketing");
			cap.setCapability("appActivity", "com.cdac.qrticketing.SplashScreen");
			
       
    	
    	// Initialise the remote Webdriver using BrowserStack remote URL
    	// and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
        		new URL("http://127.0.0.1:4725/wd/hub"), caps);
        

        // Test case for the BrowserStack sample Android app. 
        // If you have uploaded your app, update the test case here. 
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
            ExpectedConditions.elementToBeClickable(
            		MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
		AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
             ExpectedConditions.elementToBeClickable(
            		 MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);
        List<AndroidElement> allProductsName = driver.findElementsByClassName(
        		"android.widget.TextView");
        assert(allProductsName.size() > 0);
        
        
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
		
	}

}
