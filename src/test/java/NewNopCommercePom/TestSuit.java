package NewNopCommercePom;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    Homepage homePage = new Homepage();
    RegistrationPage registrationPage = new RegistrationPage();
    ProductListPage productListPage =new ProductListPage();


@Test
    public void useRegistration()
{
    homePage.clickOnRegisterButton();
    System.out.println("TestSuit");
    registrationPage.userShouldBeRegisterSuccessfully();
    homePage.clickOnRegisterButton();
    productListPage.priceCurrency();
    productListPage.priceHighToLow();

    }

}
