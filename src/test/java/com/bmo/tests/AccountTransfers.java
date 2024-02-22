package com.bmo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AccountTransfers {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void doAccountTransfers() throws Exception{
        String debitCardXpath = "//input[@name = 'username-input']";
        String passwordXpath = "//input[@name = 'password-input']";
        String loginXpath = "//fdc-button[@name = 'login-submit']";
        String payAndTransferXpath = "//button[@id='menuToggle']";
        String accountTransfersXpath = "//a[@aria-label='Transfers between your accounts.']";
        String signOutXpath = "//fdc-header-button[@id='hps-signout']";
        driver.get("https://www.olb-gss-qa56.dev.bmo.com/banking/digital/login");
        driver.findElement(By.xpath(debitCardXpath)).sendKeys("5007660011004754");
        driver.findElement(By.xpath(passwordXpath)).sendKeys("Password1!");
        driver.findElement(By.xpath(loginXpath)).click();
        synchronized (driver) {
            driver.wait(10000);
        }
        driver.findElement(By.xpath(payAndTransferXpath)).click();
        synchronized (driver) {
            driver.wait(5000);
        }
        driver.findElement(By.xpath(accountTransfersXpath)).click();
        synchronized (driver) {
            driver.wait(5000);
        }
        driver.findElement(By.xpath(signOutXpath)).click();
    }

    @Test
    public void returnFromAccountTransfers() throws Exception{
        String debitCardXpath = "//input[@name = 'username-input']";
        String passwordXpath = "//input[@name = 'password-input']";
        String loginXpath = "//fdc-button[@name = 'login-submit']";
        String payAndTransferXpath = "//button[@id='menuToggle']";
        String billPaymentsXpath = "//a[@aria-label='Bill payments']";
        String signOutXpath = "//fdc-header-button[@id='hps-signout']";
        driver.get("https://www.olb-gss-qa56.dev.bmo.com/banking/digital/login");
        driver.findElement(By.xpath(debitCardXpath)).sendKeys("5007660011004754");
        driver.findElement(By.xpath(passwordXpath)).sendKeys("Password1!");
        driver.findElement(By.xpath(loginXpath)).click();
        synchronized (driver) {
            driver.wait(10000);
        }
        driver.findElement(By.xpath(payAndTransferXpath)).click();
        synchronized (driver) {
            driver.wait(10000);
        }
        driver.findElement(By.xpath(billPaymentsXpath)).click();
        synchronized (driver) {
            driver.wait(10000);
        }
        driver.findElement(By.xpath(signOutXpath)).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
