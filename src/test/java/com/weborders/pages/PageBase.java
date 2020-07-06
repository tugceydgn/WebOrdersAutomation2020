package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(tagName = "h1")
    protected WebElement pageLogo;

    @FindBy(tagName = "h2")
    protected WebElement pageSubtitle;

    public PageBase() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getPageSubtitleText() {
        BrowserUtilities.waitForPageLoad(10);
        return pageSubtitle.getText();
    }

    public String getPageLogoText() {
        return pageLogo.getText();
    }

    /**
     * Specify component name as a parameter, like: View all products or Orders
     *
     * @param component
     */
    public void navigateTo(String component) {
        String locator = "//a[text()='" + component + "']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();

    }


}
