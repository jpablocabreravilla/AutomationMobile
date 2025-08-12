package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.BasePage;
import utilities.Gestures;
import utilities.Logs;

public class ItemDetailPage extends BasePage {

    private final By itemDescription = AppiumBy.xpath(
            "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView");
    private final By itemImage = AppiumBy.androidUIAutomator(
            "description(\"test-Image Container\").childSelector(className(\"android.widget.ImageView\"))");

    private final By canvas = AppiumBy.androidUIAutomator(
            "className(\"android.widget.ScrollView\").description(\"test-Inventory item page\")");
    private final By itemPrice = AppiumBy.accessibilityId("test-Price");
    private final By addCartButton = AppiumBy.accessibilityId("test-ADD TO CART");
    private final By backProductsButton = AppiumBy.accessibilityId("test-BACK TO PRODUCTS");

    private WebElement getTitleElement() {
        return findAll(itemDescription).get(0);
    }

    private WebElement getDescriptionElement() {
        return findAll(itemDescription).get(1);
    }


    @Override
    @Step("Esperando que la pagina del detalle del item cargue")
    public void waitPageToLoad() {
        waitPage(backProductsButton, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina del detalle del item")
    public void verifyPage() {
        Logs.info("Verificando la pagina del detalle del item");

        softAssert.assertTrue(find(backProductsButton).isDisplayed());
        softAssert.assertTrue(find(itemImage).isDisplayed());
        softAssert.assertTrue(find(itemPrice).isDisplayed());
        softAssert.assertTrue(getTitleElement().isDisplayed());
        softAssert.assertTrue(getDescriptionElement().isDisplayed());
        softAssert.assertAll();

        Gestures.swipeVertical(50, 70, 30, find(canvas));
        Assert.assertTrue(find(addCartButton).isDisplayed());
    }

    @Step("Haciendo click en back to products")
    public void clickBackProducts() {
        Logs.info("Haciendo click en back to products");
        find(backProductsButton).click();
    }

    @Step("Verificando la informacion del item")
    public void verifyItemInfo(String itemName, double expectedPrice) {
        Logs.info("Verificando la informacion del item");

        final var priceDollar = find(itemPrice).getText();
        final var priceNoDollar = Double.parseDouble(priceDollar.replace("$", ""));

        softAssert.assertEquals(getTitleElement().getText(), itemName);
        softAssert.assertEquals(priceNoDollar, expectedPrice);
        softAssert.assertAll();
    }

}
