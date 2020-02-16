package CRM.Tests.UserLogin.U_Login;

import CRM.Locators.DashboardRepo;
import CRM.Modules.LoginOut;
import CRM.Utils.Log;
import CRM.Utils.TestBase;
import CRM.Utils.WaitTool;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginWithInvalidUser extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "M_Login with invalid user", groups = {"M_Login"})
    public void loginWithInvalidUser() throws Exception {
        logTestStep("Log in screen of the application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_InvalidUser);
        sleep(2000);
        String msg = $(DashboardRepo.toaster).getText();
        Log.info("The message is: " + msg);
        Assert.assertEquals(msg, "Invalid username or password");
        System.out.println("User unable to login with invalid credentials!!!");
    }

}
