package CRM.Start;


import CRM.Urls.Urls;
import CRM.Utils.Log;
import CRM.Utils.SelenideLogEvents;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static com.codeborne.selenide.Selenide.open;


/**
 * @author smartData
 * <h1>Initialized Browser</h1>
 * <p>Purpose: This class is used to initialized browser </p>
 * It is used to handle all the functionalities related with AccountTests module
 **/
public class Start {
    public static String currentBrowser = "";
    public static Map<Long, String> browserWindows = new HashMap<>();

    public static WebDriver getDriverInstance() {
        return WebDriverRunner.getWebDriver();
    }
    public static String GetDefaultWindow() {
        return browserWindows.get(Thread.currentThread().getId());
    }

    //This method is used to Save Default browser Window
    public static void SaveDefaultWindow() {
        browserWindows.put(Thread.currentThread().getId(), WebDriverRunner.getWebDriver().getWindowHandle());
    }

    /**
     * <h1>Close all extra window of browser expect Default</h1>
     */
    public synchronized static void CloseExtraWindows() {
        Log.info("Close extra windows and switch back to default window");
        String defaultWindow = GetDefaultWindow();
        for (String win : WebDriverRunner.getWebDriver().getWindowHandles()) {
            if (!win.equals(defaultWindow)) {
                WebDriverRunner.getWebDriver().switchTo().window(win);
                WebDriverRunner.getWebDriver().close();
            }
        }//End for
        WebDriverRunner.getWebDriver().switchTo().window(defaultWindow);
        Log.pass("Switched back to default window");
    }

    /**
     * <h1>Initialize Browser <h1/>
     * <p>Purpose: This method is used to Initialize Browser</p>
     */

    protected static void InitilizeBrowser() throws Exception {
        //Selenide S_Configuration
        WebDriver driver;
        Configuration.fastSetValue = true;
        Configuration.screenshots = false;
        Configuration.startMaximized = true;
      //  S_Configuration.collectionsTimeout = 60000;
        Configuration.timeout = 15000;
    //    S_Configuration.setValueChangeEvent = true;

        if (currentBrowser.equalsIgnoreCase("ChromeHeadfull")) {
            Log.info("Starting Chrome browser");
          //ChromeDriverManager.chromedriver().version("74").setup();
            ChromeDriverManager.chromedriver().setup();
            Configuration.browser = WebDriverRunner.CHROME;
       //     ChromeDriverManager.getInstance().setup();
            ChromeOptions chromeOptions = new ChromeOptions();

            //Disable Notification in chrome
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("download.default_directory", System.getProperty("user.dir"));//
            chromeOptions.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(chromeOptions);
            WebDriverRunner.setWebDriver(driver);

        } else if (currentBrowser.equalsIgnoreCase("ChromeHeadless")) {
            Log.info("Starting Headless Chrome browser");
       //   ChromeDriverManager.chromedriver().version("74").setup();
            ChromeDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("window-size=1366,768");
            driver = new ChromeDriver(chromeOptions);
            WebDriverRunner.setWebDriver(driver);
           /* ChromeDriverManager.chromedriver().version("74").setup();
            Log.info("Starting Chrome browser");
            S_Configuration.browser = WebDriverRunner.CHROME;
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.prompt_for_download", "false");
            chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("window-size=1366,768");
            chromeOptions.setExperimentalOption("prefs", chromePrefs);
            chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            WebDriverRunner.setWebDriver(driver);*/

        } else if (currentBrowser.equalsIgnoreCase("FirefoxHeadless")) {
            Log.info("Starting Headless Firefox browser");
            FirefoxDriverManager.firefoxdriver().setup();
            Configuration.headless =true;
            Configuration.browser = WebDriverRunner.FIREFOX;
           // driver = new FirefoxDriver(dc);
           // WebDriverRunner.setWebDriver(driver);
        } else if (currentBrowser.equalsIgnoreCase("FirefoxHeadfull")) {
            Log.info("Starting Headless Firefox browser");
            FirefoxDriverManager.firefoxdriver().setup();
            Configuration.headless =false;
            Configuration.browser = WebDriverRunner.FIREFOX;
            //driver = new FirefoxDriver(dc);
           // WebDriverRunner.setWebDriver(driver);

        } else if (currentBrowser.equalsIgnoreCase("RunInGrid")) {
            Log.info("Starting Grid browser");
            //If we want to run
            Configuration.browser = WebDriverRunner.CHROME;
            Configuration.remote = "http://172.24.3.181:5555/wd/hub";
        } else {
            //Default browser
            Configuration.browser = WebDriverRunner.CHROME;
        }
        open(Urls.baseUrl);
        SaveDefaultWindow();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        com.codeborne.selenide.logevents.SelenideLogger.addListener("BrowserLogs", new SelenideLogEvents());
    }

    public static void WriteCookiesToFile(String filename) {
        File file;
        try {
            file = new File(filename + ".txt");
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            for (Cookie ck : WebDriverRunner.getWebDriver().manage().getCookies()) {
                Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();

            System.out.println("Write Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//End Write

    public static void ReadCookiesFromFile(String fileName) {
        try {
            File file = new File(fileName + ".txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while ((strline = Buffreader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(strline, ";");
                while (token.hasMoreTokens()) {
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;
                    String val;
                    if (!(val = token.nextToken()).equals("null")) {

                        expiry = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(val);
                        System.out.println("String Token Date:" + val);
                        System.out.println("Date:" + expiry);
                        //expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken());
                    Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                    System.out.println(ck);
                    WebDriverRunner.getWebDriver().manage().addCookie(ck); // This will add the stored cookie to your current session
                }//End while

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}//End class
