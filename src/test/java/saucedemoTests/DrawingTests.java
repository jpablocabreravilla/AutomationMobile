package saucedemoTests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Gestures;
import utilities.Logs;

public class DrawingTests extends BaseTest {
    private WebElement canvasElement;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        final var deeplink = "swaglabs://drawing";

        Logs.info("Navegando a la pagina de dibujo usando el deeplink: %s", deeplink);
        driver.get(deeplink);

        canvasElement = driver.findElement(AppiumBy
                .androidUIAutomator("text(\"Signature Pad demo\").childSelector(className(\"android.view.View\"))"));
    }

    @Test
    public void dibujo1Test() {
        Logs.info("Dibujando la linea vertical");
        Gestures.swipeVertical(50, 20, 80, canvasElement);

        Logs.info("Esperando para ver el dibujo");
        sleep(5000);
    }

    @Test
    public void dibujo2Test() {
        Logs.info("Dibujando la linea horizontal");
        Gestures.swipeHorizontal(50, 10, 90, canvasElement);

        Logs.info("Esperando para ver el dibujo");
        sleep(5000);
    }

    @Test
    public void dibujo3Test() {
        Logs.info("Dibujando el símbolo de suma");
        Gestures.swipeVertical(50, 20, 80, canvasElement);
        Gestures.swipeHorizontal(50, 10, 90, canvasElement);

        Logs.info("Esperando para ver el dibujo");
        sleep(5000);
    }

    @Test
    public void dibujo4Test() {
        Logs.info("Dibujando el símbolo de slash");
        Gestures.swipeGeneral(20, 20, 80, 80, canvasElement);

        Logs.info("Esperando para ver el dibujo");
        sleep(5000);
    }

    @Test
    public void dibujo5Test() {
        Logs.info("Dibujando el símbolo de slash invertido");
        Gestures.swipeGeneral(80, 20, 20, 80, canvasElement);

        Logs.info("Esperando para ver el dibujo");
        sleep(5000);
    }

    @Test
    public void dibujo6Test() {
        Logs.info("Dibujando la X");
        Gestures.swipeGeneral(20, 20, 80, 80, canvasElement);
        Gestures.swipeGeneral(80, 20, 20, 80, canvasElement);

        Logs.info("Esperando para ver el dibujo");
        sleep(5000);
    }

    private void sleep(int timeSeconds) {
        try {
            Thread.sleep(timeSeconds);
        } catch (InterruptedException interruptedException) {
            Logs.error("InterruptedException: %s", interruptedException);
        }
    }
}
