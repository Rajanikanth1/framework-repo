package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {

	public Organizations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
	public WebElement getOrganizationlink() {
		return organizationlink;
	}
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchbox;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchboxbtn;
	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchboxbtn() {
		return searchboxbtn;
	}
	
	
	
	
	
	}
	
	
	
	
	
	

