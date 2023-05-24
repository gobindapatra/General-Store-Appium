package org.GeneralStore.TestUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest 
{
	public AppiumDriverLocalService service;
	public AndroidDriver driver ;
	
	@BeforeClass(alwaysRun=true)
   public  void startService() throws IOException
   
   {
	   service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Gobinda//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		        service.start();	
		                
		        
				UiAutomator2Options options =new UiAutomator2Options();
				options.setDeviceName("TestingEmulator");
				options.setApp("E://MyAppiumWorkPlace//appium//src//test//java//resources//General-Store.apk");
				options.setChromedriverExecutable("E://MyAppiumWorkPlace//appium//src//test//java//resources//chromedriver.exe");
				
				
			     driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options );	        
   }
   public void LongPressGesture(WebElement ele)
   {
	   ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of( "elementId", ((RemoteWebElement) ele).getId(),
				"duration", 2000 ));
   }
   
   public void SwipeGesture(WebElement ele, String direction)
   {
	   ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of( "elementId", ((RemoteWebElement) ele).getId(),
			   "direction", direction,
			    "percent", 0.75
			));
	   
   }
   
   public void scrollToEndAction()
	{
		 boolean canScrollMore;
		    do {
		    	canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    	    "left", 100, "top", 100, "width", 200, "height", 200,
		    	    "direction", "down",
		    	    "percent", 3.0
		    	));
		    }
		    while(canScrollMore);
	}
   
   
   public double GetFormattedString(String Amount)
   {
		double Price = Double.parseDouble(Amount.substring(1));
		return Price;
   }
   
   public String getScreenShot(String testCaseName ,AndroidDriver driver) throws IOException
   {
	  File source =  driver.getScreenshotAs(OutputType.FILE);
	  //String destination = System.getProperty("user.dir")+"//Extent Report//"+testCaseName+".png";
	 String destination = "E://MyAppiumWorkPlace//AppiumFrameworkDesign//Extent Report//"+testCaseName+".png";
	  FileUtils.copyFile(source, new File(destination));
	  return destination;
   }
   
   
   
   
   
	@AfterClass(alwaysRun=true)
   public void stopService()
   {
	   driver.quit();
	   service.stop();
	  
   }
}
