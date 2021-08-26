import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalInfosPage;

public class DataTest extends LoginTest{

    @Test
    public void dataModifier() {
        login();

        PersonalInfosPage personalPage = new PersonalInfosPage(getDriver(), getWebDriverWait());
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
