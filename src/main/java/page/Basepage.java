package page;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {

	WebElement element;

	public void selectfromDropDown(WebElement element, String visibleText) {

		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);

	}

	public int generateRandomNumber(int boundaryNum) {
		Random rnd = new Random();
		int RnDmNum = rnd.nextInt(boundaryNum);

		return RnDmNum;

	}

	public void waitforElement(WebDriver driver, int timeInSecond, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
		wait.until(ExpectedConditions.visibilityOf(locator));

	}
}
