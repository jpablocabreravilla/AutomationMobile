package automation;

import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.Logs;

public class PrimerosTests extends BaseTest {

    @Test(groups = regression)
    public void primerTest() {
        Logs.info("Mi primer test");
    }

    @Test(groups = regression)
    public void fallidoTest() {
        Logs.info("Esperando 2 segundos");
        sleep(1);

        Logs.info("forzando error");
        Assert.assertEquals(3, 2);
    }

}
