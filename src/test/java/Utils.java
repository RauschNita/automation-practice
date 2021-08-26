import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Utils {
    WebDriver driver;

    public WebDriver getDriver() {
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        options.addArguments("--headless");

        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        return driver;
    }

    public WebDriverWait getWebDriverWait(){

        return new WebDriverWait(driver, 10);
    }
    @AfterEach
    public void tearDown() {
        driver.close();
    }
}