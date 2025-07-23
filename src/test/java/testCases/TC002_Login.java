package testCases;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC002_Login extends BaseClass
{
@Test
public void testLogin()
{
    logger.info("Starting login test");

    try {
        driver.get(rb.getString("appurl"));

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);

        lp.setEmail(rb.getString("email"));
        lp.setPassword(rb.getString("password"));



        lp.clicktoLogin();

        boolean targetpage = lp.isMyAccountPageExists();
        if (targetpage) {
            logger.info("Login success");
            AssertJUnit.assertTrue(true);
        } else {

            logger.info("Login failed");
            capturescreen(driver, "testLogin");
            AssertJUnit.assertTrue(false);

        }
    }
    catch (Exception e)
    {
        logger.fatal("Login failed");
        AssertJUnit.fail();

    }
           logger.info("Finshed TC002Login");

}


}
