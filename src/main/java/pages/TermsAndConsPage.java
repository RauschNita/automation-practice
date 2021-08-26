package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TermsAndConsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By TERMS_CONS = By.xpath("//*[@id=\"block_various_links_footer\"]/ul/li[6]/a");
    private final By TERMS_AND_CONDITIONS_TEXT = By.cssSelector("#columns .row");

    public TermsAndConsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public List<String> getTandCList(){
        List <String> result = new ArrayList<>();
        List<WebElement> texts = driver.findElements(TERMS_AND_CONDITIONS_TEXT);
        for (WebElement text : texts) {
            result.add(text.getText());
        }
        return result;
    }
    public void navigate(){
        wait.until(ExpectedConditions.elementToBeClickable((TERMS_CONS))).click();
    }
}
