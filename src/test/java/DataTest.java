import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalInfosPage;

public class DataTest extends Utils{

    @Test
    public void dataModifier() {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver, getWebDriverWait());
        loginPage.clickSignIn();

        loginPage.fillOutEmailField("autiteszti1@gmail.com");
        loginPage.fillOutPasswordField("Tester");

        PersonalInfosPage personalPage = new PersonalInfosPage(driver, getWebDriverWait());
        personalPage.navigate();
        personalPage.changeRadioSelected();
        personalPage.setPassword();

        String expected = "Your personal information has been successfully updated.";
        Assertions.assertEquals(expected, personalPage.getMessage());
    }

    @Test
    public void dataDelete() {
        HomePage page = new HomePage(getDriver(), getWebDriverWait());
        page.clickDresses();
        page.clickProduct();
        page.clickCart();
        page.clickCheckout();
        page.clickDelete();

        String expected = "Your shopping cart is empty.";
        Assertions.assertEquals(expected, page.getMessage());

    }
}
