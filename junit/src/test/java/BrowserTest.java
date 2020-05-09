import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class BrowserTest {
    private WebDriver driver;
    private WebdriverFactory factory = new WebdriverFactory();
    private Logger logger = LogManager.getLogger(BrowserTest.class);
    String browser = System.getProperty("browser");
    String options = System.getProperty("options");


    @Before
    public void setupDriver() {

        if (options == null) {
            driver = factory.create(browser);
        } else {
            driver = factory.create(browser, options);
        }
        logger.info(browser + " Driver is setup");
    }

    @Test
    public void openPage() {
        driver.get("https://otus.ru");
        logger.info("Page is open in " + browser + " browser");
    }

    @After
    public void closePage() {
        if (driver != null) {
            driver.quit();
            logger.info(browser + " browser is closed");
        }
    }
}
