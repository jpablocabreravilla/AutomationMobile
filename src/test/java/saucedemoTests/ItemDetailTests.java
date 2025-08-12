package saucedemoTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShoppingPage;
import pages.ItemDetailPage;
import utilities.BaseTest;

public class ItemDetailTests extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final ItemDetailPage itemDetailPage = new ItemDetailPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage.waitPageToLoad();
        loginPage.fillData("standard_user", "secret_sauce");
        shoppingPage.waitPageToLoad();
        shoppingPage.clickItemImage(0);
        itemDetailPage.waitPageToLoad();
    }

    @Test(groups = {regression, smoke})
    public void verifyUITest() {
        itemDetailPage.verifyPage();
    }

    @Test(groups = {regression})
    public void backProductsTest() {
        itemDetailPage.clickBackProducts();
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }

    @Test(groups = {regression})
    public void pressBackTest() {
        itemDetailPage.pressBack();
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }
}