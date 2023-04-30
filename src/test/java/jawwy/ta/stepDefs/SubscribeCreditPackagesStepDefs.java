package jawwy.ta.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jawwy.ta.pages.SubscribePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SubscribeCreditPackagesStepDefs {
    SubscribePage subscribePage = new SubscribePage();
    SoftAssert softAssert = new SoftAssert();

    @Then("The Three types of packages is displayed for credit card")
    public void theThreeTypesOfPackagesIsDisplayedForCreditCard() {
        softAssert.assertTrue(subscribePage.litePlanTitleWebEle().isDisplayed(), "Lite Plan title should be displayed");
        System.out.println(subscribePage.litePlanTitleWebEle().getText());
        softAssert.assertTrue(subscribePage.classicPlanTitleWebEle().isDisplayed(), "Classic Plan title should be displayed");
        System.out.println(subscribePage.classicPlanTitleWebEle().getText());
        softAssert.assertTrue(subscribePage.premiumPlanTitleWebEle().isDisplayed(), "Premium Plan title should be displayed");
        System.out.println(subscribePage.premiumPlanTitleWebEle().getText());
        softAssert.assertAll();
    }

    @And("validate the prices for all packages in the selected {string}")
    public void validateThePricesForAllPackages(String country) {
        switch (country) {
            case "Egypt":
                softAssert.assertEquals(subscribePage.litePlanPriceWebEle().getText(), "0.25", "Lite Plan Price should be 0.25");
                softAssert.assertEquals(subscribePage.classicPlanPriceWebEle().getText(), "0.5", "Classic Plan Price should be 0.5");
                softAssert.assertEquals(subscribePage.premiumPlanPriceWebEle().getText(), "1", "Premium Plan Price should be 1");
                softAssert.assertAll();
                break;
            case "Emirates":
                softAssert.assertEquals(subscribePage.litePlanPriceWebEle().getText(), "5.4", "Lite Plan Price for Emirates should be 5.4");
                softAssert.assertEquals(subscribePage.classicPlanPriceWebEle().getText(), "10.9", "Classic Plan Price for Emirates should be 10.9");
                softAssert.assertEquals(subscribePage.premiumPlanPriceWebEle().getText(), "16.3", "Premium Plan Price for Emirates should be 16.3");
                softAssert.assertAll();
                break;
            case "Oman":
                softAssert.assertEquals(subscribePage.litePlanPriceWebEle().getText(), "5", "Lite Plan Price for Oman should be 5");
                softAssert.assertEquals(subscribePage.classicPlanPriceWebEle().getText(), "10", "Classic Plan Price Oman should be 10");
                softAssert.assertEquals(subscribePage.premiumPlanPriceWebEle().getText(), "15", "Premium Plan Price Oman should be 15");
                softAssert.assertAll();
                break;
            default:
                System.out.println("Please select another Country");
        }
        System.out.println(subscribePage.litePlanPriceWebEle().getText());
        System.out.println(subscribePage.classicPlanPriceWebEle().getText());
        System.out.println(subscribePage.premiumPlanPriceWebEle().getText());

    }

    @And("Validate the currency for all packages in the selected {string}")
    public void validateTheCurrencyForAllPackages(String country) {
        softAssert.assertTrue(subscribePage.litePlanCurrencyWebEle().getText().contains("USD"), "lite currency should contains USD");
        System.out.println(subscribePage.litePlanCurrencyWebEle().getText());
        softAssert.assertEquals(subscribePage.classicPlanCurrencyWebEle().getText().contains("USD"), true, "Classic Currency should be USD");
        System.out.println(subscribePage.classicPlanCurrencyWebEle().getText());
        softAssert.assertEquals(subscribePage.premiumPlanCurrencyWebEle().getText(), "USD/month", "Premium Currency should be USD");
        System.out.println(subscribePage.premiumPlanCurrencyWebEle().getText());
        softAssert.assertAll();
    }

    @When("Select free-trial for any listed package")
    public void selectFreeTrialForAnyListedPackage() {
        subscribePage.startTrialLite();
    }

    @Then("Total price should be zero for any listed {string}")
    public void totalPriceShouldBeZeroForAnyListed(String country) {
        switch (country) {
            case "Egypt":
                Assert.assertEquals(subscribePage.totalPriceWebEle().getText(), "Price Today 0.00", "Total price should be 0");
                break;
            case "Emirates":
                Assert.assertEquals(subscribePage.totalPriceWebEle().getText(), "0.00 USD/month", "Total price should be 0");
                break;
            case "Oman":
                Assert.assertEquals(subscribePage.totalPriceWebEle().getText(), "0.00 USD/month", "The Total price should be 0");
                break;
            default:
                System.out.println("Please select on of the 3 countries Egypt-Emirates-Oman");
        }
        System.out.println(subscribePage.totalPriceWebEle().getText());
    }
}
