package org.Utility;

import org.Pages.BasePage_POF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class PageFunctions extends BasePage_POF {

    static FileInputStream inputStream;
    static Properties properties;
    static WebDriver driver;

    public static Properties readPropertyFile() {
        try {
            inputStream = new FileInputStream("src/main/java/org/Property/Config.properties");
            properties = new Properties();
            properties.load(inputStream);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return properties;
    }

    public static void waitTillElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void moveToWebElement(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }




}
