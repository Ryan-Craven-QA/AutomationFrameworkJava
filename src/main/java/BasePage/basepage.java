package BasePage;

import io.cucumber.core.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class basepage<V> {

    public static WebDriver driver = null;
    public static Properties prop = new Properties();

    public basepage() {
        try {
            prop.load(new FileInputStream("./src/test/config/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return this.getDriver();
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setUpDriver() throws MalformedURLException {
        String browser = prop.getProperty("browser");
        if (browser == null) {
            browser = "chromeLocal";
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        switch (browser) {
            case "chromeLocal":

                System.setProperty("webdriver.chrome.driver", "./src/main/java/drivers/chromedriver.exe");
                chromeOptions.addArguments("start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "chromeVM":
                System.setProperty("webdriver.chrome.driver", "./src/main/java/drivers/chromedriver.exe");
                chromeOptions.addArguments("start-maximized");
                driver = new RemoteWebDriver(new URL(prop.getProperty("ipAddress")), chromeOptions);
                break;
            case "firefoxLocal":
                System.setProperty("webdriver.gecko.driver", "./src/main/java/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }

    public void closeDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            saveScreenshotsForScenario(scenario);
        }
        driver.close();
    }

    private void saveScreenshotsForScenario(final Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    public void waitForPageLoad(int timeout) {
        ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
    }
}