package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;

    final By LOGIN = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
    final By EMAIL_FIELD = By.xpath("//*[@id=\"email_create\"]");

    final By FIRST_NAME = By.xpath("//*[@id=\"customer_firstname\"]");
    final By LAST_NAME = By.xpath("//*[@id=\"customer_lastname\"]");
    final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");
    final By ADDRESS = By.id("address1");
    final By CITY = By.id("city");
    final By STATE = By.id("uniform-id_state");
    final By SELECTED_STATE = By.xpath("//*[@id=\"id_state\"]/option[46]");
    final By POSTCODE = By.id("postcode");
    final By MOBILE_PHONE = By.id("phone_mobile");


    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String fillOutRegistrationForm(String fname, String lname, String pword, String address, String city, String pcode, String phone){

        wait.until(ExpectedConditions.elementToBeClickable((LOGIN))).click();

        wait.until(ExpectedConditions.elementToBeClickable((EMAIL_FIELD))).click();
        driver.findElement(EMAIL_FIELD).sendKeys(EmailGenerator.getSaltString() + "@gmail.com");
        driver.findElement(EMAIL_FIELD).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable((FIRST_NAME))).click();
        driver.findElement(FIRST_NAME).sendKeys(fname);

        wait.until(ExpectedConditions.elementToBeClickable((LAST_NAME))).click();
        driver.findElement(LAST_NAME).sendKeys(lname);

        wait.until(ExpectedConditions.elementToBeClickable((PASSWORD))).click();
        driver.findElement(PASSWORD).sendKeys(pword);

        wait.until(ExpectedConditions.elementToBeClickable((ADDRESS))).click();
        driver.findElement(ADDRESS).sendKeys(address);

        wait.until(ExpectedConditions.elementToBeClickable((CITY))).click();
        driver.findElement(CITY).sendKeys(city);

        wait.until(ExpectedConditions.elementToBeClickable((STATE))).click();
        driver.findElement(SELECTED_STATE).click();

        wait.until(ExpectedConditions.elementToBeClickable((POSTCODE))).click();
        driver.findElement(POSTCODE).sendKeys(pcode);

        wait.until(ExpectedConditions.elementToBeClickable((MOBILE_PHONE))).click();
        driver.findElement(MOBILE_PHONE).sendKeys(phone);
        driver.findElement(MOBILE_PHONE).sendKeys(Keys.ENTER);

        String result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();

        return result;
    }
}
