package com.mesajapp.stepdefinitions.auxiliars;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.mesajapp.stepdefinitions.auxiliars.constants.PATH_CHROME_DRIVER;

public interface iniciarWebDriver {

    default ChromeDriver iniciarWebDriver() {
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }
}
