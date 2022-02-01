package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
//create a constructor to receive driver and load pagefactory class and access this class elements
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//web page repository---storing all xpaths
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userpasswordEdt;
	
	@FindBy(xpath="(//input[@value='Login'])[2]")
	private WebElement loginbutton;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserpasswordEdt() {
		return userpasswordEdt;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	
	//business library or method to login
	
	public void logintoapplication(String username,String password)
	{
		userNameEdt.sendKeys(username);
		userpasswordEdt.sendKeys(password);
		loginbutton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}