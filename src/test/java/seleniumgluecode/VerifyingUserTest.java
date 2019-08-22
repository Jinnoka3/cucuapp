package seleniumgluecode;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerifyingUserTest extends Base {

    @Then("user navigates to personal information page")
    public void user_navigates_to_personal_information_page() {

        driver.findElement(By.xpath("//span[contains(text(),'My personal information')]")).click();
    }

    @And("user verify that personal information is expected")
    public void user_verify_that_personal_information_is_expected() {

        String wfirstname = driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value").
                concat(driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value")).
                concat(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"));

        System.out.println("ext = " + extendedUser + "\nreal = " + wfirstname);
        Assert.assertTrue(extendedUser.equals(wfirstname));
        driver.quit();
    }
}