package CRM.Locators;

import org.openqa.selenium.By;

public class LoginOutRepo {

    public static By TxtUsername=By.xpath("(//label[contains(text(),'Sign In')]//following::input)[2]");
    public static By TxtPassword=By.xpath("(//label[contains(text(),'Sign In')]//following::input)[3]");
    public static By BtnSIGNIN=By.xpath("//span[contains(text(),'Log In')]");
    public static By NavigationBar=By.xpath("//div[contains(@class,'fa fa-bars')]");
    public static By UatAdmin=By.xpath("//div[@class='account-menu']");
    public static By Logout=By.xpath("//a[contains(text(),'Logout')]");
    public static By memberLogout=By.xpath("(//a[contains(text(),'Logout')])[2]");

}