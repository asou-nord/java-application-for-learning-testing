package com.asking.api_produit.tests;

import com.asking.api_produit.base.BaseTest;
import com.asking.api_produit.pages.DashboardPage;
import com.asking.api_produit.pages.LandingPage;
import com.asking.api_produit.pages.LoginPage;
import com.asking.api_produit.pages.LogoutConfirmationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void loginTest(){
        driver.get("http://localhost:" + port + "/");

        // accessing the landing page:
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickLogin();

        // that directs us toward the login page:
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("ali@gmail.com");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();

        // are we really logged in?
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertNotNull(currentUrl);
        Assertions.assertTrue(currentUrl.contains("/listeSansCon"),
                "We are not logged in" + currentUrl);
    }

    @Test
    public void logoutTest(){
//        loginTest(); // don't do this, this is antipattern design.
        driver.get("http://localhost:" + port + "/");

        new LandingPage(driver).clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail("ali@gmail.com");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();

        // If logged in, we are in the dashboard page:
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMenuButton();
        dashboardPage.clickLogoutLink();

        // then we are in the confirmation page:
        LogoutConfirmationPage logoutConfirmationPage = new LogoutConfirmationPage(driver);
        logoutConfirmationPage.clickLogoutButton();

        // after pressing the logout button we expect returning to the landing page:
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertNotNull(currentUrl);
        boolean isBackAtLogin = currentUrl.equals("http://localhost:" + port + "/");
        Assertions.assertTrue(isBackAtLogin,
                "Did not return to landing page. Current URL: " + currentUrl);
    }
}
