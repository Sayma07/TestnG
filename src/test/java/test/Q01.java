package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.Basepage;
import page.listOfWebElementAndMethod;
import util.BrowserFactory;

public class Q01 {
	// Validate a user is able to add a category and once the category is added it
	// should display.
	WebDriver driver;
	listOfWebElementAndMethod listofwebelementandmethod;
	String word;

	@Test
	public void addCategoryandDisplay() throws Exception {

		driver = BrowserFactory.init();
		listofwebelementandmethod = PageFactory.initElements(driver, listOfWebElementAndMethod.class);
		listofwebelementandmethod.insertCategory("book");
		listofwebelementandmethod.validationOfInsertCategory();
		
		BrowserFactory browserFactory = PageFactory.initElements(driver, BrowserFactory.class);
		//browserFactory.tearDown();
	
	
	
	
	}

}
