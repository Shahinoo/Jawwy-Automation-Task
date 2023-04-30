package jawwy.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static jawwy.ta.stepDefs.Hooks.driver;

public class SubscribePage {
    // Locators of Subscribe of Mobile Package
    private By countryList = By.id("country-name");
    private By enLanguageBTN = By.linkText("English");
    private By emiratesCountry = By.id("ae");
    private By egyptCountry = By.id("eg");
    private By omanCountry = By.id("om");
    private By TypeTitleForMobile = By.xpath("//h4[.='CLASSIC']");
    private By currencyAndPriceForMobile = By.xpath("//div[@class='trial-cost'][contains(text(),'From')]");
    private By selectMobilePackageBTN = By.cssSelector(".button.trial-button");
    private By paymentMethodHeader = By.xpath("//h3[normalize-space()='Payment Method']");
    private By orderSummeryHeader = By.xpath("//h3[normalize-space()='Order summary']");

    // locators for Subscribe Credit card Package
    private By litePlanTitle = By.id("name-lite");
    private By classicPlanTitle = By.id("name-classic");
    private By premiumPlanTitle = By.id("name-premium");

    private By litePrice = By.xpath("//*[@id=\"currency-lite\"]/b");
    private By liteCurrency = By.cssSelector("div#currency-classic > i");

    private By classicPrice = By.xpath("//*[@id=\"currency-classic\"]/b");
    private By classicCurrency = By.cssSelector("div#currency-lite > i");

    private By premiumPrice = By.xpath("//*[@id=\"currency-premium\"]/b");
    private By premiumCurrency = By.cssSelector("div#currency-premium > i");

    private By startClassicTrialBtn = By.id("classic-selection");
    private By totalPrice = By.id("order-total-price");
    // Subscribe Mobile Package Functions
    public void navigateToSubscriptionPage() {
        driver.navigate().to("https://subscribe.stctv.com/");
    }

    public void selectCountry(String country) {
        driver.findElement(enLanguageBTN).click();
        driver.findElement(countryList).click();
        switch (country) {
            case "Egypt":
                driver.findElement(egyptCountry).click();
                break;
            case "Emirates":
                driver.findElement(emiratesCountry).click();
                break;
            case "Oman":
                driver.findElement(omanCountry).click();
                break;
            default:
                System.out.println("Please Edit the Code to accept any other country");
        }
    }

    public void selectMobilePackage() {
        driver.findElement(selectMobilePackageBTN).click();
    }

    // subscribe credit card Functions
    public void startTrialLite () {
        driver.findElement(startClassicTrialBtn).click();
    }
    // get elements for assertions (Mobile Package)
    public WebElement typeTitleForMobilePackageWebEle() {
        return driver.findElement(TypeTitleForMobile);
    }

    public WebElement currencyAndPriceForMobilePackageWebEle() {
        return driver.findElement(currencyAndPriceForMobile);
    }

    public WebElement paymentMethodHeaderWebEle() {
        return driver.findElement(paymentMethodHeader);
    }

    public WebElement orderSummeryHeaderWebEle() {
        return driver.findElement(orderSummeryHeader);
    }

    // get elements for assertions ( Credit card Packages)
    public WebElement litePlanTitleWebEle() {
        return driver.findElement(litePlanTitle);
    }

    public WebElement classicPlanTitleWebEle() {
        return driver.findElement(classicPlanTitle);
    }

    public WebElement premiumPlanTitleWebEle() {
        return driver.findElement(premiumPlanTitle);
    }

    public WebElement litePlanPriceWebEle() {
        return driver.findElement(litePrice);
    }

    public WebElement classicPlanPriceWebEle() {
        return driver.findElement(classicPrice);
    }

    public WebElement premiumPlanPriceWebEle() {
        return driver.findElement(premiumPrice);
    }

    public WebElement litePlanCurrencyWebEle() {
        return driver.findElement(liteCurrency);
    }

    public WebElement classicPlanCurrencyWebEle() {
        return driver.findElement(classicCurrency);
    }

    public WebElement premiumPlanCurrencyWebEle() {
        return driver.findElement(premiumCurrency);
    }

    public WebElement selectClassicTrialBtnWebEle() {
        return driver.findElement(startClassicTrialBtn);
    }
    public WebElement totalPriceWebEle() {
        return driver.findElement(totalPrice);
    }
}
