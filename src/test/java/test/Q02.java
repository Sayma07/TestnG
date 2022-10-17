package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.listOfWebElementAndMethod;
import util.BrowserFactory;

public class Q02 {

	
WebDriver driver;
	listOfWebElementAndMethod listofwebelementandmethod;
	
	String word="Ball";
	/* Validate a user is not able to add a duplicated category. If it does then the following 
	message will display: "The category you want to add already exists: <duplicated category name>."
	
*/

	
	
	@Test
	
public void addDuplicate() throws InterruptedException {
	driver = BrowserFactory.init();
	
	listofwebelementandmethod = PageFactory.initElements(driver, listOfWebElementAndMethod.class);
	
	listofwebelementandmethod.addDuplicateCategory(word);
	
	listofwebelementandmethod.validateGenerateMessage(word);
	BrowserFactory browserFactory = PageFactory.initElements(driver, BrowserFactory.class);
	Thread.sleep(2000);
	//browserFactory.tearDown();



}



}