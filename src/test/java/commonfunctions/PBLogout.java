package commonfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBLogout {
	WebDriver driver;
	public PBLogout(WebDriver driver) 
	{
		this.driver=driver;
		}
	@FindBy(xpath = "(//img)[4]")
	WebElement clickLogout;
	@FindBy(xpath = "//input[@id='login']")
	WebElement LoginBtn;
	public boolean verify_logout() throws Throwable 
	{
		this.clickLogout.click();
		Thread.sleep(3000);
		if(this.LoginBtn.isDisplayed()) 
		{
			Reporter.log("Logout sucess",true);
			return true;
			}
		else 
		{
			Reporter.log("logout fail",true);
			return false;
			
		}
			
		
	}
	

}
