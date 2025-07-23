package testCases;
import org.testng.annotations.Test;

import pageObjects.ContactUs;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.XLUtility;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import java.io.IOException;

import static org.apache.poi.sl.draw.geom.GuideIf.Op.val;

public class TC_ContactUs extends BaseClass 
{
	
	@Test(dataProvider="ContactUs")
    public void Tc_contactus(String name,String email,String query)
    {
        logger.info(" Starting Tc_contactus ");

        try
        {
            driver.get(rb.getString("appurl"));
            logger.info("Home Page Displayed ");


            HomePage hp=new HomePage(driver);
            hp.contactUs();
            logger.info("Clicked on ContactUs");
            
            ContactUs Contact=new ContactUs(driver);
            
      
            System.out.println("Running test with: " + name + " | " + email + " | " + query);
            Contact.setName(name);
            logger.info("Provided Name ");

            Contact.setEmail(email);
            logger.info("Provided Email ");

            Contact.setQuery(query);
            logger.info("Enter quert text");
            
            Contact.clicktoSubmit();


            boolean heading=Contact.isSucess();

                if(heading==true)
                {
                	logger.error("Query sent sucessfully to admin !!");
                	
                    AssertJUnit.assertTrue(true);
                }
                else
                {
                    logger.error("Unable to sent contact query ");
                    AssertJUnit.assertTrue(false);
                }
            


        }catch(Exception e)
        {
            logger.fatal("TC_ContactUs Failed ");
            AssertJUnit.fail();
        }

        logger.info(" TC_ContactUs Finished  ");

    }


   @DataProvider(name="ContactUs")
    public String [][] getData() throws IOException
    {
        String path = System.getProperty("user.dir") + "/testData/Opencart_LoginData.xlsx";

        XLUtility xlutil=new XLUtility(path);

        int totalrows = xlutil.getRowCount("Sheet2");
        int totalcols = xlutil.getCellCount("Sheet2", 1); // Assuming row 1 has data
        if (totalcols > 3) totalcols = 3;
        System.out.println("Total rows: " + (totalrows));
        System.out.println("Total cols: " + totalcols);
        String logindata[][] = new String[totalrows][totalcols]; // skip header

        for (int i = 1; i<= totalrows; i++)
        { // start from 1
            for (int j = 0; j < totalcols; j++)
            {
                System.out.println("Reading Sheet2[" + i + "][" + j + "] = " + val);
                String val = xlutil.getCellData("Sheet2", i, j);
                logindata[i - 1][j] = xlutil.getCellData("Sheet2", i, j).trim(); // offset by -1

            }
        }
         return logindata;

    }
}
	


