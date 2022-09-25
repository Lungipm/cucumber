package StepDefinations;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class sauceDemoEndToEnd {

    WebDriver driver = null;


    @Given("browser is opened")
    public void browser_is_opened() {

        //chrome.equalsIgnoreCase(browserChoice);// find out how to ignore cases
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @And("user is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        sleep(20);
    }

    @And("user enters username")
    public void user_enters_username() {
        driver.findElement(By.id("user-name")).sendKeys();
    }

    @And("user enters password")
    public void user_enters_password() throws InterruptedException {
        driver.findElement(By.id("password")).sendKeys();
        sleep(20);
    }

    @When("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).sendKeys();
    }

    @Then("login is success")
    public void login_is_success() {

        WebElement xpath_successLogin = driver.findElement(By.xpath("//span[contains(.,'Products')]"));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(xpath_successLogin));
        Assert.assertEquals(xpath_successLogin.getText(), "Products");
        System.out.println("You are successfully Logged in");
    }

    //Add next test steps

    @Given("user is in the product page")
    public void user_is_in_the_product_page() {

        WebElement xpath_successLogin = driver.findElement(By.xpath("//span[contains(.,'Products')]"));
        Assert.assertEquals(xpath_successLogin.getText(), "Products");
        System.out.println("You are in the main Page");
    }

    @When("the user add product labs-backpack")
    public void the_user_add_product_labs_backpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("the product is added to cart")
    public void the_product_is_added_to_cart() {
        WebElement xpath_addSuccess = driver.findElement(By.id("remove-sauce-labs-backpack"));
        Assert.assertTrue(xpath_addSuccess.isDisplayed());
        System.out.println("Product is Successfully added");
    }

}
