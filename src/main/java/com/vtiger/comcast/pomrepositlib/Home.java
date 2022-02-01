package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organization;
	
	@FindBy(linkText="Contacts")
	private WebElement contacts;
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement addnewcontactbutton;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddnewcontactbutton() {
		return addnewcontactbutton;
	}

	@FindBy(linkText="Products")
	private WebElement products;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(linkText="Sign Out")
	private WebElement signout;

	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getProducts() {
		return products;
	}
	
	//business library or method to logout
	public void logout()
	{
		Actions action=new Actions(driver);
		action.moveToElement(administrator).perform();
		signout.click();
	}
	
	
	
	
}
