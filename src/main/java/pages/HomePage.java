package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By DRESSES = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    private final By FIRST_DRESS = By.xpath("//*[@id=\"center_column\"]/ul//li[1]/div/div/div/a[1]");
    private final By ADD_TO_CART = By.xpath("//*[@id=\"add_to_cart\"]/button");
    private final By CHECKOUT = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
    private final By DELETE = By.xpath("//*[@id=\"3_13_0_0\"]");
    private final By MESSAGE = By.xpath("/html/body/div/div[2]/div/div[3]/div/p");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickDresses(){
        wait.until(ExpectedConditions.elementToBeClickable((DRESSES))).click();
    }
    public void clickProduct(){
        String link = driver.findElement(FIRST_DRESS).getAttribute("href");
        driver.get(link);
        //wait.until(ExpectedConditions.elementToBeClickable((FIRST_DRESS))).click();
    }
    public void clickCart(){
        driver.findElement(ADD_TO_CART).click();
      //  wait.until(ExpectedConditions.elementToBeClickable((ADD_TO_CART))).click();
    }
    public void clickCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable((CHECKOUT))).click();
    }
    public void clickDelete(){
        String link= driver.findElement(DELETE).getAttribute("href");
        driver.get(link);

//        wait.until(ExpectedConditions.elementToBeClickable((DELETE))).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getMessage(){
        String result = driver.findElement(MESSAGE).getText();
        return result;
    }
}
