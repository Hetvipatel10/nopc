package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class ComputerPageTest extends TestBase {

    HomePage homePage;
   Computerpage computerPage;
    DesktopPage desktopPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod
    public void inIt(){
       homePage = new HomePage();
        computerPage=new Computerpage();
        desktopPage = new DesktopPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }


    @Test
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        homePage.clickOnComputers();
        String expected="Computers";
        Assert.assertEquals(expected, homePage.VerifyComputersText());
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.clickOnComputers();
        computerPage.Desktops();
        String expected="Desktops";
        Assert.assertEquals(expected,computerPage.VerifyDesktoplink());
    }
    @Test (dataProvider = "BuildComputer",dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software){
        homePage.clickOnComputers();
        computerPage.Desktops();
        buildYourOwnComputerPage.ClickonProduct();
        buildYourOwnComputerPage.BuildApplication(processor, ram, hdd, os, software);
        buildYourOwnComputerPage.ClickonADdToCart();
        String ExpectValidationmsg="The product has been added to your shopping cart";
        Assert.assertEquals(ExpectValidationmsg, buildYourOwnComputerPage.VerifyValidationMsg());

    }
}
