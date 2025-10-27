package com.petStore.api.genericUtility;

/**
 * This class consists of webdriver methods 
 * @author Antara Pal
 */
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	/**
	 * This method will fullScreen the window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
		
	}
	/**
	 * This method will wait for 10s 
	 * @param driver
	 */
	public void implicitlyWaits(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for 10s for only element will display 
	 * @param driver
	 */
	public void waitutillVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	/**
	 * This method will wait for 10s for only element is clickable
	 * @param driver
	 */
	public void waitutillClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will select single value at dropdown by using index value
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index) {
		Select s= new Select(element);
		s.selectByIndex(index);	
	}
	/**
	 * This method will select single value at dropdown by using  value/id
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,String value ) {
		Select s= new Select(element);
		s.selectByValue(value);	
	}
	/**
	 * This method will select single value at dropdown by using WebElement value
	 * @param element
	 * @param index
	 */
	public void handleDropdown(String text ,WebElement element) {
		Select s= new Select(element);
		s.selectByVisibleText(text);	
	}
	/**
	 * This method will move the cursur to the x,y position
	 * @param element
	 * @param index
	 */
	public void moveToElementAction(WebDriver driver,int x,int y) {
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).perform();
	}
	/**
	 * This method will double click on particular element
	 * @param element
	 * @param index
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
		
	}
	/**
	 * This method will right click on particular element
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will perform mouse hovering action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will click and hold the particular element for some time then it will be release
	 * @param element
	 * @param index
	 */
	public void clickHoldRelese(WebDriver driver) throws InterruptedException {
		Actions act = new Actions(driver);
		act.clickAndHold().perform();
		Thread.sleep(2000);
		act.release().perform();
	}
	/**
	 * This method will drag and drop the partucular element
	 * @param element
	 * @param index
	 */
	public void dragDrop(WebDriver driver,WebElement src,WebElement tar) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src,tar).perform();
	}
	/**
	 * This method will switch the frame using index value 
	 * @param element
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch the frame using name
	 * @param element
	 * @param index
	 */
	public void handleFrame(WebDriver driver,String name ) {
		driver.switchTo().frame(name);
	}
	/**
	 * This method will switch the frame using particular element
	 * @param element
	 * @param index
	 */
	public void handleFrame(WebDriver driver,WebElement ele ) {
		driver.switchTo().frame(ele);
	}
	/**
	 * This method will switch child frame to parent frame
	 * @param element
	 * @param index
	 */
	public void goToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch child frame to main frame
	 * @param element
	 * @param index
	 */
	public void goToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will handle the alert by clicking ok button
	 * @param element
	 * @param index
	 */
	public void handleAlertToAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	/**
	 * This method will handle the alert by clicking cancel button
	 * @param element
	 * @param index
	 */
	public void handleAlertToDissmiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will handle the alert by getting the test
	 * @param element
	 * @param index
	 */
	public String handleAlertToGettext(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	/**
	 * This method will handle the alert by giving data
	 * @param element
	 * @param index
	 */
	public void handleAlertToSendKeys(WebDriver driver,String arg) {
		driver.switchTo().alert().sendKeys(arg);
	}
	/**
	 * This method will help to switch to child window 
	 * @param element
	 * @param index
	 */
	public void WindowHandle(WebDriver driver) {
		String mainwin = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String win:handles) {
			if(!win.equals(mainwin)) {
				driver.switchTo().window(win);
			}
		}
		driver.switchTo().window(mainwin);
		
	}
	/**
	 * This method will switch to window based on window title
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	
	public void WindowHandle(WebDriver driver,String title) {
		Set<String> handles = driver.getWindowHandles();
		for(String win:handles) {
				driver.switchTo().window(win);
				String title2 = driver.getTitle();
				if(title2.contains(title)) {
					break;
				
			}
		}	
		
	}
	/**
	 * This method will be capture the screenshot and return the path to caller
	 * @return 
	 * @throws IOException 
	 */
	public String captureScreenshot(WebDriver driver, String screenShot) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE) ;
		File dist=new File(".\\Screenshot\\"+screenShot+".png");
		FileHandler.copy(src, dist);
		return dist.getAbsolutePath();
		
	}
	
	

}
