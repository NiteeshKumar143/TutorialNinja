package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.XLUtility;
import org.testng.AssertJUnit;
import static org.apache.poi.sl.draw.geom.GuideIf.Op.val;
import java.io.IOException;
public class TC_001Registration extends BaseClass
{
	@Test(dataProvider="RegData")
    public void testRegData(String fName, String lName, String email,String telePhone,String pwd,String Confpwd)
    {
        logger.info(" Starting TC_001Registration ");

        try
        {
            driver.get(rb.getString("appurl"));
            logger.info("Home Page Displayed ");

            HomePage hp=new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account ");
            hp.clickRegister();
            logger.info("Clicked on Registartion");

            AccountRegistration reg=new AccountRegistration(driver);
           
           reg.setFirstName(fName);
           reg.setLastName(lName);
           reg.setEmail(email);
           reg.setTxtTelephone(telePhone);
           reg.setPassword(pwd);
           reg.setConfPassword(Confpwd);
           
           reg.setPrivacyPolicy();

           reg.clickContinue();
           

     
            logger.info("Clicked on Continue button");

            String sucessm = reg.getConfirmationMessage();
            
            if (sucessm.equals("Your Account Has Been Created!")) 
            {

                AssertJUnit.assertTrue(true);
                System.out.println(sucessm);
                hp.clickMyAccount();
                reg.logoutb();

            } 
            else 
            {
                capturescreen(driver,"TC_001Registration");
                AssertJUnit.fail();

            }
        }
        catch(Exception e)
        {
            logger.fatal("Reg Failed");
            AssertJUnit.fail();
        }
        

        logger.info(" Finished TC_001Registration");
        
        

    }
 
     
       
   @DataProvider(name="RegData")
    public String [][] getData() throws IOException
    {
	   String path = System.getProperty("user.dir") + "/testData/Opencart_LoginData.xlsx";

       XLUtility xlutil=new XLUtility(path);

       int totalrows = xlutil.getRowCount("reg");
       int totalcols = xlutil.getCellCount("reg", 1); // Assuming row 1 has data
       System.out.println("Total rows: " + (totalrows));
       System.out.println("Total cols: " + totalcols);
       String contactdata[][] = new String[totalrows][totalcols]; // skip header

       for (int i = 1; i<= totalrows; i++)
       { // start from 1
           for (int j = 0; j < totalcols; j++)
           {
           	 String val = xlutil.getCellData("reg", i, j);
               System.out.println("Reading reg[" + i + "][" + j + "] = " + val);
                contactdata[i - 1][j] = val.trim();// offset by -1

           }
       }
        return contactdata;

   }
}
