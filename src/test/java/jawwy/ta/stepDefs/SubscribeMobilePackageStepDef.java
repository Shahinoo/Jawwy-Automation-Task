package jawwy.ta.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jawwy.ta.pages.SubscribePage;
import org.testng.asserts.SoftAssert;

public class SubscribeMobilePackageStepDef {
    SubscribePage subscribePage = new SubscribePage();
    SoftAssert softAssert = new SoftAssert();

    @Given("User on subscribe page")
    public void userOnSubscribePage() {
        subscribePage.navigateToSubscriptionPage();
    }

    @When("User select a {string} from countries list")
    public void userSelectACountryFromCountriesList(String country) {
        subscribePage.selectCountry(country);
    }

    @Then("a Classic mobile package is displayed")
    public void aClassicMobilePackageIsDisplayed() {
        // Assert on Mobile Package Classic Type is displayed
        softAssert.assertTrue(subscribePage.typeTitleForMobilePackageWebEle().isDisplayed(),
                "Classic Type is Displayed");
        softAssert.assertEquals(subscribePage.typeTitleForMobilePackageWebEle().getText().toLowerCase(), "classic",
                "Mobile Package Type is a Classic");
        softAssert.assertAll();
        System.out.println(subscribePage.typeTitleForMobilePackageWebEle().getText());
    }

    @And("The Currency and the Price of the selected {string} are displayed")
    public void theCurrencyAndThePriceOfTheSelectedCountryAreDisplayed(String country) {
        switch (country) {
            case "Egypt":
                softAssert.assertTrue(subscribePage.currencyAndPriceForMobilePackageWebEle().getText().contains("Egyptian pound"),
                        "Assert on Egyptian Currency of Mobile package");
                softAssert.assertTrue(subscribePage.currencyAndPriceForMobilePackageWebEle().getText().contains("7"),
                        "Assert on Price of Mobile package");
                System.out.println(subscribePage.currencyAndPriceForMobilePackageWebEle().getText());
                softAssert.assertAll();
                break;
            case "Emirates":
                softAssert.assertTrue(subscribePage.currencyAndPriceForMobilePackageWebEle().getText().contains("AED"),
                        "Emirates Currency of Mobile package should be AED");
                softAssert.assertTrue(subscribePage.currencyAndPriceForMobilePackageWebEle().getText().contains("10"),
                        "Emirate Price of Mobile package should be 10");
                System.out.println(subscribePage.currencyAndPriceForMobilePackageWebEle().getText());
                softAssert.assertAll();
                break;
            case "Oman":
                softAssert.assertTrue(subscribePage.currencyAndPriceForMobilePackageWebEle().getText().contains("OMR/week"),
                        "Oman Currency of Mobile package should be OMR");
                softAssert.assertTrue(subscribePage.currencyAndPriceForMobilePackageWebEle().getText().contains("1"),
                        "Oman Price of Mobile package should be 1");
                System.out.println(subscribePage.currencyAndPriceForMobilePackageWebEle().getText());
                softAssert.assertAll();
                break;
        }
    }

    @When("User click on select button")
    public void userClickOnSelectButton() {
        subscribePage.selectMobilePackage();
    }

    @Then("user should be on payment method")
    public void userShouldBeOnPaymentMethod() {
        softAssert.assertTrue(subscribePage.paymentMethodHeaderWebEle().isDisplayed());
        System.out.println(subscribePage.paymentMethodHeaderWebEle().getText());
        softAssert.assertTrue(subscribePage.orderSummeryHeaderWebEle().isDisplayed());
        System.out.println(subscribePage.orderSummeryHeaderWebEle().getText());
        softAssert.assertAll();
    }
}
