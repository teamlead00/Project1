package CRM.Modules;

import CRM.Locators.DashboardRepo;
import CRM.Locators.LoginOutRepo;
import CRM.TestData.GlobalTestData;
import CRM.Utils.Log;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static CRM.Utils.Common.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * @author smartData
 * <h1>M_Login and Logout </h1>
 * <p>Purpose: This class is used for ProcessForm_SafetyDataSheet and logout form applications</p>
 * It is used to handle ProcessForm_SafetyDataSheet and logout form applications
 **/
public class LoginOut {
    /**
     * <h1>M_Login to Application<h1/>
     * <p>Purpose: This method is used to login to application  </p>
     *
     * @param actor
     * @throws Exception
     */

    public void loginAs(Actor actor) throws Exception {
        switch (actor) {
            case USERNAME_USERS:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.UserName_Users.getUserURL());
                LoginUser(GlobalTestData.UserName_Users.getUserId(), GlobalTestData.UserName_Users.getPassword());
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                Log.info("Logged in as User!!!!");
                break;
            case USERNAME_SuperAdmin:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.SuperAdmin_Users.getUserURL());
                LoginUser(GlobalTestData.SuperAdmin_Users.getUserId(), GlobalTestData.SuperAdmin_Users.getPassword());
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                Log.info("Logged in as Super Admin!!!!");
                break;
            case USERNAME_MemberLogin:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.MemberLogin_Users.getUserURL());
                LoginUser(GlobalTestData.MemberLogin_Users.getUserId(), GlobalTestData.MemberLogin_Users.getPassword());
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                Log.info("Logged in as Member!!!!");
                break;
            case USERNAME_InvalidUser:
                WebDriverRunner.getWebDriver().navigate().to(GlobalTestData.InvalidUser_Users.getUserURL());
                LoginUser(GlobalTestData.InvalidUser_Users.getUserId(), GlobalTestData.InvalidUser_Users.getPassword());
                GlobalTestData.UserNameUrl = GetCurrentUrl();
                break;

            default:
                Assert.assertTrue(false, "Not a valid user type.");
        }
    }

    /**
     * <h1>Logout from Application<h1/>
     * <p>Purpose: This method is used to logout from</p>
     *
     * @throws Exception
     */
   public void logout() {

        Log.info("Logging out the user");
        sleep(2000);
        //$(LoginOutRepo.UatAdmin).click();
        sleep(1000);
        $(LoginOutRepo.Logout).click();
        String toast = $(DashboardRepo.toaster).getText();
        Log.info("The message is: "+toast);
        Assert.assertEquals(toast, "Logout successful");
        Log.info("Logout successful");

    }

    public void login(String username, String password){
        $(LoginOutRepo.TxtUsername).click();
        $(LoginOutRepo.TxtUsername).sendKeys(username);
        Log.info("Entered the username: " + username);
        $(LoginOutRepo.TxtPassword).sendKeys(password);
        Log.info("Entered the password: " + password);
        $(LoginOutRepo.BtnSIGNIN).click();
        sleep(1000);
        String toastMessage = $(DashboardRepo.toaster).getText();
        Log.info("The message is: "+toastMessage);
        //Assert.assertEquals(toastMessage, "Login successful");
    }

    public void memberLogout() {
        Log.info("Logging out the user");
        sleep(2000);
        //$(LoginOutRepo.UatAdmin).click();
        sleep(1000);
        $(LoginOutRepo.memberLogout).click();
        String toast = $(DashboardRepo.toaster).getText();
        Log.info("The message is: "+toast);
        Assert.assertEquals(toast, "Logout successful");
        Log.info("Logout successful");

    }


    /**
     * <h1>Change URL<h1/>
     * <p>Purpose: This method is used to change url</p>
     *
     * @throws Exception
     */
    public void changeUrl() {
        url();
    }

    public static enum Actor {USERNAME_USERS,USERNAME_SuperAdmin,USERNAME_MemberLogin,USERNAME_InvalidUser}

}
