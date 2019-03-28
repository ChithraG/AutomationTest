package qaTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.internal.Nullable;

public class DeltaAirlinesTest extends TestProject {
	TestProject test;

	@Test
	public void OneWayTicketing() throws InterruptedException {
		test = new TestProject();
		// Enter trip type
		driver.findElement(By.xpath("//span[@aria-owns='selectTripType-desc']")).click();
		driver.findElement(By.xpath("//li[@id='ui-list-selectTripType1']")).click();

		// Enter From Info
		driver.findElement(By.id("fromAirportName")).click();
		driver.findElement(By.id("search_input")).sendKeys("BOS");
		Thread.sleep(2000L);
		driver.findElement(By.id("search_input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("search_input")).sendKeys(Keys.ENTER);

		// Enter To Info
		driver.findElement(By.id("toAirportName")).click();
		driver.findElement(By.id("search_input")).sendKeys("MSP");
		Thread.sleep(2000L);
		driver.findElement(By.id("search_input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("search_input")).sendKeys(Keys.ENTER);

		// Enter Calendar
		driver.findElement(By.id("input_departureDate_1")).click();
		while (!driver.findElement(By.cssSelector("[class='dl-datepicker-title'] [class='dl-datepicker-month-0']"))
				.getText().contains("May")
				&& !driver.findElement(By.cssSelector("[class='dl-datepicker-title'] [class='dl-datepicker-month-1']"))
						.getText().contains("May")) {
			driver.findElement(By.xpath("//a[@title='To select next month']")).click();
			
		}

		int number = driver
				.findElements(
						By.xpath("//tbody[@class='dl-datepicker-tbody-1'] //td[@class='dl-datepicker-available-day']"))
				.size();

		String day;
		for (int i = 0; i < number; i++) {
			day = driver
					.findElements(By
							.xpath("//tbody[@class='dl-datepicker-tbody-1'] //td[@class='dl-datepicker-available-day']"))
					.get(i).getText();
			if (day.equals("21")) {
				driver.findElements(
						By.xpath("//tbody[@class='dl-datepicker-tbody-1'] //td[@class='dl-datepicker-available-day']"))
						.get(i).click();
				driver.findElement(By.className("donebutton")).click();
				break;
			}
		}

		// Number of passengers
		driver.findElement(By.xpath("//span[@aria-labelledby='passengers-val']")).click();
		driver.findElement(By.id("ui-list-passengers1")).click();

		// Submit
		driver.findElement(By.id("btn-book-submit")).click();
	}

	@Test
	public void ATwoWayTicketing() throws InterruptedException {

		// Enter trip type
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//span[@aria-owns='selectTripType-desc']")).click();
		// driver.findElement(By.xpath("//span[@aria-owns='selectTripType-desc']/span[@id='selectTripType-val']")).click();
		driver.findElement(By.xpath("//li[@id='ui-list-selectTripType0']")).click();

		// Enter From Info
		driver.findElement(By.id("fromAirportName")).click();
		driver.findElement(By.id("search_input")).sendKeys("BOS");
		Thread.sleep(2000L);
		driver.findElement(By.id("search_input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("search_input")).sendKeys(Keys.ENTER);

		// Enter To Info
		driver.findElement(By.id("toAirportName")).click();
		driver.findElement(By.id("search_input")).sendKeys("MSP");
		Thread.sleep(2000L);
		driver.findElement(By.id("search_input")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("search_input")).sendKeys(Keys.ENTER);

		// Enter Calendar
		driver.findElement(By.id("calDepartLabelCont")).click();
		while (!driver.findElement(By.cssSelector("[class='dl-datepicker-title'] [class='dl-datepicker-month-0']"))
				.getText().contains("August")
				&& !driver.findElement(By.cssSelector("[class='dl-datepicker-title'] [class='dl-datepicker-month-1']"))
						.getText().contains("August")) {
			driver.findElement(By.xpath("//a[@title='To select next month']")).click();
		}

		List<WebElement> e = driver.findElements(
				By.xpath("//tbody[@class='dl-datepicker-tbody-1'] //td[@class='dl-datepicker-available-day']"));
		Iterator<WebElement> it = e.iterator();

		while (it.hasNext()) {
			WebElement we = it.next();
			String day = we.getText();
			if (day.equals("11")) {
				we.click();
			}
		}

		while (!driver.findElement(By.cssSelector("[class='dl-datepicker-title'] [class='dl-datepicker-month-0']"))
				.getText().contains("September")
				&& !driver.findElement(By.cssSelector("[class='dl-datepicker-title'] [class='dl-datepicker-month-1']"))
						.getText().contains("September")) {
			driver.findElement(By.xpath("//a[@title='To select next month']")).click();
		}

		List<WebElement> e2 = driver.findElements(
				By.xpath("//tbody[@class='dl-datepicker-tbody-1'] //td[@class='dl-datepicker-available-day']"));
		Iterator<WebElement> it2 = e2.iterator();

		while (it2.hasNext()) {
			WebElement we = it2.next();
			String day = we.getText();
			if (day.equals("11")) {
				we.click();
				break;
			}
		}

		driver.findElement(By.xpath("//button[@value='done']")).click();

		// Number of passengers
		driver.findElement(By.xpath("//span[@aria-labelledby='passengers-val']")).click();
		driver.findElement(By.id("ui-list-passengers1")).click();

		// Submit
		driver.findElement(By.id("btn-book-submit")).click();

	}
}