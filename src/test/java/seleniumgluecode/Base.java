package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;

    static String email;
    static String firstname = "Daria";
    static String lastname = "Kalinina";
    static String extendedUser;

    private static String giveNameToNewAccount() {
        DateFormat dateFormat = new SimpleDateFormat("yMdHms");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    //@Given("user is on homepage")
    public static void user_is_on_homepage() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        email = giveNameToNewAccount() + "@gmail.com";
        extendedUser = firstname+lastname+email;
    }
}
    //Given user is on homepage