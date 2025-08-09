package listeners;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import utilities.DriverProvider;
import utilities.FileManager;
import utilities.Logs;

import java.io.File;

public class AllureListeners implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        Logs.debug("Tomando evidencias para allure");

        final var status = result.getStatus();

        switch (status) {
            case BROKEN, FAILED -> {
                // si no es null, tomamos evidencias
                if (new DriverProvider().get() != null) {
                    FileManager.getScreenshot();
                    FileManager.getPageSource();
                }
            }
        }
    }
}