package Pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseW;

public class Login extends BaseW {
	@FindBy(xpath="//span[contains(text(),'My account')]") WebElement Myaccount;
	@FindBy(id="username") WebElement Email;
	@FindBy(id="password") WebElement Password;
	@FindBy(id="rememberme") WebElement rememberme;
	@FindBy(xpath="//button[contains(text(),'Sign in')]") WebElement Signin;
	
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	public void Myaccount() {
		Myaccount.click();
	}
	public void loginemail(String emailaddress) {
		Email.sendKeys(emailaddress);
	}
	public void Loginpassword(String pass) {
		Password.sendKeys(pass);
	}
	public void clickrememberme() {
		rememberme.click();
	}
	public void Clicksigninbtn() {
		Signin.click();
	}
}
