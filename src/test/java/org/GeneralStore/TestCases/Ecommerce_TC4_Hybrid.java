package org.GeneralStore.TestCases;

import java.time.Duration;
import java.util.Set;

import org.GeneralStore.TestUtils.BaseTest;
import org.GeneralStore.pageObjects.Android.Cart;
import org.GeneralStore.pageObjects.Android.FormPage;
import org.GeneralStore.pageObjects.Android.ProductCatalog;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Ecommerce_TC4_Hybrid extends BaseTest
{
	
	
	public void setScreen()
	{
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	@Test(dataProvider ="GetData", groups={"Smoke"})
	public void FillForm(String Name , String Country , String Gender) throws InterruptedException
	{
		
		 FormPage formpage = new FormPage(driver);
		 Thread.sleep(10000);
	     formpage.setName(Name);
		formpage.setCountrySelection(Country); 
		formpage.setGender(Gender);
		formpage.submitForm();	
		
		ProductCatalog productcatalog = new ProductCatalog(driver);
		productcatalog.searchItemByScroll("Jordan 6 Rings");
		productcatalog.addItemToCartByIndex(0);
		productcatalog.addItemToCartByIndex(1);
		productcatalog.goToCartPage();
		Thread.sleep(5000);
		
	
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		Cart cart = new Cart(driver);
		double totalSum = cart.getProductsSum();
		double displayFormattedSum = cart.getTotalAmountDisplayed();
		AssertJUnit.assertEquals(totalSum, displayFormattedSum);
		
		
		WebElement ele =  driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPressGesture(ele);
		cart.acceptTerm();
		Thread.sleep(5000);
		cart.submitOrder();
		
		
	
		
		
				
		Thread.sleep(7000);
		//context means which window , you currently present 
		//Ex - Context are Native , Web
		
	Set<String> contextName=	driver.getContextHandles();
	for(String Context : contextName)
	{
		System.out.println(Context);
	}
	
	driver.context("WEBVIEW_com.androidsample.generalstore");
	driver.findElement(By.name("q")).sendKeys("Flipkart");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
    driver.context("NATIVE_APP");
    
    
		
		//driver.findElement(By.className(lastPageProductName))
		
		
	
	}
	@DataProvider
	public  Object[][] GetData()
	{
	  return new Object[][] { {"Gobinda Patra" , "Argentina","Male"},{"Patra", "Argentina","Female"}  } ;
	}

}
