package VTiger.Genericutilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains all generic methods related to webdriver actions
 * @author Admin
 *
 */
public class WebDriverUtility
{
	
	/**
	 * This method will maximise the window
	 * @param driver
	 */
	public void maximisewindow(WebDriver driver)
	{
         driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimise the window
	 * @param driver
	 */
	public void minimisewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for 20 seconds for the page to get loaded 
	 * @param driver
	 */
	public void waitforpageload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait for an element to be clickable 
	 * @param driver
	 * @param element
	 */
	public void waitforElementtobeclickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitforElementtobevisisble(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle Drop down with the help of visible text
	 * @param text
	 * @param element
	 */
	public void HandleDropdown(String text,WebElement element)
	{
		Select S=new Select(element);
		S.selectByVisibleText(text);
		
	}
	
	/**
	 * This method will handle Drop down with the help of index
	 * @param element
	 * @param index
	 */
	public void HandleDropdown(WebElement element,int index)
	{
		Select S=new Select(element);
		S.selectByIndex(index);
	}
	
	/**
	 * This method will handle Drop down with the help of value
	 * @param element
	 * @param value
	 */
	public void HandleDropdown(WebElement element,String value)
	{
		Select S=new Select(element);
		S.selectByValue(value);
	}
	
	/**
	 * This method will perform mouse over action on a Webelement
	 * @param driver
	 * @param element
	 */
	public void MouseOverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform Right click anywhere on the webpage
	 * @param driver
	 */
	public void RightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform Right click action on a Webelement
	 * @param driver
	 * @param element
	 */
	public void RightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click anywhere on the web page
	 * @param driver
	 */
	public void doubleclickAction(WebDriver driver) 
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();	
	}
	
	/**
	 * This method will perform double click on a Web element
	 * @param driver
	 * @param element
	 */
	public void doubleclickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform Drag and Drop action
	 * @param driver
	 * @param srcele
	 * @param destele
	 */
	public void DragandDropaction(WebDriver driver,WebElement srcele,WebElement destele)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcele, destele).perform();
	}
	
	/**
	 * This method will press and release enter key
	 * @throws Throwable
	 */
	public void pressEnter() throws Throwable
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will handle frames based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frames based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frames based on Web Element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the control to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch to window based on window title
	 * @param driver
	 * @param partialwintitle
	 */
	public void switchTowindow(WebDriver driver,String partialwintitle)
	{
		//step1:capture all window ids
		Set<String> allwinids=driver.getWindowHandles();
		
		//step2:navigate to each window
		for(String winid:allwinids)
		{
			//step3:switch to each window id and capture window title
			String acttitle = driver.switchTo().window(winid).getTitle();
			
			//step4:compare the title with required title
			if(acttitle.contains(partialwintitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * This method will take screenshot and return the path of destination
	 * @param driver
	 * @param ScreenShotname
	 * @return
	 * @throws Throwable 
	 */
	 public	String takescreenshot(WebDriver driver,String ScreenShotname) throws Throwable
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File(".\\ScreenShots\\"+ScreenShotname+".png");
			Files.copy(src, dst);
			return dst.getAbsolutePath();
		}
	 
	 
	 /**
	  * This method will perform random scroll action
	  * @param driver
	  */
     public void ScrollAction(WebDriver driver)
     {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(0.500);"," ");
     }
     
     /**
      * This method will accept the alert pop up
      * @param driver
      */
     public void acceptAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().accept();
     }
     
     /**
      * This method will dismiss the alert pop up
      * @param driver
      */
     public void dismissAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().dismiss();
     }
     
     public String getAlertText(WebDriver driver)
     {
    	 return driver.switchTo().alert().getText();
     }
     
	

}


