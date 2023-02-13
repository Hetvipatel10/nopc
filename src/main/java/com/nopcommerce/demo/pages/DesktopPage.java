package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopPage extends Utility {

        private static final Logger log = LogManager.getLogger(DesktopPage.class.getName());

        public DesktopPage(){
            PageFactory.initElements(driver,this);
        }

        @CacheLookup

        @FindBy(linkText = "Desktops")
        WebElement Desktops;
        @FindBy(xpath =  "//select[@id='products-orderby']")
        WebElement Sortby;
        @FindBy(linkText = "//span[(text()='Display')]")
        WebElement Display;
        @FindBy(xpath = "//a[@class='viewmode-icon grid selected']")
        WebElement SelectProductList;

        public  void Desktops(){
                clickOnElement(Desktops);
                log.info("clicking on Desktops"+ Desktops.toString());

        }
        public void Sortby(){
                clickOnElement(Sortby);
                log.info("clicking on sort by"+ Sortby.toString());

        }
        public void Display(){
                clickOnElement(Display);
                log.info("clicking on Display"+ Display.toString());

        }
        public void SelectProductList(){
                clickOnElement(SelectProductList);
                log.info("clicking on select product list"+ SelectProductList);

        }


}

