package genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositlib.Home;
import com.vtiger.comcast.pomrepositlib.Login;

public class BaseClass {
	
	public static WebDriver sDriver=null;
	public WebDriver driver;
	  /*Object Creation for Lib*/
		public Javautility jLib = new Javautility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public Fileutility fLib = new Fileutility();
		public Excelutility eLib = new Excelutility();
		
		
		@BeforeClass (groups= {"smoke testing","regression testing"})
		public void configBC() throws Throwable {
			System.out.println("=============Launch the Browser=======");
			//launch the browser
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			String URL = fLib.getPropertyKeyValue("url");
			String BROWSER = fLib.getPropertyKeyValue("browser");
			if(BROWSER.equals("chrome")) {
		    	driver = new ChromeDriver();
		    }
		    	else if(BROWSER.equals("firefox")){
		    		driver = new FirefoxDriver();
		    	}
			
			wLib.waituntilpageload(driver);
			driver.manage().window().maximize();}
		
		
		@BeforeMethod (groups= {"smoke testing","regression testing"})
		public void configBM() throws Throwable {
			/*common Data*/
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			String URL = fLib.getPropertyKeyValue("url");
			String BROWSER = fLib.getPropertyKeyValue("browser");
			/* Navigate to app*/
			   driver.get(URL);
			   sDriver=driver;
		        /* step 1 : login */
		        Login loginPage = new Login(driver);
		        loginPage.logintoapplication(USERNAME, PASSWORD);
		}

		
		
		@AfterMethod (groups= {"smoke testing","regression testing"})
		public void configAM() {
		      /*step 6 : logout*/
			Home homePage = new Home(driver);
	        homePage.logout();
		}
		
		@AfterClass(groups= {"smoke testing","regression testing"})
		public void configAC() {
			System.out.println("=============Close the Browser=======");
			driver.quit();
		}		
}
