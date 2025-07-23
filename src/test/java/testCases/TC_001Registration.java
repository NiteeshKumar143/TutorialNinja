package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

import org.testng.AssertJUnit;
import java.io.IOException;



public class TC_001Registration extends BaseClass
{

    @Test
    public void test_Registration() throws IOException {

            logger.info(" Starting TC_001Registration ");

            driver.get(rb.getString("appurl"));


            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickRegister();

            AccountRegistration regpage = new AccountRegistration(driver);
            regpage.setFirstName("John");
            regpage.setLastName("Doe");
            regpage.setEmail("test21@yopmail.com.com");
            regpage.setTxtTelephone("8954430144");
            regpage.setPassword("Nikk@12345");
            regpage.setConfPassword("Nikk@12345");
            regpage.setPrivacyPolicy();
            regpage.clickContinue();


            String confmsg = regpage.getConfirmationMessage();


            System.out.println(confmsg);

            if (confmsg.equals("Your Account Has Been Created!")) {

                AssertJUnit.assertTrue(true);

            } else {
                capturescreen(driver,"test_Registration");
                AssertJUnit.fail();

            }

        }
    }
