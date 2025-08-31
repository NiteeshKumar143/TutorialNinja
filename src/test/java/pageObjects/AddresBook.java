package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddresBook {
	

	WebDriver driver;

	public AddresBook(WebDriver driver)
	{

	    this.driver=driver;
	    PageFactory.initElements(driver, this);

	}
     
	
	
	
	@FindBy(xpath ="//div[@class='list-group']//a[contains(text(),'Address Book')]")
	WebElement addbook;
	
	  public void clickOnAddressbook()
	    {
	        addbook.click();
	    }
	
	@FindBy(xpath ="//div[@class='pull-right']//a[contains(text(),'New Address')]")
	WebElement newadd;
	
	    
	    public void clickOnNewAdd()
	    {
	        newadd.click();
	    }
	
	
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement Fname;
	
	@FindBy(xpath ="//input[@id='input-lastname']")     
	WebElement Lname;


	@FindBy(xpath ="//input[@id='input-company']")     
	WebElement Company;
	
	@FindBy(xpath ="//input[@id='input-address-1']")     
	WebElement Add1;
	
	@FindBy(xpath ="//input[@id='input-address-2']")     
	WebElement Add2;
	  
	
	@FindBy(xpath ="//input[@id='input-city']")     
	WebElement City;
	
	@FindBy(xpath ="//input[@id='input-postcode']")     
	WebElement PostCode;
	
	@FindBy(xpath ="//select[@id='input-country']")     
	WebElement Country;
	
	@FindBy(xpath ="//select[@id='input-zone']")     
	WebElement State;
	
	@FindBy(xpath ="//input[@class='btn btn-primary']")     
	WebElement Continue;
	
	@FindBy(xpath="//div[contains(text(),'Your address has been successfully added')]")
	WebElement sucessmessage;
	
	 public void setName(String fname)
	    {
	        Fname.sendKeys(fname);
	    }

	 
	    public void setLname(String lname)
	    {
	        Lname.sendKeys(lname);
	    }
	    
	    
	    public void setCompany(String copny)
	    {
	        Company.sendKeys(copny);
	    }
	    
	    
	    
	    public void setAddress(String add1)
	    {
	        Add1.sendKeys(add1);
	    }
	    
	    public void setAddress2(String add2)
	    {
	        Add2.sendKeys(add2);
	    }
	    
	    public void setCity(String city)
	    {
	        City.sendKeys(city);
	    }
	    
	    public void setPostalCode(String postcode)
	    {
	        PostCode.sendKeys(postcode);
	    }
	     
	    

	  
	    
	    public void SelectCountry(String countryname)
	    {
	    	 Select select = new Select(Country);
	         select.selectByValue(countryname);
	    	
	    }
	    
	    
	    public void SelectState(String statename)
	    {
	    	 Select select = new Select(State);
	         select.selectByValue(statename);
	    	
	    }
	    
	    public void clickOnContinue()
	    {
	        Continue.click();
	    }
	    
	        
	    
   public String sucessadd()
    {
	        try
	        {
	            return (sucessmessage.getText());
        }
        catch(Exception e)
        {
            return("no text found");
        }
	    }

	

}
