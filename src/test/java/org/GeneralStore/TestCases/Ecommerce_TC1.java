package org.GeneralStore.TestCases;

import org.GeneralStore.TestUtils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Ecommerce_TC1 extends BaseTest
{
	@BeforeMethod
	public void setScreen()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	@Test
	public void FillFormNegetive() throws InterruptedException
	{
		Thread.sleep(10000);
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Gobinda");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable ( new UiSelector() ).scrollIntoView( text ( \"Argentina\" ))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String ToastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
	//	Assert.assertEquals(ToastMessage,"Please enter your name");.
		Assert.assertEquals(ToastMessage,"Please enter  name");
		
	}
	
	
	
	
	@Test
	
	public void FillFormWithPositive() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Gobinda");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable ( new UiSelector() ).scrollIntoView( text ( \"Argentina\" ))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Assert.assertTrue(driver.findElements(By.xpath("//android.widget.Toast[1]")).size() < 1);
		//String ToastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
	//	Assert.assertEquals(ToastMessage,"Please enter your name");
		
	
}
}
