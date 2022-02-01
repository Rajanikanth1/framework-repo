package genericutility;

import java.io.File;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	/**
	 * this method will wait for 20 seconds so that page will be loaded
	 * @param driver
	 */
	public void waituntilpageload(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	
	/**
	 * this method will wait for the element to load
	 * @param driver
	 * @param element
	 */
	public void waitforelementvisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	
	
	/**
	 * This method wait for the element to be clicked , its custom wait created to avoid elemenInterAceptable Exception
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitforelementtobeclickable(WebDriver driver,WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count<20) {try {
			element.click();
			break;
			}
		catch(Throwable e)
		{
			Thread.sleep(2000);
			count++;
		}
			
		}
	}
	
	/**
	 * this method used to handle dropdown using visible text
	 * @param element
	 * @param option
	 */
	
	public void select(WebElement element,String option)
	{
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
	
	
	/**
	 * this method is used to handle dropdown using index
	 * 
	 * 
	 */
	public void select(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * this method will perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		
		action.moveToElement(element).perform();
		
	}
	
	
	/**
	 * this method is used to perform rightclick on the element
	 * @param driver
	 * @param element
	 */
	
	public void rightclick(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	
	/**
	 * this method is used to switch windows
	 * @param driver
	 * @param partrialtitle
	 */
	public void switchtowindow(WebDriver driver,String partrialtitle)
	{
		Set<String> allhandles = driver.getWindowHandles();
		Iterator<String> itr = allhandles.iterator();
		
		while(itr.hasNext()) {
			String windowid = itr.next();
			String title = driver.switchTo().window(windowid).getTitle();
			if(title.contains(partrialtitle))
				
			{
				break;
			}
		}}
	
		/**
		 * this method used to accept popup
		 * @param driver
		 */
		
		
		
		public void acceptalertpopup(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		
		}
		
		/**
		 * this method used to cancel popup
		 * @param driver
		 */
			
	public void cancelalertpopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * this method used to scroll
	 * @param driver
	 * @param element
	 */
	public void scrolltowebelement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		  int y= element.getLocation().getY();
		   js.executeScript("window.scrollBy(0,"+y+")", element);	
	}
	
    public void switchFrame(WebDriver driver,int index) {
    	driver.switchTo().frame(index);
    }   
    
    public void switchFrame(WebDriver driver,WebElement element) {
    	driver.switchTo().frame(element);
    } 
	
    public void switchFrame(WebDriver driver,String idOrName) {
    	driver.switchTo().frame(idOrName);
    } 
    public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./screenshot/"+screenshotName+".PNG");
    	Files.copy(src, dest);
    }
    
    /**
     * pass enter Key appertain in to Browser
     * @param driver
     */
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   } 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
