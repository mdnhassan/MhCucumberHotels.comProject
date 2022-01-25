package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInFunctionality {
    WebDriver driver = Hooks.driver;
    private static Logger LOGGER = LogManager.getLogger(SignInFunctionality.class);
    private static final By SignIn1 = By.xpath("//*[@id=\"header\"]/div[1]/nav/div/ul/li[5]/a/span[text()='Sign in']");
    private static final By SignIn2 = By.id("sign-in-button");
    private static final By SignInEmail = By.id("sign-in-email");
    private static final By SignInPassword = By.id("sign-in-password");
    private static final By AccountPage = By.xpath("//*[@id=\"main\"]/div[1]/article/div/h4");
    private static final By SignInError = By.xpath("//*[@id=\"main-content\"]//div/div[2]/div[1]");
    private static final By Trip = By.xpath("//*[@id=\"header\"]/div[1]/nav/div/ul/li[4]/a");
    private static final By TripVisible = By.xpath("//*//*[@id=\"main-content\"]/div/div[1]/div/h1");


    @Given("user is on the Hotel.com home page")
    public void navigatedToHomePage() {
        ActOn.browser(driver).openBrowser("https://www.hotels.com/?locale=en_IE&rffrid=aff.hcom.AR.038.000.1011l27925.kwrd%3D1101liKmyTbo");
        LOGGER.info("User is on the home page");
    }

    @When("user click on the Sign in button")
    public void click1stSignInButton() {
        ActOn.element(driver, SignIn1).click();
        LOGGER.info("User click on the Sign In button");
    }

    @Then("user is navigated to the Sign in page")
    public void validateSignInPageOpen() {
        boolean SignInPageDisplayed = driver.findElement(SignIn2).isDisplayed();
        Assert.assertTrue("Sign In page not displayed", SignInPageDisplayed);
        LOGGER.info("User is on the sign in page");
    }


    @And("^enter valid Email address \"(.+?)\" and Password \"(.+?)\"$")
    public void enterValidCredential(String Email, String Password) throws InterruptedException {
        ActOn.element(driver, SignInEmail).setValue(Email);
        ActOn.element(driver, SignInPassword).setValue(Password);
        Thread.sleep(3000);
        LOGGER.info("User enter valid sign in credential");
    }

    @And("click on Sign in button")
    public void clickSignInButton() {
        ActOn.element(driver, SignIn2).click();
        LOGGER.info("click on signIn2 button");
    }


    @Then("user is navigated to the account main home page")
    public void validateAccountMainHomePage() {
        boolean AccountHomePageDisplayed = driver.findElement(AccountPage).isDisplayed();
        Assert.assertTrue("Account home page not displayed", AccountHomePageDisplayed);
        LOGGER.info("User is on the account home page");
    }

    @And("enter invalid Email address and Password")
    public void enterInvalidCredential() {
        ActOn.element(driver, SignInEmail).setValue("mdnhassan843@gmail.com");
        ActOn.element(driver, SignInPassword).setValue("Mdha842");
        LOGGER.info("User enter invalid email and password");
    }

    @Then("invalid Email or password error message shows up")
    public void signInErrorMessage() {
        boolean SignInErrorVisible = driver.findElement(SignInError).isDisplayed();
        Assert.assertTrue("SignIn error message is not visible", SignInErrorVisible);
        LOGGER.info("Sign in error shows up");
    }

    @And("select Trips option")
    public void selectTrip() {
        ActOn.element(driver,Trip).click();
        LOGGER.info("User Click on trip button");
    }

    @Then("user is navigated to the trip summery page")
    public void tripPageVisible() {
        boolean TripPageVisible = driver.findElement(TripVisible).isDisplayed();
        Assert.assertTrue("Trip page not displayed", TripPageVisible);
    }
}
