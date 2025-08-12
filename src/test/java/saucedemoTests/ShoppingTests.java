package saucedemoTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShoppingPage;
import utilities.BaseTest;

public class ShoppingTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage.waitPageToLoad();
        loginPage.fillData("standard_user", "secret_sauce");
        shoppingPage.waitPageToLoad();
    }

    @Test(groups = {regression, smoke})
    public void verifyUITest() {
        shoppingPage.verifyPage();
    }
}
