package utilities;

import pages.*;

import java.util.List;

public class CommonFlows {
    public void goToLoginPage() {
        new LoginPage().waitPageToLoad();
    }

    public void goToShoppingPage() {
        goToLoginPage();
        new LoginPage().fillData("standard_user", "secret_sauce");
        new ShoppingPage().waitPageToLoad();
    }

    public void openBurgerMenu() {
        goToShoppingPage();
        new TopBar().openBurgerMenu();
        new BurgerMenu().waitPageToLoad();
    }

    public void goToYourCartPage(List<Integer> itemListAdd) {
        goToShoppingPage();
        final var shoppingPage = new ShoppingPage();
        shoppingPage.changeViewMode();
        shoppingPage.addToCartDrag(itemListAdd);
        new TopBar().clickCheckout();
        new YourCartPage().waitPageToLoad();
    }

    public void goToItemDetailPage(int index) {
        goToShoppingPage();
        new ShoppingPage().clickItemImage(index);
        new ItemDetailPage().waitPageToLoad();
    }

}
