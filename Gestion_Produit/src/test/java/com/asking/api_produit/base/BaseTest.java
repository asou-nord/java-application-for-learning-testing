package com.asking.api_produit.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    @LocalServerPort
    protected int port;

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Options for our driver:
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--disable-extensions");

        driver = new FirefoxDriver(firefoxOptions);

        // We could add a threshold for ending the test on base of time:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown(){
        if (driver != null) {
            driver.get("http://localhost:" + port + "/");

        }
    }
}
