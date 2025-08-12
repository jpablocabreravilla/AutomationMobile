package saucedemoTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShoppingPage;
import pages.TopBar;
import pages.YourCartPage;
import utilities.BaseTest;

import java.util.List;

public class YourCartTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final TopBar topBar = new TopBar();
    private final YourCartPage yourCartPage = new YourCartPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage.waitPageToLoad();
        loginPage.fillData( "standard_user",  "secret_sauce");
        shoppingPage.waitPageToLoad();
        shoppingPage.changeViewMode();
        shoppingPage.addToCartDrag(List.of(1, 2));
        topBar.clickCheckout();
        yourCartPage.waitPageToLoad();
    }

    @Test(groups = {regression})
    public void deleteSwipeTest() {
        yourCartPage.deleteItemFromList( 0);
        topBar.verifyItemCount( 1);
    }
}
