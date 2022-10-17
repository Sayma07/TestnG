package page;



import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class listOfWebElementAndMethod extends Basepage {

	WebDriver driver;

	public listOfWebElementAndMethod(WebDriver driver) {
		this.driver = driver;
	}

	String wordWithRandomNumber;
	@FindBy(how = How.XPATH, using = "//input[@name='categorydata']")WebElement addCategoryField;

	@FindBy(how = How.XPATH, using = "//input[@value='Add category']")WebElement submitCategory;

	@FindBy(how = How.XPATH, using = "/html/body")WebElement BodyLine;

	@FindBy(how = How.XPATH, using = "//select[@name='due_month']")WebElement monthDropDown;

	@FindBy(how = How.XPATH, using = "//select[@name='category']")WebElement validateCategory;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Nevermind')]")WebElement nevermind;

	
	
	
	
public void insertCategory(String word) throws Exception {

		Thread.sleep(2000);

		wordWithRandomNumber = word + generateRandomNumber(1000);

		addCategoryField.sendKeys(wordWithRandomNumber);

		submitCategory.click();

	}

public void validationOfInsertCategory() {

		selectfromDropDown(validateCategory, wordWithRandomNumber);
		Select sel = new Select(validateCategory);
		sel.selectByVisibleText(wordWithRandomNumber);

		//keeping all the catagory in a list
		List<WebElement> allCategorydata = sel.getOptions();
	//taking each value in abc by for each loop from list of dropdown
		for(WebElement abc:allCategorydata) {
			
			//checking or validation
			if(abc.getText().contains(wordWithRandomNumber)) {
				System.out.println("added category showing in the display is: "+(abc.getText().contains(wordWithRandomNumber)));
				System.out.println("****************************");
				Assert.assertEquals(true, abc.getText().contains(wordWithRandomNumber));
			System.out.println("sayma");
			
			}
	}
	
		
		
}

	public void addDuplicateCategory(String word) {
		
		
		try{
			if(nevermind.isDisplayed()){
			nevermind.click();}
		}
		catch(Exception e) {
		addCategoryField.sendKeys(word);
		submitCategory.click();
		
		}
		
	}

	public void validateGenerateMessage(String word) {

		String expected = "The category you want to add already exists: " + word + ".";

		String BodyText = BodyLine.getText();
		String BodyTextArray[] = BodyText.split("\n");
		String ActulaLine = BodyTextArray[0];

		System.out.println("line" + ActulaLine);
		System.out.println("question: " + expected);

	Assert.assertEquals(ActulaLine, expected);
	System.out.println("Assertion Pass");
	

	}

	public void monthvalidation() {
		
		          Select sel = new Select(monthDropDown);
		          sel.selectByVisibleText("Apr");
		
		
		// making the Arraylist of the month from the techfios page
		List ActualMonthList = new ArrayList(); 
		
		// getting all the months fromgetOptions
		 List<WebElement> allMonth = sel.getOptions(); 
		         
		// by putting in for each loop it will give each month name one by one by getText
		 for (WebElement monthName : allMonth) { 
												                                          
			// then adding the value in ArrayList
			       ActualMonthList.add(monthName.getText());

			       
		 }
		//Making the list how i want
		List ExpectedMonth=new ArrayList();
		ExpectedMonth.add("None");
		ExpectedMonth.add("Jan");
		ExpectedMonth.add("Feb");
		ExpectedMonth.add("Mar");
		ExpectedMonth.add("Apr");
        ExpectedMonth.add("May");
		ExpectedMonth.add("Jun");
		ExpectedMonth.add("Jul");
		ExpectedMonth.add("Aug");
		ExpectedMonth.add("Sep");
		ExpectedMonth.add("Oct");
		ExpectedMonth.add("Nov");
		ExpectedMonth.add("Dec");
		
		System.out.println();
		
		
		for(int i=0;i<ActualMonthList.size();i++) {
			
			
			
			System.out.println("Actual Month In WebPage: "+ActualMonthList.get(i)+" & Expected MonthFrom Calender: "+ExpectedMonth.get(i));
			//Assert.assertTrue(ActualMonthList.get(i).equals(ExpectedMonth.get(i)));
		Assert.assertEquals(ActualMonthList.get(i), (ExpectedMonth.get(i)));
		
		}
		}

	}


