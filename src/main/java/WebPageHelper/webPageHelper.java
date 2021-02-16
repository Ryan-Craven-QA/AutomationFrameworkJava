package WebPageHelper;

import BasePage.basepage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webPageHelper extends basepage {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    private WebDriverWait wait;

    public void waitTillClickableClick(By locator) {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void waitTillClickable(By locator) throws InterruptedException {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitTillVisible(By locator) {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitTillAllElementsVisible(By locator) {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void checkCheckBox(By locator, Boolean toCheck) {
        if (toCheck) {
            if (!driver.findElement(locator).isSelected()) {
                waitTillClickableClick(locator);
            }
        } else {
            if (driver.findElement(locator).isSelected()) {
                waitTillClickableClick(locator);
            }
        }
    }

    public void waitTilClickableSendKeys(By locator, String keys)
    {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(keys);
    }

    public void waitTilClickableSendKeysEnter(By locator, String keys)
    {
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(keys);
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void refreshPage()
    {
        driver.navigate().refresh();
    }

}
