package org.Pages;

import org.Utility.PageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage_POF extends BasePage_POF {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='Admin']//parent::a")
    WebElement adminLinkWebEl;

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']//parent::button")
    WebElement addUserRoleBtnWebEl;

    @FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    WebElement userRoleDropDownWebEl;

    @FindBy(xpath = "//input[contains(@placeholder,'Type for hint')]")
    WebElement employeeNameWebEl;




    @FindBy(xpath = "(//div[text()='-- Select --'])[2]")
    WebElement statusDropDownWebEl;

    public AdminPage_POF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAdminLink() {
        adminLinkWebEl.click();
    }

    public void addUserRole(String role , String status) {
        addUserRoleBtnWebEl.click();
        PageFunctions.waitTillElementVisible(userRoleDropDownWebEl);

        userRoleDropDownWebEl.click();

        WebElement roleWebEl = driver.findElement(By.xpath("//span[text()='" + role + "']"));
        System.out.println("Role WebElement Name "+roleWebEl.getText());
        PageFunctions.moveToWebElement(driver,roleWebEl);
        roleWebEl.click();

        employeeNameWebEl.clear();
        employeeNameWebEl.sendKeys("Florencio  Jacobson");

        WebElement statusWebEl = driver.findElement(By.xpath("//span[text()='"+status+"']"));
        PageFunctions.moveToWebElement(driver,statusWebEl);
        statusWebEl.click();



    }


}
