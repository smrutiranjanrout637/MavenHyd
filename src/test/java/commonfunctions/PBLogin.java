package commonfunctions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBLogin {
	
WebDriver driver;
public PBLogin(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(name= "txtuId")
WebElement Enteruser;
@FindBy(name= "txtPword")
WebElement EnterPass;
@FindBy(name = "login")
WebElement ClickLogin;
public boolean verify_login(String username,String password) 
{
	Enteruser.sendKeys(username);
	EnterPass.sendKeys(password);
	ClickLogin.click();
	String Expected = "adminfolw";
	String Actual = driver.getCurrentUrl();
	if (Actual.toLowerCase().contains(Expected.toLowerCase())) 
	{
		Reporter.log("+Login success::"+Expected+" "+Actual,true);
		return true;
	}
	else 
	{
		Reporter.log("Login Fail::"+" "+Actual,true);
		return false;
	}
}


}
