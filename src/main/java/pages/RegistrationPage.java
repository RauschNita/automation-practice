package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    WebDriver driver;
    WebDriverWait wait;

    private final By FIRST_NAME = By.xpath("//*[@id=\"customer_firstname\"]");
    private final By LAST_NAME = By.xpath("//*[@id=\"customer_lastname\"]");
    private final By PASSWORD = By.xpath("//*[@id=\"passwd\"]");
    private final By ADDRESS = By.id("address1");
    private final By CITY = By.id("city");
    private final By STATE = By.id("uniform-id_state");
    private final By SELECTED_STATE = By.xpath("//*[@id=\"id_state\"]/option[46]");
    private final By POSTCODE = By.id("postcode");
    private final By MOBILE_PHONE = By.id("phone_mobile");
    private final By REGISTER = By.xpath("//*[@id=\"submitAccount\"]");
    private final By WELCOME_ACCOUNT = By.cssSelector("#center_column > p");

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void setFirstName(String fname){
        driver.findElement(FIRST_NAME).sendKeys(fname);
    }
    public void setLastName(String lname){
        driver.findElement(LAST_NAME).sendKeys(lname);
    }
    public void setPassword(String pword){
        driver.findElement(PASSWORD).sendKeys(pword);
    }
    public void setAddress(String address){
        driver.findElement(ADDRESS).sendKeys(address);
    }
    public void setCity(String city){
        driver.findElement(CITY).sendKeys(city);
    }
    public void setState(){
        wait.until(ExpectedConditions.elementToBeClickable((STATE))).click();
        driver.findElement(SELECTED_STATE).click();
    }
    public void setPostcode(String pcode){
        driver.findElement(POSTCODE).sendKeys(pcode);
    }
    public void setPhone(String phone){
        driver.findElement(MOBILE_PHONE).sendKeys(phone);
    }
    public void clickRegister(){
        driver.findElement(REGISTER).click();
    }
    public String getMessage(){
        String result = driver.findElement(WELCOME_ACCOUNT).getText();
        return result;
    }
}
