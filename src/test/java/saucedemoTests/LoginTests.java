package saucedemoTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShoppingPage;
import utilities.BaseTest;

public class LoginTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        loginPage.waitPageToLoad();
    }

    @Test(groups = {regression, smoke})
    public void blockedCredentialsTest() {
        loginPage.fillData("locked_out_user", "secret_sauce");
        loginPage.verifyErrorMessage("Sorry, this user has been locked out.");
    }

    @Test(groups = {regression, smoke})
    public void verifyUITest() {
        loginPage.verifyPage();
    }

    @Test(groups = {regression})
    public void tapStandardUserTest() {
        loginPage.fillDataTap();
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }

    @Test(groups = {regression})
    public void verifyCredentialsLabelsTest() {
        loginPage.verifyLabels();
    }

}
