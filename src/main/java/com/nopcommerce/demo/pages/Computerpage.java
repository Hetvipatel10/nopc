package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Computerpage extends Utility {
    private static final Logger log = LogManager.getLogger(Computerpage.class.getName());

    public Computerpage(){
        PageFactory.initElements(driver,this);
    }

    @CacheLookup

    @FindBy(linkText = "Computers")
    WebElement Computers;
    @FindBy(linkText = "Desktops")
    WebElement Desktops;
    @FindBy(linkText = "Notebooks")
    WebElement Notebooks;
    @FindBy(linkText = "Software")
    WebElement Software;

    public void Computers() {
        clickOnElement(Computers);
        log.info("Clicking on Computers " + Computers.toString());

    }
    public  void Desktops(){
        clickOnElement(Desktops);
       log.info("clicking on Desktops"+ Desktops.toString());

    }
    public void Notebooks(){
        clickOnElement(Notebooks);
        log.info("clicking on Notebooks"+Notebooks.toString());

    }
    public void Software(){
        clickOnElement(Software);
        log.info("clicking on Software"+Software.toString());

    }
    public String VerifyDesktoplink(){
        return getTextFromElement(Desktops);
    }




}

