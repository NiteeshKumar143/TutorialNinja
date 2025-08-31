package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

import org.testng.AssertJUnit;

import org.testng.annotations.DataProvider;

import java.io.IOException;

//import static org.apache.poi.sl.draw.geom.GuideIf.Op.val;

public class TC_003_LoginDDT extends BaseClass
{
    @Test(dataProvider="LoginData")
    public void test_LoginDDT(String email,String pwd,String exp)
    {
        logger.info(" Starting TC_003_LoginDDT ");

        try
        {
            driver.get(rb.getString("appurl"));
            logger.info("Home Page Displayed ");


            HomePage hp=new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account ");
            hp.clickLogin();
            logger.info("Clicked on Login ");

            LoginPage lp=new LoginPage(driver);
            System.out.println("Running test with: " + email + " | " + pwd + " | " + exp);
            lp.setEmail(email);
            logger.info("Provided Email ");

            lp.setPassword(pwd);
            logger.info("Provided Password ");

            lp.clicktoLogin();
            logger.info("Clicked on Login");


            boolean targetpage=lp.isMyAccountPageExists();

            if(exp.equals("Valid"))
            {
                if(targetpage==true)
                {
                    logger.info("Login Success ");

                    hp.clickMyAccount();
                    lp.logoutb();
                    AssertJUnit.assertTrue(true);
                }
                else
                {
                    logger.error("Login Failed ");
                    AssertJUnit.assertTrue(false);
                }
            }

            if(exp.equals("Invalid"))
            {
                if(targetpage==true)
                {
                    hp.clickMyAccount();
                	lp.logoutb();
                    AssertJUnit.assertTrue(false);
                }
                else
                {
                    logger.error("Login Failed ");
                    AssertJUnit.assertTrue(true);
                }
            }


        }catch(Exception e)
        {
            logger.fatal("Login Failed ");
            AssertJUnit.fail();
        }

        logger.info(" Finished TC_003_LoginDDT ");

    }


   @DataProvider(name="LoginData")
    public String [][] getData() throws IOException
    {
	   String path = System.getProperty("user.dir") + "/testData/Opencart_LoginData.xlsx";

       XLUtility xlutil=new XLUtility(path);

       int totalrows = xlutil.getRowCount("login");
       int totalcols = xlutil.getCellCount("login", 1); // Assuming row 1 has data
       System.out.println("Total rows: " + (totalrows));
       System.out.println("Total cols: " + totalcols);
       String contactdata[][] = new String[totalrows][totalcols]; // skip header

       for (int i = 1; i<= totalrows; i++)
       { // start from 1
           for (int j = 0; j < totalcols; j++)
           {
           	    String val = xlutil.getCellData("login", i, j);
                System.out.println("Reading login[" + i + "][" + j + "] = " + val);
                contactdata[i - 1][j] = val.trim();// offset by -1

           }
       }
        return contactdata;

   }
}
