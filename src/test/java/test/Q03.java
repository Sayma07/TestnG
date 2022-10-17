package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.listOfWebElementAndMethod;
import util.BrowserFactory;

public class Q03 {

//Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.
	
	WebDriver driver;
	listOfWebElementAndMethod listofwebelementandmethod;
	
@Test
public void dropDownHasAllTheMonth() {
	driver = BrowserFactory.init();
	
	
	listofwebelementandmethod=PageFactory.initElements(driver, listOfWebElementAndMethod.class);

	listofwebelementandmethod.monthvalidation();

}

}
