package testBase;


import org.testng.annotations.AfterClass;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
   public WebDriver driver;
   public   Logger logger; //For Logging
   public ResourceBundle rb;

  // @BeforeMethod
	@BeforeClass
    @Parameters("browser")
    public void setUp(String brows)
    {
        //load config file
        rb=ResourceBundle.getBundle("config");
        System.out.println("Loaded URL from config: " + rb.getString("appurl"));
        String appurl = rb.getString("appurl");

        //Logging
        logger = LogManager.getLogger(this.getClass());

        if(brows.equals("chrome"))
        {
            System.out.println("Setting up WebDriver...");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome start Successfully.");
        } else if (brows.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("FireFox start Successfully.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(appurl);

    }

    public void capturescreen(WebDriver driver, String tname) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File target=new File(System.getProperty("user.dir")+ "/screenshots/" +tname+".png");
        FileUtils.copyFile(source,target);

    }

    @AfterClass
    public void Teardown()
    {
       driver.quit();

    }

}

