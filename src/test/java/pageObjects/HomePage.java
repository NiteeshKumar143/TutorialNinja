package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;
    public HomePage(WebDriver driver)

    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement linkMyaccount;

    @FindBy(linkText = "Register")
    WebElement linkRegister;

    @FindBy(linkText = "Login")
    WebElement linkLogin;


    @FindBy(xpath = "//a[text()='Contact Us']")
    WebElement contactUs;



    public void clickMyAccount()

    {
        linkMyaccount.click();
    }

    public void clickRegister()
    {
        linkRegister.click();

    }

    public void clickLogin()

    {
      linkLogin.click();
    }

    public void contactUs()

    {
        contactUs.click();
    }



}
