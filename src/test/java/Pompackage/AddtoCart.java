package Pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseW;

public class AddtoCart extends BaseW {
	@FindBy(xpath="//button[contains(text(), 'Add to cart')]") WebElement Additem;
	@FindBy(xpath="//a[@href='/cart']") WebElement cart;
	@FindBy(xpath="//button[@data-automation='increase-qty']") WebElement increase;
	@FindBy(xpath="//button[@data-automation='decrease-qty']") WebElement decrease;
	@FindBy(xpath="//button[@data-automation='remove-product-from-cart']") WebElement remove;
	@FindBy(xpath="//div[@xpath='1']") WebElement Total;
	@FindBy(xpath="//div[@class='css-nnfuqn enc9ah80']") WebElement product;
	@FindBy(xpath="//a[@data-automation='product-item-title']") WebElement productdescription;
	
	public AddtoCart() {
		PageFactory.initElements(driver, this);	
}
	public void clickaddtocart() {
		Additem.click();
	}

	public void Clickcart() {
		cart.click();
	}
	public void Clickincrease () {
		increase.click();
	}
	public void CLickdecrease() {
		decrease.click();
	}
	public void Clickremove() {
		remove.click();
	}
	public void showtotal() {
		Total.isDisplayed();
	}
	public void itemselected() {
		product.isDisplayed();
	}
	public void clickitemdescription() {
		productdescription.click();
	}
}
