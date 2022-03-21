package Testlayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseW;
import Pompackage.AddtoCart;
import Pompackage.Login;
import Pompackage.Searchfacility;

public class Shoppingcart  extends BaseW{
	AddtoCart Cart;
	Login login;
	Searchfacility search;
	
	
	
	
	public Shoppingcart() {
		super();
	
	}
	@BeforeMethod
	public void initsetup() {
		initiate();
		Cart = new AddtoCart();
		login = new Login();
		search = new Searchfacility();
	}

	
	@Test(priority = 1)
	public void TC115additemtocart () throws InterruptedException {
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		scrolldown();
		Cart.clickaddtocart();
		
	}
	
	@Test(priority = 2)
	public void TC116Shoppingcart() throws InterruptedException {
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		down();
		Cart.clickaddtocart();
		tsleep();
		Cart.Clickcart();
	}
	@Test(priority = 3)
	public void TC117increasequantity() throws InterruptedException{//Walmart_TC117_Search facility, Add one item to the car, Shopping cart, + button to Increase product quantity
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		down();
		Cart.clickaddtocart();
		Cart.Clickcart();
		Cart.Clickincrease();
	}
	@Test(priority = 4)	
	public void TC118decreasequantitiy () throws InterruptedException { //Walmart_TC118_Search facility, Add one item to the car, Shopping cart, + button to Increase product quantity,  - button to decrease product quantity
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		down();
		Cart.clickaddtocart();
		Cart.Clickcart();
		Cart.Clickincrease();
		Cart.CLickdecrease();
	}
	@Test(priority = 5)	
	public void TC119Addmultipleitem() throws InterruptedException { // Walmart_TC119_Add more item in cart
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		down();
		Cart.clickaddtocart();
	}
	@Test(priority = 6)	
	public void TC120Removeoneitem() throws InterruptedException { //Walmart_TC120_Search facility, Add one item to the car, Shopping cart, + button to Increase product quantity,  - button to decrease product quantity, Remove link, item information
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		down();
		Cart.clickaddtocart();
		Cart.Clickcart();
		Cart.Clickincrease();
		Cart.CLickdecrease();
		Cart.Clickremove();
	}
	@Test(priority = 7)	
	public void TC121closebrowser() throws InterruptedException {
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		down();
		Cart.clickaddtocart();
		driver.close();
		driver.getCurrentUrl();
		
	}
	
	@AfterMethod
	public void close() {
		close();
	}
	
	@AfterClass
	public void complete() {
		System.out.println("There are no more test to be done");
	}
	
	
}


