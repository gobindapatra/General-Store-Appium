package org.GeneralStore.pageObjects.Android;

import java.util.List;

import org.GeneralStore.uttils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.appium.java_client.android.AndroidDriver;

public class Cart extends AndroidActions
{
	AndroidDriver driver;
	public Cart(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);

	}
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
    @FindBy(id= "com.androidsample.generalstore:id/termsButton")
    private WebElement termBtn ;
	
	@FindBy(id="android:id/button1")
	public WebElement acceptButton;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
	@FindBy(className="android.widget.CheckBox")
	public WebElement checkBox;

       
	public List<WebElement> getProductList()
	{
		
		return productList;
	}
	
	public double getProductsSum()
	{
		int count = productList.size();
		double totalSum =0;
		for(int i =0; i< count; i++)
		{
			String amountString =productList.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;  //160.97 + 120 =280.97
				
		}
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed()
	{
		return getFormattedAmount(totalAmount.getText());
	}
	
	
	
       public void acceptTerm() throws InterruptedException
       {
    	   //LongPressGesture(termBtn);
    	   Thread.sleep(5000);
    	   acceptButton.click();
       }
       public void submitOrder()
   	{
   		checkBox.click();
   		proceed.click();
   	}
}
