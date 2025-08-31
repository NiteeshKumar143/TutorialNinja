package testCases;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AddresBook;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class AddressBookTest extends BaseClass{
	
	@BeforeMethod
	public void logintoApp() throws InterruptedException
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
	        
	      
	        }
	    catch (Exception e)
	    {
	        logger.fatal("Login failed");
	        AssertJUnit.fail();

	    }
	           logger.info("Finshed testaddress");
	}
	
          
	   @Test(priority=1, dataProvider="AddressData") 
	   public void enterAddress(String fname,String lname,String copny,String add1, String add2,String city,String postcode) throws InterruptedException, IOException
	   {      
			   AddresBook adb=new AddresBook(driver);   
		
			   
			   adb.clickOnAddressbook();
			   
			   adb.clickOnNewAdd();
			   
			   adb.setName(fname);
			   adb.setLname(lname);
			   adb.setCompany(copny);   
			   
			   adb.setAddress(add1);
			   adb.setAddress2(add2);
			   
			   adb.setCity(city);
               adb.setPostalCode(postcode);			  
			   
			   adb.SelectCountry("99");
			   
			   adb.SelectState("1505");
			   
			   adb.clickOnContinue();
			   
			   
			   String sucessm = adb.sucessadd();



	            if (sucessm.equals("Your address has been successfully added")) 
	            {

	                AssertJUnit.assertTrue(true);
	                
	                System.out.println(sucessm);
	                
	                adb.wait(2000);
	                adb.clickOnAddressbook();
	                

	            } 
	            else 
	            {
	                capturescreen(driver,"AddressBookTest");
	                AssertJUnit.fail();

	            }
			   
		
	}
	
	   @DataProvider(name="AddressData")
	    public String [][] getData() throws IOException
	    {
	        String path = System.getProperty("user.dir") + "/testData/Opencart_LoginData.xlsx";

	        XLUtility xlutil=new XLUtility(path);

	        int totalrows = xlutil.getRowCount("address");
	        int totalcols = xlutil.getCellCount("address", 1); // Assuming row 1 has data
	       
	        System.out.println("Total rows: " + (totalrows));
	        System.out.println("Total cols: " + totalcols);
	        String addressdata[][] = new String[totalrows][totalcols]; // skip header

	        for (int i = 1; i<= totalrows; i++)
	        { // start from 1
	            for (int j = 0; j < totalcols; j++)
	            {
	            	 String val = xlutil.getCellData("address", i, j);
	                 System.out.println("Reading address[" + i + "][" + j + "] = " + val);
	                 addressdata[i - 1][j] = val.trim();

	            }
	        }
	         return addressdata;

	    }

	
	
}
