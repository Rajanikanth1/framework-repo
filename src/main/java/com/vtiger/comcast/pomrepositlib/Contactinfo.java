package com.vtiger.comcast.pomrepositlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactinfo {
	
public Contactinfo(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
	}
	
@FindBy(xpath="//td[@id='mouseArea_Industry']")
private WebElement educationsuccessmessage;

public WebElement getEducationsuccessmessage() {
	return educationsuccessmessage;
}





	
}
