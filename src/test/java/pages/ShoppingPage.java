package pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Gestures;
import utilities.Logs;

import java.util.List;

public class ShoppingPage extends BasePage {
    private final By title = AppiumBy.androidUIAutomator("text(\"PRODUCTS\")");
    private final By filterButton = AppiumBy.accessibilityId("test-Modal Selector Button");
    private final By toggleViewButton = AppiumBy.accessibilityId("test-Toggle");
    private final By dropZone = AppiumBy.accessibilityId("test-Cart drop zone");

    private final By itemList = AppiumBy.accessibilityId("test-PRODUCTS");
    private final By imageList = AppiumBy.androidUIAutomator(
            "description(\"test-Item\").childSelector(className(\"android.widget.ImageView\"))");
    private final By handleList = AppiumBy.accessibilityId("test-Drag Handle");


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

    @Step("Cambiando a modo lista")
    public void changeViewMode() {
        Logs.info("Cambiando a modo lista");
        find(toggleViewButton).click();

        Logs.info("Esperando que se ordene en formato lista");
        sleep(1500);
    }

    @Step("Arrastrando el item hacia la barra para agregar al carrito segun index")
    public void addToCartDrag(List<Integer> listIndex) {
        Logs.info("Arrastrando el item hacia la barra para agregar al carrito segun index");
        final var handleListElements = findAll(handleList);
        final var destinyElement = find(dropZone);

        for (var index : listIndex) {
            final var originElement = handleListElements.get(index);
            Gestures.dragTo(originElement, destinyElement);
        }
    }

}