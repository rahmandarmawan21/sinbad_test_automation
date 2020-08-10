package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.*;

public class transactionOrder {
    WebDriver driver;
    @Given("^Open the Chrome and launch the application \"([^\"]*)\"$")
    public void chormeOpen(String arg1) throws Throwable{
        /*
         * Action for call driver web browser
         */
        System.setProperty("webdriver.chrome.driver","..//sinbad_test_automation//browser//chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(arg1);
        Thread.sleep(500);
    }

    @And("^Click button buy now$")
    public void click_button_buy_now() throws Throwable {
        /*
         * Action for click button buy now on first screen
         */
        driver.findElement(By.linkText("BUY NOW")).click();
        {
            WebElement element = driver.findElement(By.linkText("BUY NOW"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
    }

    @And("^Click button checkout continue$")
    public void click_button_checkout_continue() throws Throwable {
        /*
         * Action for click button checkout
         */
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".cart-checkout")).click();
        driver.switchTo().frame(0);
        Thread.sleep(3000);
    }

    @When("^payment credit card$")
    public void payment_credit_card() throws Throwable {
        /*
         * Action for choose payment method credit card
         */
        driver.findElement(By.cssSelector(".button-main-content")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".with-promo .list-caption")).click();
    }

    @And("^Input card number \"([^\"]*)\" with expired date \"([^\"]*)\" with cvv number \"([^\"]*)\"$")
    public void input_card_number_and_expired_date_and_cvv_number(String arg1, String arg2, String arg3) throws Throwable {
        /*
         * Action for input credit card number, expirate date and cvv number
         */
        driver.findElement(By.name("cardnumber")).click();
        driver.findElement(By.name("cardnumber")).sendKeys(arg1);
        driver.findElement(By.cssSelector(".col-xs-7 > input")).click();
        driver.findElement(By.cssSelector(".col-xs-7 > input")).sendKeys(arg2);
        driver.findElement(By.cssSelector(".col-xs-5 > input")).click();
        driver.findElement(By.cssSelector(".col-xs-5 > input")).sendKeys(arg3);
        driver.findElement(By.cssSelector(".button-main-content")).click();
        driver.switchTo().frame(0);
        Thread.sleep(1000);
    }

    @And("^Input otp bank \"([^\"]*)\"$")
    public void input_otp_bank(String arg1) throws Throwable {
        /*
         * Action for input otp bank credential
         */
        driver.findElement(By.id("PaRes")).click();
        driver.findElement(By.id("PaRes")).sendKeys(arg1);
        driver.findElement(By.name("ok")).click();
    }

    @Then("^Success Credit Card Payment$")
    public void successCreditCardPayment() throws Throwable
    {
        Thread.sleep(2000);
        driver.close();
    }
}
