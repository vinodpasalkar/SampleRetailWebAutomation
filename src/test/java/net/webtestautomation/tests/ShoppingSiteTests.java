package net.webtestautomation.tests;

import net.thucydides.core.annotations.Step;
import net.webtestautomation.pages.ShoppingPage;
import org.junit.Assert;

//This class is used for test assertions
public class ShoppingSiteTests {

    @Step("Step {0}")
    public void generateStep(String s){
    }

    private ShoppingPage shoppingPage;

    public void launchWebSite() {
        shoppingPage = new ShoppingPage();
        shoppingPage.gotoSiteOnBrowser();
        generateStep("Opened shopping website");
    }


    public void sendMovieDetails(String movieName,String movieRating ,String movieTime) {
        shoppingPage.createMovieFromUI( movieName, movieRating , movieTime);
    }

    public void updateMovieDetails(String movieName,String movieRating) {
        shoppingPage.updateMovieFromUI( movieName, movieRating);
    }

    public void checkMovieResults(String movieName) {
        shoppingPage.verifyMovieOnUI(movieName);
    }

    public void  checkMovieRating(String movieName,String movieRating) {
        shoppingPage.verifyMovieRatingOnUI(movieName,movieRating);
    }


    public void quit() {
        shoppingPage.quit();
    }

    public void gotoMovieListPage() {
        shoppingPage.clickOnMovieListOption();
    }

    public void deleteMovieDetails(String movieName) {
        shoppingPage.deleteMovieFromUI(movieName);
    }

    public void checkDeletedMovie(String movieName) {
        shoppingPage.verifyDeletedMoviePresentOnUI(movieName);
    }

    public void addFourProductsToWishList() throws InterruptedException {
        shoppingPage.addFourDifferentProducts();
    }

    public void viewWishListFromUI() throws InterruptedException {
        shoppingPage.clickOnWishList();
    }

    public String searchLowestProceProductFromWishList() {
        String product = shoppingPage.findLowestPriceProductFromWishList();
        return product;
    }

    public void countProductsInWishList() {
        int count = shoppingPage.countItemsInWishList();
        Assert.assertEquals(4,count);
    }

    public void verifyProductAdditionToTheCart(String cheapestProduct) {
        String productNameInCart = shoppingPage.getProductNameInCart(cheapestProduct);
        Assert.assertEquals(cheapestProduct,productNameInCart);
    }

    public void addProductToCart(String cheapestProduct) {
        shoppingPage.addSpecificProductToCart(cheapestProduct);
    }
}
