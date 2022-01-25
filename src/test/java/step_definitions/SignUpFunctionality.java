package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpFunctionality {
    WebDriver driver = Hooks.driver;
    private static Logger LOGGER = LogManager.getLogger(SignUpFunctionality.class);
    private static final By SignUp1 = By.xpath("//*[@id=\"main-content\"]//div[2]/div[1]/a[text()='Sign up']");
    private static final By SignUpEmailAddress = By.id("sign-up-email");
    private static final By SignUpPassword = By.id("sign-up-password");
    private static final By SignUpFName = By.id("sign-up-first-name");
    private static final By SignUpLName = By.id("sign-up-last-name");
    private static final By CreateAccButton = By.id("signup-button");
    private static final By AccHolderName = By.xpath("//*[@id=\"header-full\"]/header/nav[1]/div/ul/li[3]/div/label");
    private static final By SignOutButton = By.id("hdr-signout");
    private static final By EmailErrorSignUp = By.id("email-error");
    private static final By PasswordErrorSignUp = By.id("password-error");

    @And("click on Sign Up button")
    public void clickSignUpButton() {
        ActOn.element(driver, SignUp1).click();
        LOGGER.info("User click on SignUp button");
    }

    @Then("user is navigated to the Sign up page")
    public void validateSignUpPageVisible() {
        boolean SignUpPageDisplayed = driver.findElement(CreateAccButton).isDisplayed();
        Assert.assertTrue("User is not on SignUp page", SignUpPageDisplayed);
        LOGGER.info("User is on the sign up page");
    }

    @And("^enter Email \"(.+?)\", Password\"(.+?)\", First name\"(.+?)\", and Last name\"(.+?)\"$")
    public void enterSignUpData(String email, String password, String firstName, String lastName) {
        ActOn.element(driver, SignUpEmailAddress).setValue(email);
        ActOn.element(driver, SignUpPassword).setValue(password);
        ActOn.element(driver, SignUpFName).setValue(firstName);
        ActOn.element(driver, SignUpLName).setValue(lastName);
        LOGGER.info("User enter sign up data");
    }

    @And("click on Create Account button")
    public void clickCreateAccButton() throws InterruptedException {
        Thread.sleep(3000);
        ActOn.element(driver, CreateAccButton).click();
        LOGGER.info("User click on Create Account button");
    }

    @Then("user is navigated to the account home page")
    public void validateAccountHomePage() {
        ActOn.element(driver, AccHolderName).click();
        boolean signOutButtonDisplayed = driver.findElement(SignOutButton).isDisplayed();
        Assert.assertTrue("User is not in the account home page", signOutButtonDisplayed);
        LOGGER.info("User is on his account home page");
    }

    @And("enter invalid Email Address")
    public void enterInvalidEmailSignUp() {
        ActOn.element(driver, SignUpEmailAddress).setValue("mdnhassan842@gmail");
        ActOn.element(driver, SignUpPassword).setValue("Mdha842@");
        ActOn.element(driver, SignUpFName).setValue("md");
        ActOn.element(driver, SignUpLName).setValue("hassan");
        LOGGER.info("User enter invalid email address");
    }

    @Then("invalid email error message shows up")
    public void validateInvalidEmailEntrySignUp() {
        boolean emailErrorDisplayed = driver.findElement(EmailErrorSignUp).isDisplayed();
        Assert.assertTrue("Invalid error message not displayed", emailErrorDisplayed);
        LOGGER.info("Invalid email error message shows up");
    }

    @And("enter invalid Password")
    public void enterInvalidPasswordSignUp() {
        ActOn.element(driver, SignUpEmailAddress).setValue("mdnhassan841@gmail.com");
        ActOn.element(driver, SignUpPassword).setValue("Mdha");
        ActOn.element(driver, SignUpFName).setValue("md");
        ActOn.element(driver, SignUpLName).setValue("hassan");
        LOGGER.info("User enter invalid email address");
    }

    @Then("invalid password error message shows up")
    public void validateInvalidPasswordEntrySignUp() {
        boolean passwordErrorDisplayed = driver.findElement(PasswordErrorSignUp).isDisplayed();
        Assert.assertTrue("Password error message not displayed", passwordErrorDisplayed);
        LOGGER.info("Invalid password error message shows up");
    }

}
