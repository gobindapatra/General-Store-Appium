package org.GeneralStore.pageObjects.Android;

import java.time.Duration;

import org.GeneralStore.uttils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions
{
	
	AndroidDriver driver;
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
		
	}
	
	
	
	@FindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@FindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@FindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	@FindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement MaleRadioBtn;
	
	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement FemaleRadioBtn;
	
	
	
	
	
	public void setName(String name)
	{
	    nameField.sendKeys(name);
	    driver.hideKeyboard();
	}
	
	public void setGender(String gender)
	{
		if(gender.contains("Male"))
		{
			MaleRadioBtn.click();
		}
		else
		{
			FemaleRadioBtn.click();
		}
	}
	
	public void setCountrySelection(String countryName)
	{
		
		countrySelection.click();
		scrollToText("Argentina");
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	public void submitForm()
	{
		shopButton.click();
	}
 

}
