package org.Pages;

import org.Utility.PageFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_POF extends BasePage_POF{

    WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameWebEl;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordWebEl;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtnWebEl;

    public Login_POF(WebDriver methodDriver) {
        this.driver = methodDriver;
        PageFactory.initElements(driver,this);
    }

    public void login(String username , String password){
        PageFunctions.waitTillElementVisible(userNameWebEl);

        userNameWebEl.clear();
        userNameWebEl.sendKeys(username);

        passwordWebEl.clear();
        passwordWebEl.sendKeys(password);

        loginBtnWebEl.click();
    }


}
