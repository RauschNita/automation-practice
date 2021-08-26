import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalInfosPage;

public class DataTest extends LoginTest{

    @Test
    public void dataModifier() {
        LoginPage loginPage = new LoginPage(getDriver(), getWebDriverWait());
        loginPage.Login("autiteszti1@gmail.com", "Tester");

        PersonalInfosPage personalPage = new PersonalInfosPage(driver, getWebDriverWait());
        personalPage.navigate();
        personalPage.changeRadioSelected();
        personalPage.setPassword();

        String expected = "Your personal information has been successfully updated.";
        Assertions.assertEquals(expected, personalPage.getMessage());
    }

    @Test
    public void getDataDelete() {
        HomePage page = new HomePage(driver, getWebDriverWait());
        page.clickDresses();
        page.clickProduct();
        page.clickCart();
        page.clickCheckout();
        page.clickDelete();

        String expected = "Your shopping cart is empty.";
        Assertions.assertEquals(expected, page.getMessage());

    }
}
