package commonfunctions;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PBBranches {
	
	@FindBy(xpath = "((//img)[5]")
	WebElement ClickBranches;
	public void branchesClick() 
	{
		ClickBranches.click();
	}

}
