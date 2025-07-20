package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage
{

WebDriver driver;

public MyAccountPage(WebDriver driver)
{

    this.driver=driver;
    PageFactory.initElements(driver, this);

}

@FindBy(xpath ="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")
WebElement logoutLink;


public void ClickLogout()
{
    logoutLink.click();

}

}
