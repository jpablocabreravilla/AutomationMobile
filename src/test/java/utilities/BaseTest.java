package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {
    protected final String regression = "regression";
    protected final String smoke = "smoke";
    protected final CommonFlows commonFlows = new CommonFlows();
    private final DriveManager driverManager = new DriveManager();

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        driverManager.buildDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        driverManager.killDriver();
    }

}
