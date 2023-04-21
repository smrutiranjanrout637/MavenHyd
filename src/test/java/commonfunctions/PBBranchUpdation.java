package commonfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBBranchUpdation {
	WebDriver driver;
	public PBBranchUpdation(WebDriver driver) 
	{
		this.driver=driver;
	}
	@FindBy(xpath = "(//img)[10] ")
	WebElement clickEdit;
	@FindBy(xpath = " //img[@src='images/Branches_but.jpg']")
	WebElement EnterBranch;
	@FindBy(xpath = "//input[@id='txtbName'] ")
	WebElement EnterAddress;
	@FindBy(xpath = " //tbody/tr[3]/td[2]")
	WebElement EnterArea;
	@FindBy(xpath = "//input[@id='txtArea'] ")
	WebElement EnterZip;
	@FindBy(xpath = "//input[@id='txtZip'] ")
	WebElement ClickUpdate;
	public boolean verify_UpdateBranch(String Branch,String Address,String Area,String Zipcode) throws Throwable 
	{
		this.clickEdit.click();
		this.EnterBranch.clear();
		this.EnterBranch.sendKeys(Branch);
		this.EnterAddress.clear();
		this.EnterAddress.sendKeys(Address);
		this.EnterArea.clear();
		this.EnterArea.sendKeys(Area);
		this.EnterZip.clear();
		this.EnterZip.sendKeys(Zipcode);
		this.ClickUpdate.click();
		String ExpectedAlert = driver.switchTo().alert().getText();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		String ActualAlert ="Branch updated";
		if(ExpectedAlert.toLowerCase().contains(ActualAlert.toLowerCase())) 
		{
			Reporter.log(ExpectedAlert,true);
			return true;
		}
		else 
		{
			Reporter.log("Unable to Update Branch",true);
			return false;
		}
	}
	
	

}
