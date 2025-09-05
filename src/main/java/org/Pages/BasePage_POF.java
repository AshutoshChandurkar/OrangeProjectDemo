package org.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.Utility.PageFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BasePage_POF {
    WebDriver driver;
  public static String browserName;

    public BasePage_POF() {
        browserName = PageFunctions.readPropertyFile().getProperty("BROWSER");
        System.out.println("Browser Name " + browserName);
    }

    public WebDriver loadBrowser() {


        switch (browserName) {
            case "Chrome": {
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");

                driver = new ChromeDriver(chromeOptions);
            }
            case "Edge": {

            }

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();

        driver.get(PageFunctions.readPropertyFile().getProperty("URL"));

        return driver;
    }

}
