package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistration
{
    WebDriver driver;
    public AccountRegistration(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "firstname")
    WebElement txtFirstname;

    @FindBy(name = "lastname")
    WebElement txtLastname;

    @FindBy(name = "email")
    WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "confirm")
    WebElement confPassword;


    @FindBy(name = "agree")
    WebElement chkdPolicy;

    @FindBy(xpath = "//input[@type='submit' and @class='btn btn-primary']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    @FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li[5]")
    WebElement logout;
    
    public void setFirstName(String fname)
    {
        txtFirstname.sendKeys(fname);
    }

    public void setLastName(String lname)
    {
        txtLastname.sendKeys(lname);
    }

    public void setEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void setTxtTelephone(String telephone)
    {
        txtTelephone.sendKeys(telephone);
    }

    public void setPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void setConfPassword(String password)
    {
        confPassword.sendKeys(password);
    }


    public void setPrivacyPolicy()
    {
        chkdPolicy.click();
    }


    public void clickContinue()
    {
        btnContinue.click();

    }

    public String getConfirmationMessage()
    {
        try {
            return (msgConfirmation.getText());
        }
        catch (Exception e)
        {
            return(e.getMessage());
        }
    }
    
    
    public void logoutb()
    {
       logout.click();

    }

}
