package org.OrangeHRM;

import org.Pages.AdminPage_POF;
import org.Pages.BasePage_POF;
import org.Pages.Login_POF;
import org.Utility.PageFunctions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddNewUser extends BasePage_POF {
    Login_POF loginPof;
    WebDriver driver;
    AdminPage_POF adminPagePof;

    @BeforeTest
    public void setup() {
        driver = loadBrowser();
        loginPof = new Login_POF(driver);
        loginPof.login(PageFunctions.readPropertyFile().getProperty("USERNAME"), PageFunctions.readPropertyFile().getProperty("PASSWORD"));

    }

    @Test
    public void addUseRole() {
        adminPagePof = new AdminPage_POF(driver);
        adminPagePof.clickOnAdminLink();
        adminPagePof.addUserRole("Admin","Enabled");

    }


    public void cleanUp() {
       // driver.quit();
    }

}
