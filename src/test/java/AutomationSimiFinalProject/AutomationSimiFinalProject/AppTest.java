package AutomationSimiFinalProject.AutomationSimiFinalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	
	WebDriver driver = new ChromeDriver();
	String theWebside = "https://codenboxautomationlab.com/practice/";

	Random rand = new Random();

	@BeforeTest
	public void mySetup() {

		driver.get(theWebside);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = false)
	public void radioButton() {

		WebElement radioButton = driver.findElement(By.id("radio-btn-example"));
		List<WebElement> allradioButton = radioButton.findElements(By.tagName("input"));
		int randomRadioButton = rand.nextInt(allradioButton.size());

		allradioButton.get(randomRadioButton).click();
//		allradioButton.get(2).click();

//		List<WebElement> randomRadioButtons = driver.findElements(By.className("radioButton"));
//		int anyRandomRadio = rand.nextInt(randomRadioButtons.size());
//		randomRadioButtons.get(anyRandomRadio);

	}

	@Test(priority = 2, enabled = false)
	public void autoCompletTest() throws InterruptedException {
		WebElement autoCompletField = driver.findElement(By.id("autocomplete"));
		String[] countries = { "jo", "sa", "la", "pl", "us" };
		int randomIndex = rand.nextInt(countries.length);
		autoCompletField.sendKeys(countries[randomIndex]);
		Thread.sleep(1000);
		autoCompletField.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 3, enabled = false)
	public void staticSelect() throws InterruptedException {
		WebElement theSelect = driver.findElement(By.id("dropdown-class-example"));
		Select mySelect = new Select(theSelect);

		mySelect.selectByVisibleText("API");

//		mySelect.selectByIndex(1);
//		mySelect.selectByValue("option2");

//		System.out.println(theSelect.findElements(By.tagName("option")).size());

//		"another ways without using Select"
//		theSelect.click();
//		Thread.sleep(1000);
//		theSelect.sendKeys(Keys.chord(Keys.ARROW_DOWN ,Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 4, enabled = false)
	public void checkBoxTest() {
		WebElement checkBox = driver.findElement(By.id("checkbox-example"));
		List<WebElement> allCheckBoses = checkBox.findElements(By.tagName("input"));

		int randomCheckBoxes = rand.nextInt(allCheckBoses.size());
		allCheckBoses.get(randomCheckBoxes).click();

	}

	@Test(priority = 5, enabled = false)
	public void switchWindow() throws InterruptedException {

		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();

		Set<String> handles = driver.getWindowHandles();
		List<String> windowHandle = new ArrayList<>(handles);
		driver.switchTo().window(windowHandle.get(1));

		driver.findElement(By.xpath("//*[@id=\"menu-item-9675\"]/a/span[1]")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		driver.switchTo().window(windowHandle.get(0));

	}

	@Test(priority = 6, enabled = false)
	public void switchTab() throws InterruptedException {
		WebElement openNewTab = driver.findElement(By.id("opentab"));
		openNewTab.click();

		Set<String> newTab = driver.getWindowHandles();
		List<String> tabList = new ArrayList<>(newTab);
		driver.switchTo().window(tabList.get(1));

		driver.findElement(By.xpath("//div[@class='yt-tab-shape-wiz__tab']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(1000);

		driver.switchTo().window(tabList.get(0));
		System.out.println(driver.getTitle());

	}

	@Test(priority = 7, enabled = false)
	public void alertTabTest() {
		WebElement alertFieldForName = driver.findElement(By.id("name"));
		alertFieldForName.sendKeys("amer");

		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		alertButton.click();

		driver.switchTo().alert().accept();

	}

	@Test(priority = 8, enabled = false)
	public void confirmButtonTest() {
		WebElement confirmFeildForName = driver.findElement(By.id("name"));
		confirmFeildForName.sendKeys("student");
		WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
		confirmButton.click();

//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

	}

	@Test(priority = 9, enabled = false)
	public void testTheTable() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,1600)");

		WebElement tableTest = driver.findElement(By.id("product"));
//		List<WebElement> allRows = driver.findElements(By.tagName("tr"));
		List<WebElement> headrow = tableTest.findElements(By.tagName("th"));
		List<WebElement> datarows = tableTest.findElements(By.tagName("td"));

		System.out.println(headrow.get(2).getText());

		for (int j = 0; j < datarows.size(); j = j + 3) {

			System.out.println(datarows.get(j).getText());

		}

//		print random row
//		int randomRows = rand.nextInt(allRows.size());
//		
//		System.out.println(allRows.get(randomRows).getText());

//		print all rows , print th or print td 
//		for(int i=0 ; i<allRows.size();i++) {
//			
//			
//			System.out.println(allRows.get(i).getText());
//			
//			
//		}
//			

	}

	@Test(priority = 10, enabled = false)
	public void hideShowEx() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,1800)");

		WebElement writeInField = driver.findElement(By.id("displayed-text"));
		writeInField.sendKeys("amer");

		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();

		WebElement showbutton = driver.findElement(By.id("show-textbox"));
		showbutton.click();

	}

	@Test(priority = 11, enabled = false)
	public void enabledDisabledButton() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,1800)");

		WebElement disableButton = driver.findElement(By.id("disabled-button"));
		disableButton.click();

		WebElement enableButton = driver.findElement(By.id("enabled-button"));
		enableButton.click();

		WebElement enableField = driver.findElement(By.id("enabled-example-input"));
		enableField.sendKeys("amer002");

	}

	@Test(priority = 12, enabled = false)
	public void toMouseHover() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1800)");

		WebElement moveToMouseHover = driver.findElement(By.id("mousehover"));

		Actions action = new Actions(driver);
		action.moveToElement(moveToMouseHover).click().perform();

		WebElement moveToTopButton = driver.findElement(By.linkText("Top"));
		moveToTopButton.click();

		js.executeScript("window.scrollTo(0,1800)");
		action.moveToElement(moveToMouseHover).click().perform();

		WebElement moveToReloadButton = driver.findElement(By.linkText("Reload"));
		moveToReloadButton.click();

		driver.navigate().refresh();

	}

	@Test(priority = 13, enabled = false)
	public void calenderEx() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2000)");

		WebElement bookingCalender = driver.findElement(By.linkText("Booking Calendar"));
		bookingCalender.click();

		System.out.println(driver.getTitle());

		WebElement enableButton = driver.findElement(By.id("enabled-button"));
		enableButton.click();

		WebElement enableField = driver.findElement(By.id("enabled-example-input"));
		enableField.sendKeys("amer002");

		Thread.sleep(1000);

		Set<String> theNewWab = driver.getWindowHandles();
		List<String> handles = new ArrayList<>(theNewWab);
		driver.switchTo().window(handles.get(1));

		WebElement theTable = driver.findElement(By.cssSelector(".datepick.wpbc_calendar"));
		List<WebElement> tableData = theTable.findElements(By.tagName("td"));

		for (int i = 0; i < tableData.size(); i++) {
			System.out.println(tableData.get(i).getText());

		}

		System.out.println(driver.getTitle());

	}

	@Test(priority = 14, enabled = false)
	public void iFrameTest() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2200)");

		driver.switchTo().frame("courses-iframe");
		WebElement burgerMenuIFrame = driver.findElement(By.className("ct-mobile-meta-item"));
		burgerMenuIFrame.click();

		Set<String> handles = driver.getWindowHandles();
		List<String> switchTab = new ArrayList<>(handles);
		driver.switchTo().window(switchTab.get(0));

		WebElement bookingCalender2 = driver.findElement(By.linkText("Booking Calendar"));
		bookingCalender2.click();

		Set<String> handles2 = driver.getWindowHandles();
		List<String> switchTab2 = new ArrayList<>(handles2);
		driver.switchTo().window(switchTab2.get(1));
		driver.navigate().refresh();

		driver.switchTo().window(switchTab2.get(0));

		driver.switchTo().frame("courses-iframe");
		WebElement exitFromBurgerMenu = driver.findElement(By.className("ct-mobile-meta-item"));
		exitFromBurgerMenu.click();
		driver.switchTo().window(switchTab.get(0));
		WebElement bookingCalender3 = driver.findElement(By.linkText("Booking Calendar"));
		bookingCalender3.click();

		Set<String> handels3 = driver.getWindowHandles();
		List<String> switchTab3 = new ArrayList<>(handels3);
		driver.switchTo().window(switchTab3.get(1));

	}

	@Test(priority = 15)
	public void downloadButton() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2800)");

		WebElement theDownloadButton = driver.findElement(By.linkText("Download Apk files"));
		theDownloadButton.click();

	}
}

	
	
