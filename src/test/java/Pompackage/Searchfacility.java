package Pompackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseW;

public class Searchfacility extends BaseW {
	@FindBy(id="search-form-input") WebElement search;
	@FindBy(xpath="//div[@class='css-124rndv epettpn4']") List<WebElement> Pinfo;
	@FindBy(xpath="//button[@aria-label='Search']") WebElement Findbutton;
	@FindBy(xpath="//button[@class='css-1v14l77 e1xoeh2i3']") WebElement Clear;
	@FindBy(xpath="//section[@class='css-139vial ed60zyg1']") WebElement numberofpages;
	
	//Filtration
	@FindBy(xpath="//label[contains(text(),'CustomerRating')]") WebElement customerrating;
	@FindBy(id="51") WebElement star;
	@FindBy(xpath="//div[contains(text(),'Online Savings')") WebElement onlinesaving;
	@FindBy(xpath="//label[contains(text(),'Seller')]") WebElement seller;
	@FindBy(xpath="//label[contains(text(),'Brand')]") WebElement brand;
	@FindBy(xpath="//label[contains(text(),'Price')]") WebElement price;
	@FindBy(xpath="//label[contains(text(),'Availability')]") WebElement availability;
	
	//Sorting
	@FindBy(xpath="//div[contains(text(),'Best Match')]") WebElement sortby;
	
	//Pagination
	@FindBy(xpath="//span[contains(text(), 'Search: charger')]") WebElement product;
	@FindBy(xpath="//a[contains(text(),'Next')]") WebElement nextbtn;
	@FindBy(xpath="//div[@class='css-1b5wmcr epettpn3']div//decendent::div[@class='css-155zfob e175iya63']//p[@class='css-1p4va6y eudvd6x0']") List<WebElement> first;
	
	public Searchfacility () {
		PageFactory.initElements(driver, this);
	}
	public void search (String key) {
		search.sendKeys(key);
	}
	public void suggestion() {
		for(WebElement ment : Pinfo) {
	        if(ment.getText().equalsIgnoreCase("television in electronics")) {
	           ment.click();
	            break;
	        }
		}
	}
	public void Findbtn() {
		Findbutton.click();
	}
	public void clear() {
		Clear.click();
	}
	public void displaypages() {
		numberofpages.isDisplayed();
	}
	public void chosebyrating() {
		customerrating.click();
	}
	public void clickrating() {
		star.click();
	}
	public void clickonlinesaving() {
		onlinesaving.click();
	}
	public void chooseseller() {
		seller.click();
	}
	public void choosebrand(){
		brand.click();
	}
	public void choosepricerange() {
		price.click();
	}
	public void checkavailability() {
		availability.isDisplayed();
	}
	public void selectsortby(String decending) {
		((Select) sortby).selectByVisibleText(decending);
	}
	public void nextbtn() {
		nextbtn.click();
	}
	public boolean pagination() {
			scrolldown();
			scrolldown();
			List<String> P1 = new ArrayList<String>(); // will store all web element as string from page 1
			for (WebElement element1 : first) {
				P1.add(element1.getText());
			}
			System.out.println("All elements of Page-1 are added to list P1");
			System.out.println("Count of Page1 list is : " + P1.size());
			Set<String> uniquevaluesP1 = new HashSet<String>();
			for (String A1 : P1) {
				if (uniquevaluesP1.add(A1) == false) {
					System.out.println("Duplicate in Page-1 : " + A1);
				}
			}
			int UVS1 = uniquevaluesP1.size();
			int RS1 = P1.size();
			int Repetation1 = RS1 - UVS1;
			if (UVS1 < RS1) {
				System.out.println("Total Number of object repeated in page 1 are " + Repetation1);
			}
			System.out.println("Page 1 list added to P1 and checked for duplication");
			nextbtn();
			scrolldown();
			scrolldown();
			List<String> P2 = new ArrayList<String>(); // will store all web element as string from page 2
			for (WebElement element2 : first) {
				P2.add(element2.getText());
			}
			System.out.println("All elements of Page-2 are added to list P2.");
			System.out.println("Count of Page2 list is " + P2.size());
			Set<String> uniquevaluesP2 = new HashSet<String>();
			for (String A2 : P2) {
				if (uniquevaluesP2.add(A2) == false) {
					System.out.println("Duplicate in Page-2 : " + A2);
				}
			}
			int UVS2 = uniquevaluesP2.size();
			int RS2 = P2.size();
			int Repetation2 = RS2 - UVS2;
			if (UVS2 < RS2) {
				System.out.println("Total number of objects repeated in page 2 are " + Repetation2);
			}
			System.out.println("Page 2 list added to P2 and checked for duplication");
			nextbtn();
			if (Repetation1 > 1) {
				System.out.println("There are duplicates in Page1.");
				for (int i = 0; i < RS1; i++) {
					if (P1.contains(P2.get(i))) {
						System.out.println("This element is duplicate in Page 1 and Page 2 :" + P2.get(i));
					} else {
						System.out.println("Checking next item in list 1 and 2 ");
					}
				}
			
					
					if (Repetation2 > 1) {
						System.out.println("There are duplicates in Page4");

					}
				
			}

	
			return false;
		}
	}




