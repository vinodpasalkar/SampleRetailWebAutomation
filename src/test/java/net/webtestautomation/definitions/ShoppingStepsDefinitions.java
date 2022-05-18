package net.webtestautomation.definitions;

import net.thucydides.core.annotations.Steps;
import net.webtestautomation.tests.ShoppingSiteTests;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


//This class contains all the steps definitions for the gherkin feature steps
public class ShoppingStepsDefinitions {

    @Steps
    ShoppingSiteTests shoppingSiteTests;
    String cheapestProduct = "";

    @Given("I add four different products to my wish list")
    public void addProductsToWishList() throws InterruptedException {
        shoppingSiteTests.launchWebSite();
        shoppingSiteTests.addFourProductsToWishList();
    }

    @When("I view my wishlist table")
    public void viewWishlist() throws InterruptedException {
        shoppingSiteTests.viewWishListFromUI();
    }

    @When("I search for lowest price product")
    public void searchForLowestPriceProduct(){
        cheapestProduct = shoppingSiteTests.searchLowestProceProductFromWishList();
    }

    @When("I am able to add lowest price item to my cart")
    public void addProductToTheCart(){
        shoppingSiteTests.addProductToCart(cheapestProduct);
    }

    @Then("I find total four selected items in my wishlist")
    public void verifyMovieListResults(){
        shoppingSiteTests.countProductsInWishList();
    }

    @Then("I am able to verify the item in my cart")
    public void verifyAddedProductInCart(){
        shoppingSiteTests.verifyProductAdditionToTheCart(cheapestProduct);
    }


}
