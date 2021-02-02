package com.deko.tests.RetailFinance;

import com.deko.testing.robot.backoffice.BackofficeRobot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BackofficeLoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void testTearDown(){
        driver.close();
    }

    @AfterSuite
    public void suiteTearDown(){
        driver.quit();
    }

    @Test(priority=0)
    public void backOfficeLoginPageLoadSuccess(){
        BackofficeRobot robot = new BackofficeRobot(driver);
        robot
                .openBackofficeLoginPage()
                .verifyBackofficeUrl();

        Assert.assertTrue(robot.verifyBackofficeUrl());
    }

    //todo: Write the rest of the tests for the backoffice login page here.
    //todo: Chrome driver should spin up, pass all tests identified (unless you find a bug?) and quit.


    //Postive Test.

    @Test(priority=1)
    public void backOfficeLoginPageSuccess(){

        BackofficeRobot robot = new BackofficeRobot(driver);
        robot
                //open login page
                .openBackofficeLoginPage()
                //enter valid username
                .fillLoginUsername("Derek.Husbands")
                //enter valid password
                .fillLoginPassword("DekoQA2020")
                //submit login
                .submitLoginForm();

        //Check user has been logged in Successfully
        Assert.assertTrue(robot.verifySuccessfulLogin());
    }

    //Negative Tests
    @Test(priority=2)
    public void backOfficeLoginPageInvalidUsername(){

        BackofficeRobot robot = new BackofficeRobot(driver);
        robot
                //open login page
                .openBackofficeLoginPage()
                //enter invalid username
                .fillLoginUsername("Derek.Husband")
                //enter valid password
                .fillLoginPassword("DekoQA2020")
                //submit login
                .submitLoginForm();

        //Check Error Message is displayed
        Assert.assertTrue(robot.verifySignInError());

    }

    @Test(priority=3)
    public void backOfficeLoginPageInvalidPassword(){

        BackofficeRobot robot = new BackofficeRobot(driver);
        robot
                //open login page
                .openBackofficeLoginPage()
                //enter valid username
                .fillLoginUsername("Derek.Husbands")
                //enter ivalid password
                .fillLoginPassword("DekoQA202")
                //submit login
                .submitLoginForm();

        //Check Error Message is displayed
        Assert.assertTrue(robot.verifySignInError());

    }

    //Additional Tests

    //Reset Password route check
    //Password Policy Checks
    //Remember me route check
    //Styling Checks
    //Logout Check
    //Styling Checks (Cross browser /Device)


}



