package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactLink {

	WebDriver driver = null;

	@Given("that I am on the Irish Life website homepage")
	public void that_i_am_on_the_irish_life_website_homepage() {

		//Initiating the Driver
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.irishlife.ie/");

		// Handling the 'Allow ALL' cookies setting
		String parentWindow = driver.getWindowHandle();
		WebElement allowall = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
		if(allowall.isDisplayed()) {
			driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();	
		}
		driver.switchTo().window(parentWindow);
	}

	@When("I click on the Contact link in then top navigation")
	public void i_click_on_the_contact_link_in_then_top_navigation() {

		//Navigating to Contact Link
		WebElement contact = driver.findElement(By.linkText("Contact"));
		Actions actions = new Actions(driver);
		actions.moveToElement(contact).click().perform();
	}

	@Then("a new page loads which contains a contact form")
	public void a_new_page_loads_which_contains_a_contact_form() throws InterruptedException {

		//Validating the Page Load completion
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean status = js.executeScript("return document.readyState").toString().equals("complete");
		Thread.sleep(1000);

		//SCrolling to Contact form
		WebElement contacform = driver.findElement(By.id("contact-form"));
		js.executeScript("arguments[0].scrollIntoView()",contacform);

		//Validating the Full Name
		WebElement firstName = driver.findElement(By.name("fullName"));
		if(status && firstName.isDisplayed()) {
			System.out.print("Page Loaded Successfully which contains contact form");
		}else {
			System.out.print("Page does not load successfully");
		}

		driver.quit();
	}

}
