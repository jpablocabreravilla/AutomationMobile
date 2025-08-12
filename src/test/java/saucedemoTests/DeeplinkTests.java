package saucedemoTests;

import org.testng.annotations.Test;
import pages.ItemDetailPage;
import pages.ShoppingPage;
import pages.TopBar;
import utilities.BaseTest;
import utilities.DeepLinks;

public class DeeplinkTests extends BaseTest {
    private final ItemDetailPage itemDetailPage = new ItemDetailPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();
    private final TopBar topBar = new TopBar();

    @Test(groups = {regression})
    public void itemDetailDeepLinkTest() {
        DeepLinks.goToItemDetail(4);
        itemDetailPage.waitPageToLoad();
        itemDetailPage.verifyItemInfo("Sauce Labs Onesie", 7.99);
    }

    @Test(groups = {regression})
    public void shoppingDeepLinkTest() {
        DeepLinks.goToShopping("0,2");
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
        topBar.verifyItemCount(2);
    }
}