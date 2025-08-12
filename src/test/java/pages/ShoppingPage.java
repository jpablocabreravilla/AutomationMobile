package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ShoppingPage extends BasePage {
    private final By title = AppiumBy.androidUIAutomator("text(\"PRODUCTS\")");
    private final By filterButton = AppiumBy.accessibilityId("test-Modal Selector Button");
    private final By toggleViewButton = AppiumBy.accessibilityId("test-Toggle");
    private final By itemList = AppiumBy.accessibilityId("test-PRODUCTS");
    private final By imageList = AppiumBy.androidUIAutomator(
            "description(\"test-Item\").childSelector(className(\"android.widget.ImageView\"))");

    @Override
    @Step("Esperando que la pagina de Shopping cargue")
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la pagina de Shopping")
    public void verifyPage() {
        Logs.info("Verificando la pagina de Shopping");
        softAssert.assertTrue(find(title).isDisplayed());
        softAssert.assertTrue(find(filterButton).isDisplayed());
        softAssert.assertTrue(find(toggleViewButton).isDisplayed());
        softAssert.assertTrue(find(itemList).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Haciendo click en la imagen del item segun su index")
    public void clickItemImage(int index) {
        Logs.info("Haciendo click en la imagen del item segun su index");
        findAll(imageList).get(index).click();
    }

}