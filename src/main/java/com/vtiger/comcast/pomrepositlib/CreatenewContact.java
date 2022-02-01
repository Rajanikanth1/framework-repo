package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.WebDriverUtility;

public class CreatenewContact extends WebDriverUtility {
WebDriver driver;
	public CreatenewContact(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement selectOrgNameLookup;
	
	
	public WebElement getSelectOrgNameLookup() {
		return selectOrgNameLookup;
	}

	public WebElement getLastname() {
		return lastname;
	}

	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement savebutton;

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getContactslink() {
		return contactslink;
	}
	
	public void contactLastName(String contactlastname,String orgName) {
		
		lastname.sendKeys(contactlastname);
		selectOrgNameLookup.click();
		 switchtowindow(driver,"Accounts&action");
		Organizations ogn=new Organizations(driver);
		ogn.getSearchbox().sendKeys(orgName);
		ogn.getSearchboxbtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		 switchtowindow(driver,"Contacts&action");
		 
		savebutton.click();

	}
	
	
	
}
