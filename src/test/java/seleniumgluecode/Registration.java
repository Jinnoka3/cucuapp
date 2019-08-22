package seleniumgluecode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Registration {

    public static WebDriver driver;

    @Given("user is on homepage")
    public void user_is_on_homepage() throws Throwable {
        //System.setProperty("webdriver.gecko.driver","/Users/Documents/geckodriver");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @When("user navigates to Login Page")
    public void user_navigates_to_Login_Page() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    @When("user signs up")
    public void user_signs_up() {

        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("galinaprokofevna99@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();

        By.xpath(".//input[@id='id_gender2']").findElement(driver).click();

        By.name("customer_firstname").findElement(driver).sendKeys("Daria");
        By.xpath("//*[@id=\"customer_lastname\"]").findElement(driver).sendKeys("Kalinina");
        By.xpath("//*[@id=\"passwd\"]").findElement(driver).sendKeys("12345");

        Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        dropdown1.selectByValue("9");

        Select dropdown2 = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        dropdown2.selectByValue("1");

        Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        dropdown3.selectByValue("1996");

        By.id("newsletter").findElement(driver).click();
        By.id("optin").findElement(driver).click();

        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
        By.xpath("//*[@id=\"firstname\"]").findElement(driver).sendKeys("Daria");

        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
        By.xpath("//*[@id=\"lastname\"]").findElement(driver).sendKeys("Kalinina");

        By.xpath("//*[@id=\"company\"]").findElement(driver).sendKeys("Sperasoft");

        By.xpath("//*[@id=\"address1\"]").findElement(driver).sendKeys("Bulvar 30-letiya Pobedi, 111");
        By.xpath("//*[@id=\"address2\"]").findElement(driver).sendKeys("23, 15, 3а");
        By.xpath("//*[@id=\"city\"]").findElement(driver).sendKeys("Volgograd");

        Select dropdown4 = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        dropdown4.selectByValue("32");

        By.xpath("//*[@id=\"postcode\"]").findElement(driver).sendKeys("40013");

        Select dropdown5 = new Select(driver.findElement(By.xpath("//*[@id=\"id_country\"]")));
        dropdown5.selectByValue("21");

        By.id("other").findElement(driver).sendKeys("Hello!");
        By.id("phone").findElement(driver).sendKeys("34-23-56");
        By.id("phone_mobile").findElement(driver).sendKeys("89365748234");


        driver.findElement(By.xpath("//*[@id=\"alias\"]")).clear();
        By.xpath("//*[@id=\"alias\"]").findElement(driver).sendKeys("Address");

        By.xpath("//*[@id=\"submitAccount\"]/span").findElement(driver).click();
    }

    @Then("user is on account page")
    public void success_message_is_displayed() throws Throwable {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]")).isDisplayed());
    }
}
