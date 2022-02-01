package com.vtiger.comcast.organiaztiontest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.comcast.pomrepositlib.Contactinfo;
import com.vtiger.comcast.pomrepositlib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositlib.Home;
import com.vtiger.comcast.pomrepositlib.Login;
import com.vtiger.comcast.pomrepositlib.Organizations;
import com.vtiger.comcast.pomrepositlib.OrganizationsInfo;

import genericutility.BaseClass;
import genericutility.Excelutility;
import genericutility.Fileutility;
import genericutility.Javautility;
import genericutility.WebDriverUtility;
@Listeners(genericutility.LisImpClass.class)
public class OrganizationTest extends BaseClass {

	
	
	
	@Test(groups="smoke testing")
	
	
	
	public void createOrgTest() throws Throwable {
			
int randomInt = jLib.getRandomNumber();
		/*test script Data*/
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomInt;
		
		
		
		
		
		//navigate to organization
		Home home = new Home(driver);
		home.getOrganization().click();
		
		//navigate to create organization
		Organizations org=new Organizations(driver);
		
		
		//create org
		CreateNewOrganization cr=new CreateNewOrganization(driver);
		cr.getCreateneworgbutton().click();
		Thread.sleep(3000);
		cr.createneworganization(orgName);
		
		
		//verifying for successful message
		OrganizationsInfo info=new OrganizationsInfo(driver);
		wLib.waitforelementvisibility(driver, info.getSuccessmessage());
		String actual_message = info.getSuccessmessage().getText();
		
		if(actual_message.contains(orgName)) {
			System.out.println("org is created successfully");
		}
		else {
			System.out.println("org is not created successfully");
		}
		
		
	}

	@Test(groups="regression testing")
	public void createOrgWithIndutriesTest() throws Throwable {
		/*test script Data*/
		
		int randomInt = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("Sheet1", 4, 2) + randomInt;
		String industriesType = eLib.getDataFromExcel("Sheet1", 4, 3);
		 /*step 2 : navigate to organization*/
        Home homePage = new Home(driver);
        homePage.getOrganization().click();
        
        /*step 3 : navigate to "create new organization"page by click on "+" image */
        CreateNewOrganization orgPage = new CreateNewOrganization(driver);
        orgPage.getCreateneworgbutton().click();
        
       
         /**
          * create org with industry dropdown having education
          */
      
        orgPage.getOrganizationName().sendKeys(orgName);
        WebElement industrydropdown = orgPage.getIndustrydropdown();
        WebElement education = orgPage.getEducationoption();
        
        wLib.select(industrydropdown,"Education");
        orgPage.getSave().click();
        
        
        
        
        
        
        /*verify orgname & industry */
       
       OrganizationsInfo orginfoPage = new OrganizationsInfo(driver);
        String  actSuccesfullMg =  orginfoPage.getSuccessmessage().getText();
        SoftAssert s = new SoftAssert();
        s.assertTrue(actSuccesfullMg.contains(orgName));
        
        
        
        
        Contactinfo ci=new Contactinfo(driver);
        String actIndustryType = ci.getEducationsuccessmessage().getText();
        
        if(actIndustryType.equals(industriesType)) {
        	System.out.println(industriesType + "==>industry is verified successfully");
        }else {
        	System.out.println(industriesType + "==>industry is not verified successfully");

        }
	}}

