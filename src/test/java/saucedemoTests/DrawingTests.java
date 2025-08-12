package saucedemoTests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.*;

import java.time.Duration;

public class DrawingTests extends BaseTest {
    private final By canvasBy = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Signature Pad demo\").childSelector(new UiSelector().className(\"android.view.View\"))"
    );

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        final var deeplink = "swaglabs://drawing";
        Logs.info("Navegando a la pagina de dibujo usando el deeplink: %s", deeplink);

        AndroidDriver driver = new DriverProvider().get();
        driver.get(deeplink);

        // Validar que la pantalla esté lista
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(canvasBy));
    }

    @Test
    public void dibujo1Test() {
        Logs.info("Dibujando la linea vertical");
        Gestures.swipeVertical(50, 20, 80, canvas());
        Logs.info("Esperando para ver el dibujo");
        sleep();
    }

    @Test
    public void dibujo2Test() {
        Logs.info("Dibujando la linea horizontal");
        Gestures.swipeHorizontal(50, 10, 90, canvas());
        Logs.info("Esperando para ver el dibujo");
        sleep();
    }

    @Test
    public void dibujo3Test() {
        Logs.info("Dibujando el símbolo de suma");
        Gestures.swipeVertical(50, 20, 80, canvas());
        Gestures.swipeHorizontal(50, 10, 90, canvas());
        Logs.info("Esperando para ver el dibujo");
        sleep();
    }

    @Test
    public void dibujo4Test() {
        Logs.info("Dibujando el símbolo de slash");
        Gestures.swipeGeneral(20, 20, 80, 80, canvas());
        Logs.info("Esperando para ver el dibujo");
        sleep();
    }

    @Test
    public void dibujo5Test() {
        Logs.info("Dibujando el símbolo de slash invertido");
        Gestures.swipeGeneral(80, 20, 20, 80, canvas());
        Logs.info("Esperando para ver el dibujo");
        sleep();
    }

    @Test
    public void dibujo6Test() {
        Logs.info("Dibujando la X");
        Gestures.swipeGeneral(20, 20, 80, 80, canvas());
        Gestures.swipeGeneral(80, 20, 20, 80, canvas());
        Logs.info("Esperando para ver el dibujo");
        sleep();
    }

    // Re-localiza el canvas de forma estable justo antes de usarlo
    private WebElement canvas() {
        AndroidDriver driver = new DriverProvider().get();
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(canvasBy));
    }

    // Esperar para poder visualizar el trazado
    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException interruptedException) {
            Logs.error("InterruptedException: %s", interruptedException);
        }
    }
}
