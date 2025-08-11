package utilities;

import io.appium.java_client.android.AndroidDriver;
import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {

    protected SoftAssert softAssert;
    protected final String regression = "regression";
    protected final String smoke = "smoke";
    protected AndroidDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        softAssert = new SoftAssert();

        Logs.debug("Inicializando el driver");
        driver = initDriver();

        Logs.debug("Asignando el implicit wait");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Logs.debug("Asignando el driver al driver provider");
        new DriverProvider().set(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        Logs.debug("Matando al driver");
        driver.quit();
    }

    private static AndroidDriver initDriver() {
        try {
            final var appiumUrl = "http://127.0.0.1:4723/";
            final var desiredCapabilities = getDesiredCapabilities();

            Logs.debug("Inicializando el driver");
            return new AndroidDriver(new URL(appiumUrl), desiredCapabilities);
        } catch (MalformedURLException malformedURLException) {
            Logs.error("Error al inicializar el driver: %s", malformedURLException.getLocalizedMessage());
            throw new RuntimeException();
        }
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        final var desiredCapabilities = new DesiredCapabilities();
        final var fileAPK = new File("src/test/resources/apk/sauceLabs.apk");

        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
        desiredCapabilities.setCapability("appium:appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        desiredCapabilities.setCapability("appium:platformName", "android");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:app", fileAPK.getAbsolutePath());

        return desiredCapabilities;
    }

    protected void sleep(int timeSeconds) {
        try {
            Thread.sleep(timeSeconds);
        } catch (InterruptedException interruptedException) {
            Logs.error("InterruptedException: %s", interruptedException);
        }
    }

}
