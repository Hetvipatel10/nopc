package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import com.nopcommerce.demo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.Random;

public class RegisterPageTest extends TestBase {
   HomePage homepage ;
  RegisterPage registerPage ;

    @BeforeMethod
    public void inIt(){
        homepage = new HomePage();
        registerPage  = new RegisterPage();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homepage.clickOnRegisterLink();
        String expected = "Register";
        Assert.assertEquals(expected, homepage.VerifyRegisterLink());
    }
    @Test
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(){
        homepage.clickOnRegisterLink();
        registerPage.ClickonRegisterButton();
        String expectedFirstname = "First name is required.";
        Assert.assertEquals(expectedFirstname, registerPage.VerifyFirstnameError());

        String expectedLastname ="Last name is required.";
        Assert.assertEquals(expectedLastname, registerPage.VerifyLastnameError());

        String expectedEmail="Email is required.";
        Assert.assertEquals(expectedEmail, registerPage.VerifyEmailError());

        String expectedPassword="Password is required.";
        Assert.assertEquals(expectedPassword, registerPage.VerifyPasswordError());

        String expectedConfirmPass ="Password is required.";
        Assert.assertEquals(expectedConfirmPass, registerPage.VerifyConfirmPasswordError());
    }
    @Test(dataProvider = "registerdata",dataProviderClass = TestData.class)
    public void  verifyThatUserShouldCreateAccountSuccessfully(String fname,String lname,String day,String month,String year,String email,String password,
    String  conpassword,String message) throws InterruptedException {
        homepage.clickOnRegisterLink();
        registerPage.ClickonFemale();
        registerPage.EnterFirstname(fname);
        registerPage.EnterLastname(lname);
        registerPage.SelectDay(day);
        registerPage.SelectMonth(month);
        registerPage.SelectYear(year);
        Thread.sleep(1000);
        registerPage.EnterEmail(email);
        registerPage.EnterPassword(password);
        registerPage.EnterConfirmPassword(conpassword);
        registerPage.ClickonRegisterButton();
        String expected =message;
        Assert.assertEquals(expected, registerPage.VerifyRegisterSuccessfullMsg());
    }
}

