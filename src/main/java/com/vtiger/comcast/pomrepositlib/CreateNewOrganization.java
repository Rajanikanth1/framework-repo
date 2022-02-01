package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.WebDriverUtility;

public class CreateNewOrganization extends WebDriverUtility {

	public CreateNewOrganization(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createneworgbutton;
	
	public WebElement getCreateneworgbutton() {
		return createneworgbutton;
	}


	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrganizationName;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[2]")
	private WebElement save;
	
	
	@FindBy(name="industry")
	private WebElement industrydropdown;
	
	@FindBy(xpath="//option[@value='Education']")
	private WebElement educationoption;

	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typedropdown;
	
	
	public WebElement getTypedropdown() {
		return typedropdown;
	}


	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}

	
	public WebElement getEducationoption() {
		return educationoption;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void createneworganization(String orgname)
	{
		OrganizationName.sendKeys(orgname);
		save.click();
	}
	
	public void createneworganizationwitheducation(String orgname) {
	OrganizationName.sendKeys(orgname);
	select(industrydropdown,"educationoption");
	save.click();
}}
