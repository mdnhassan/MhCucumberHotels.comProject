package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static Logger LOGGER = LogManager.getLogger(Hooks.class);
    static WebDriver driver = null;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("launch Chrome Browser");
    }

    @After
    public void closeBrowser() {
        driver.quit();
        LOGGER.info("Close Chrome Browser");
    }

}
