package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFunctionality {

    WebDriver driver = Hooks.driver;
    private static Logger LOGGER = LogManager.getLogger(SearchFunctionality.class);
    private static final By SearchBox = By.name("q-destination");
    private static final By SearchButton = By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div/form/div[2]/div[3]/button");
    private static final By SearchResult = By.xpath("//*[@id=\"0\"]/div/a");



    @When("^user enter destination\"(.+?)\"$")
    public void enterDestination(String destination) throws InterruptedException {
        ActOn.element(driver, SearchBox).setValue(destination);
        Thread.sleep(1000);
        LOGGER.info("User enters destination");
    }

    @And("click on search button")
    public void clickSearchButton() {
        ActOn.element(driver, SearchButton).click();
        LOGGER.info("User click on the search button");
    }

//    @Then("user navigated to the result page")
//    public void validateSearchResult() {
//        boolean SearchResultVisible = driver.findElement(SearchResult).isDisplayed();
//        Assert.assertTrue("Search result not displayed", SearchResultVisible);
//        LOGGER.info("Search result page is visible");
//    }
}
