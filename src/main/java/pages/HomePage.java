package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By DRESSES = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    private final By FIRST_DRESS = By.xpath("//*[@id=\"center_column\"]/ul/li[1]");
    private final By ADD_TO_CART = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]");
    private final By CHECKOUT = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    private final By DELETE = By.xpath("//*[@id=\"3_13_0_0\"]");
    private final By MESSAGE = By.xpath("//*[@id=\"center_column\"]/p");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void clickDresses(){
        wait.until(ExpectedConditions.elementToBeClickable((DRESSES))).click();
    }
    public void clickProduct(){
        wait.until(ExpectedConditions.elementToBeClickable((FIRST_DRESS))).click();
    }
    public void clickCart(){
        wait.until(ExpectedConditions.elementToBeClickable((ADD_TO_CART))).click();
    }
    public void clickCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable((CHECKOUT))).click();
    }
    public void clickDelete(){
        wait.until(ExpectedConditions.elementToBeClickable((DELETE))).click();
    }
    public String getMessage(){
        String result = driver.findElement(MESSAGE).getText();
        return result;
    }
}
