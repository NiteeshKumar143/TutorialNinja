package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
	
	WebDriver driver;

	public ContactUs(WebDriver driver)
	{

	    this.driver=driver;
	    PageFactory.initElements(driver, this);

	}

	@FindBy(xpath ="//input[@id='input-name']")
	WebElement Name;
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement Email;

	
	@FindBy(xpath ="//textarea[@id='input-enquiry']")
	WebElement Query;
	
	
	@FindBy(xpath ="//input[@class='btn btn-primary']")
	WebElement SubmitButton;
	
	
	@FindBy(xpath="//h1[contains(text(),'Contact Us')]")
    WebElement Heading;
	
	
	
	
	 public void setName(String name)
	    {
	        Name.sendKeys(name);
	    }

	 
	    public void setEmail(String email)
	    {
	        Email.sendKeys(email);
	    }
	    
	    
	    public void setQuery(String query)
	    {
	        Query.sendKeys(query);
	    }
	    

	    public void clicktoSubmit()
	    {
	        SubmitButton.click();
	    }
	    
	    
	    public boolean isSucess()
	    {
	        try
	        {
	            return (Heading.isDisplayed());
	        }
	        catch(Exception e)
	        {
	            return(false);
	        }
	    }



}
