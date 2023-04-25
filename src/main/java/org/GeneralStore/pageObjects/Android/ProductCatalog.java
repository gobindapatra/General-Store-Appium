package org.GeneralStore.pageObjects.Android;

import java.util.List;

import org.GeneralStore.uttils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalog extends AndroidActions
{
	AndroidDriver driver;
	public ProductCatalog(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);

	}
	
	
	@FindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> productname;
	
	@FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	public void searchItemByScroll(String productname)
	{
		scrollToText(productname);
	}
	
	public void addItemToCartByIndex(int index)
	{
		productname.get(index).click();
	
	}
	public void goToCartPage()
	{
		cart.click();
	}
	
	


}
