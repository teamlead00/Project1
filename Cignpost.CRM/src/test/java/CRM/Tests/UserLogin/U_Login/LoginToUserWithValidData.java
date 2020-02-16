package CRM.Tests.UserLogin.U_Login;

import CRM.Modules.LoginOut;
import CRM.Utils.TestBase;
import CRM.Utils.WaitTool;
import org.testng.annotations.Test;

import static CRM.Utils.Common.assertText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginToUserWithValidData extends TestBase {
    LoginOut objLoginOut = new LoginOut();
    WaitTool objWait = new WaitTool();

    @Test(description = "M_Login with valid user", groups = {"M_Login"})
    public void loginToCignpostCRM() throws Exception {
        //logTestStep("Log in screen of the application");
        objLoginOut.loginAs(LoginOut.Actor.USERNAME_USERS);
        System.out.println("User Logged in successfully!!!");
        sleep(3000);
        String Successfulmessage = $x("//div[@class='toast-message ng-star-inserted']").getText();
        assertText(Successfulmessage, "M_Login successful");
        objLoginOut.logout();
        System.out.println("User Logged out successfully!!!");
        String message = $x("//div[@class='toast-message ng-star-inserted']").getText();
        assertText(message, "Logout successful");

    }

}
