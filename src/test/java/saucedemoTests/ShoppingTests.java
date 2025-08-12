package saucedemoTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ShoppingPage;
import pages.TopBar;
import utilities.BaseTest;

import java.util.List;

public class ShoppingTests extends BaseTest {
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final TopBar topBar = new TopBar();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToShoppingPage();
    }

    @Test(groups = {regression, smoke})
    public void verifyUITest() {
        shoppingPage.verifyPage();
    }

    @Test(groups = {regression})
    public void dragDropItemCartTest() {
        shoppingPage.changeViewMode();
        shoppingPage.addToCartDrag(List.of(1, 2, 3));
        topBar.verifyItemCount(3);
    }
}
