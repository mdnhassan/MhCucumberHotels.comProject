package page_objects;

import command_providers.ActOn;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RealApr extends NavigationBar{
    private final By Rates = By.linkText("Rates");
    private final By RealApr = By.linkText("Real APR");
    private final By HomePrice = By.name("HomeValue");
    private final By DownPayment = By.name("DownPayment");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By InterestRate = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAPR = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[contains(text(),'Actual APR')]/../../td[2]/strong");


    public RealApr(WebDriver driver){
        super(driver);
    }

    public RealApr typeHomePrice(String value){
        ActOn.element(driver, HomePrice).setValue(value);
        return this;
    }

    public RealApr typeDownPayment(String value){
        ActOn.element(driver, DownPayment).setValue(value);
        return this;
    }

    public RealApr selectDownPaymentInDollar(){
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public RealApr typeInterestRate(String value){
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    public RealApr clickOnCalculateButton(){
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public RealApr validateAprRate(String expectedValue){
        String actualAprRate = ActOn.element(driver, ActualAPR).getTextValue();
        Assert.assertEquals(expectedValue,actualAprRate);
        return this;
    }
}
