package Testlayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseW;
import Pompackage.AddtoCart;
import Pompackage.Login;
import Pompackage.Searchfacility;

public class Searchwalmart extends BaseW {
	AddtoCart Cart;
	Login login;
	Searchfacility search;
	SoftAssert asert;
	
	
	public Searchwalmart() {
		super();
	
	}
	@BeforeMethod
	public void initsetup() {
		initiate();
		Cart = new AddtoCart();
		login = new Login();
		search = new Searchfacility();
		asert = new SoftAssert();
	}
	
	@Test(priority = 1)
	public void TC94searching() throws InterruptedException {
		search.search(prop.getProperty("key"));
		search.suggestion();
			
	}
	@Test(priority = 2)
	public void TC95Relevantproduct() {
		search.search(prop.getProperty("key"));;
		search.Findbtn();
		search.clear();
	}

	@Test(priority = 3) 
	public void TC100customerrating() throws InterruptedException { //Walmart_TC100_Search facility, Relevant product, Product information, Numnber of pages, Pagination, Filtration, Customer rating
		search.search(prop.getProperty("key"));
		search.Findbtn();
		down();
		search.chosebyrating();
		tsleep();
		
	}
	
	@Test(priority = 4)
	public void TC103choosingseller() throws InterruptedException { //Walmart_TC103_Search facility, Relevant product, Product information, Numnber of pages, Pagination, Filtration, Best seller
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		down();
		search.chooseseller();
	}
	@Test(priority = 5)
	public void TC109sortingnewest () throws InterruptedException { //Walmart_TC109_Search facility, Sorting, Newest
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		search.selectsortby(prop.getProperty("sortby"));
		
	}
	@Test(priority = 6)
	public void TC113sortingfiltration () throws InterruptedException { //Walmart_TC113_Search facility, Sorting and Filtration
		search.search(prop.getProperty("key"));
		search.Findbtn();
		tsleep();
		down();
		search.chosebyrating();
		search.clickrating();
		tsleep();
		search.selectsortby(prop.getProperty("sortby"));
	}
	@Test(priority = 7)
	public void pagination() throws InterruptedException { //Walmart_TC114_Search facility, Sorting, Filtration and Pagination
		search.search(prop.getProperty("key"));
		search.Findbtn();
		asert.assertEquals(search.pagination(), true);
		logger.info("Comapring actual result and expected result.");
		asert.assertAll();
		logger.info("Results compared.");
		
	}

	@AfterMethod
	public void close() {
		browserclose();
	}
	@AfterClass
	public void complete() {
		System.out.println("There are no more test to be done");
	}
}
