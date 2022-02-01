package com.vtiger.comcast.contacttest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositlib.ContactInfoPage;
import com.vtiger.comcast.pomrepositlib.Contacts;
import com.vtiger.comcast.pomrepositlib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositlib.CreatenewContact;
import com.vtiger.comcast.pomrepositlib.Home;
import com.vtiger.comcast.pomrepositlib.Login;
import com.vtiger.comcast.pomrepositlib.Organizations;
import com.vtiger.comcast.pomrepositlib.OrganizationsInfo;

import genericutility.BaseClass;
import genericutility.Excelutility;
import genericutility.Fileutility;
import genericutility.Javautility;
import genericutility.WebDriverUtility;

public class ContactTest extends BaseClass {
	
	
	
	
	@Test(groups="regression testing")
	public void createContactwithorganizationTest() throws Throwable {
		
int randomInt = jLib.getRandomNumber();
		
	
		
		/*test script Data*/
		String orgName = eLib.getDataFromExcel("Sheet1", 10, 2) + randomInt;
		
		String contactname = eLib.getDataFromExcel("Sheet1", 10, 3) + randomInt;
		
		
		/**
		 * navigate to organizations
		 * 
		 */
		Organizations org=new Organizations(driver);
		org.getOrganizationlink().click();
		
		/**
		 * click on create new organization
		 */
		CreateNewOrganization cno=new CreateNewOrganization(driver);
		cno.getCreateneworgbutton().click();
		cno.getOrganizationName().sendKeys(orgName);
		cno.getSave().click();
		OrganizationsInfo oi=new OrganizationsInfo(driver);
		
		String SM = oi.getSuccessmessage().getText();
		Assert.assertTrue(SM.contains(orgName));
		
		//explicit wait
		
		wLib.waitforelementvisibility(driver, oi.getSuccessmessage());
		
		CreatenewContact cnc=new CreatenewContact(driver);
		cnc.getContactslink().click();
		
		//clicking on creating new contact lookup
		Contacts c=new Contacts(driver);
		c.getcreatecontactslookup().click();
		
		
		 
		 //create contact with org
		CreatenewContact cnc1=new CreatenewContact(driver);
		cnc1.contactLastName(contactname,orgName);
		 
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String CH = cip.getContactheader().getText();
		
		//Hard assert
		Assert.assertTrue(CH.contains(contactname));		
	}
	
	@Test(groups="smoke testing")
	public void createContactTest() throws Throwable {
	
	int randomInt = jLib.getRandomNumber();
	
	
	
	/*test script Data*/
	
	
	String contactname = eLib.getDataFromExcel("Sheet1", 7, 2) + randomInt;
	
	
	CreatenewContact cnc=new CreatenewContact(driver);
	cnc.getContactslink().click();
	
	

	//clicking on creating new contact lookup
	Contacts c=new Contacts(driver);
	c.getcreatecontactslookup().click();
	
	
	cnc.getLastname().sendKeys(contactname);
	
	cnc.getSavebutton().click();
	}
	
	
	
	
	
	
	
	
	
	

}
