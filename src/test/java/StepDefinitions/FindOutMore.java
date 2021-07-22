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

public class FindOutMore {

	WebDriver driver = null;

	@Given("that I am on the Irish Life website")
	public void that_i_am_on_the_irish_life_website() throws InterruptedException {

		//Initiating the Driver
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.irishlife.ie/");
		Thread.sleep(1000);
		
		// Handling the 'Allow ALL' cookies setting
		String parentWindow = driver.getWindowHandle();
		WebElement allowall = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
		if(allowall.isDisplayed()) {
			driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();	
		}
		driver.switchTo().window(parentWindow);

	}	

	@When("I click on the Find out more link in then top navigation")
	public void i_click_on_the_Find_out_more_link_in_then_top_navigation() {
		
		//Navigating to Find out more link
		WebElement findoutmore = driver.findElement(By.linkText("Find out more"));
		Actions actions = new Actions(driver);
		actions.moveToElement(findoutmore).click().perform();
	}

	@Then("I see a form which contains the text {string}")
	public void i_see_a_form_which_contains_the_text(String string) throws InterruptedException {

		//Validating the Page Load completion, Handling Allow All Cookies Setting and 'I want to cover' title
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean status = js.executeScript("return document.readyState").toString().equals("complete");
		Thread.sleep(1000);

		if(status) {
			WebElement allowall = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
			if(allowall.isDisplayed()) {
				driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();	
			}
			if(driver.findElement(By.className("m01_compare_step-title")).getText() == "I want to cover");
			{
				System.out.print("Page Loaded Successfully and displays I want to cover content");
			}

		}else {
			System.out.print("Page does not load successfully");
		}
		
	driver.quit();
	
	}

}
