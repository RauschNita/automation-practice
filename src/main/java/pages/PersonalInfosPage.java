package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInfosPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By PERSONAL_INFOS = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a");
    private final By MR_RADIO_BUTTON = By.xpath("//*[@id=\"uniform-id_gender1\"]/span");
    private final By MRS_RADIO_BUTTON = By.xpath("//*[@id=\"uniform-id_gender2\"]/span");
    private final By PASSWORD = By.xpath("//*[@id=\"old_passwd\"]");
    private final By MESSAGE = By.xpath("//*[@id=\"center_column\"]/div/p");

    public PersonalInfosPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void navigate(){
        wait.until(ExpectedConditions.elementToBeClickable((PERSONAL_INFOS))).click();
    }
    public void changeRadioSelected(){
        if (wait.until(ExpectedConditions.elementToBeClickable((MR_RADIO_BUTTON))).isSelected()){
            wait.until(ExpectedConditions.elementToBeClickable((MRS_RADIO_BUTTON))).click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable((MR_RADIO_BUTTON))).click();
        }
    }
    public void setPassword(){
        // getWebDriverWait().until(ExpectedConditions.elementToBeClickable((PASSWORD))).click();
        driver.findElement(PASSWORD).sendKeys("Tester");
        driver.findElement(PASSWORD).sendKeys(Keys.ENTER);
    }
    public String getMessage(){
        String result = driver.findElement(MESSAGE).getText();
        return result;
    }
}
