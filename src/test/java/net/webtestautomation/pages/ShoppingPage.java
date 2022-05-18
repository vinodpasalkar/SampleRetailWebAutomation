package net.webtestautomation.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

//This class is used for all UI actions and extends common class MobilePageObject which contains driver and common methods
public class ShoppingPage {

    @FindBy(xpath="//div[@class='header-wishlist']")
    @AndroidFindBy(xpath="")
    @iOSFindBy(xpath = "")
    private WebElement wishList;

    @FindBy(xpath="//div[@class='site-branding-logo']")
    @AndroidFindBy(xpath="")
    @iOSFindBy(xpath = "")
    private WebElement siteBrandLogo;

    @FindBy(xpath="//div[@class='product-name']")
    @AndroidFindBy(xpath="")
    @iOSFindBy(xpath = "")
    private WebElement productNameInWishList;

    @FindBy(xpath="//div[@class='blockUI blockOverlay']")
    private WebElement overlay;

    @FindBy(xpath="//div[@id='yith-wcwl-message']")
    private WebElement productAddedMessage;


    @FindBy(xpath = "//button[@class='sc-fznyAO bQTgqJ btn btn-primary']")
    private WebElement addMovieButton;




    @Step("Step {0}")
    public void generateStep(String s){
    }

    String movieName = "//div[normalize-space()='movieName']";
    String ratingForMovie = "//div[normalize-space()='movieName']/following-sibling::div[1]";
    String updateButtonforMovie = "//div[normalize-space()='movieName']/following-sibling::div[normalize-space()='Upadate']";

    String productString = "//div[normalize-space()='movieName']/following-sibling::div[normalize-space()='Upadate']";

   String filerOption = "//span[contains(text(),'FilterOption')]";
   String categoryString = "//a[contains(text(),\"categoryName\")]";
   String selectedCategoryString = "//strong[contains(text(),\"categoryName\")]";

    private  String addToCartProduct = "//a[contains(@class,'button product_type_simple add_to_cart_button')]/following-sibling::div//div//div//span[contains(text(),'Add to wishlist')]";

    //Added this to use driver in this base class
    private static WebDriver driver ;

    public ShoppingPage() {

        WebDriverManager.chromedriver().setup();
        //Create driver object for Chrome
        this.driver = new ChromeDriver();
        PageFactory.initElements(driver, this);

    }

    //Opens the given website in the browser
    public void gotoSiteOnBrowser() {

        System.out.println("Launching the shopping site in browser");
        driver.get("https://testscriptdemo.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        generateStep("shopping site is launched successfully");

        if(driver.findElements(By.xpath("//div[@class='site-branding-logo']")).size() > 0){
            generateStep("shopping site opened successfully");
        }
        else{
            Assert.fail("Failed to load site");

        }
    }


    //Enters the search item name into the search text box
    public void createMovieFromUI(String movieName,String movieRating ,String movieTime) {

        addMovieButton.click();
        driver.switchTo().alert().accept();
        generateStep("Added movie named for an item "+movieName);
    }

    public void updateMovieFromUI(String movieName,String movieRating) {
        String updatedMatchingUpdateButton = updateButtonforMovie.replace("movieName",movieName);
        scrollOnPage(driver.findElement(By.xpath(updatedMatchingUpdateButton)));
        driver.findElement(By.xpath(updatedMatchingUpdateButton)).click();
        new WebDriverWait(driver, 5 * 1000).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        generateStep("Updated movie rating to "+movieRating);
    }


    //Verifies the results are matching to the search item
    public void verifyMovieOnUI(String movieName) {
        String updatedMovieName = this.movieName.replace("movieName",movieName);
        scrollOnPage(driver.findElement(By.xpath(updatedMovieName)));
        if (driver.findElement(By.xpath(updatedMovieName)).isDisplayed()){
            generateStep(movieName+" is present");
        }
        else{
            generateStep(movieName+" is not present");
            Assert.fail(movieName+" is not present");
        }
    }

    public void verifyMovieRatingOnUI(String movieName, String movieRating) {
        String updatedMovieRating = this.ratingForMovie.replace("movieName",movieName);
        scrollOnPage(driver.findElement(By.xpath(updatedMovieRating)));
        Assert.assertEquals(movieRating,driver.findElement(By.xpath(updatedMovieRating)).getText());
        generateStep(movieRating+" is displayed for movie "+movieName);
    }

    public void verifyDeletedMoviePresentOnUI(String movieName) {
        String updatedMovieName = this.movieName.replace("movieName",movieName);
        scrollOnPage(driver.findElement(By.xpath(updatedMovieName)));
        if (driver.findElement(By.xpath(updatedMovieName)).isDisplayed()){
            generateStep(movieName+" is not deleted from on UI");
            Assert.fail(movieName+" is not deleted from UI");

        }
        else{
            generateStep(movieName+" is deleted sucessfully");
        }
    }

    public void mouseOverElement(WebElement element)
    {
        System.out.println("Hovering over an element");
        generateStep("Hovering over an element");
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


    //Scrolls on the page until element is visible
    public void scrollOnPage(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void quit() {
        driver.quit();
    }

    public void clickOnMovieListOption() {

    }

    public void deleteMovieFromUI(String movieName) {


    }

    public void addFourDifferentProducts() throws InterruptedException {
        //if(driver.findElements(By.xpath("//div[@class='yith-wcwl-add-button']")).size() > 0){
        if(driver.findElements(By.xpath(addToCartProduct)).size() > 0){
            scrollOnPage(driver.findElement(By.xpath(addToCartProduct)));
            for(int i = 1; i <= 4; i++){
                new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(addToCartProduct)))).click();
                while (true){
                    if ((Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0")){
                        break;
                    }
                    Thread.sleep(500);
                }

            System.out.println("Added "+ i+ ".  product ");

            }
            generateStep("Added 4 products into the wish list");
        }
        else{
            Assert.fail("No products available");
        }
    }


    public void clickOnWishList() throws InterruptedException {
        Thread.sleep(10000);
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(wishList));
        driver.findElements(By.xpath("//div[@class='header-wishlist']")).get(0).click();
        generateStep("Clicked on Wishlist option");
    }

    public String findLowestPriceProductFromWishList() {

        HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
        String productName = "//table//tbody//tr//td[3]";
        String productPrice = "//table//tbody//tr//td[@class='product-price']";
        // "//table//tbody//tr//td[@class='product-price']//ins//span[contains(@class,'woocommerce-Price-amount amount')]//bdi"
        // "//table//tbody//tr//td[@class='product-price']"
        // "//table//tbody//tr//td[@class='product-price']//span[contains(@class,'woocommerce-Price-amount amount')]//bdi[1]//span"

        //Fetch All the Products Text
        List<WebElement> list_of_products = driver.findElements(By.xpath(productName));
        List<WebElement> list_of_products_price = driver.findElements(By.xpath(productPrice));

        //Use of HashMaop to store Products and Their prices(after conversion to Integer)
        String product_name;
        String product_price;
        int int_product_price;
        System.out.println("Size of products :" +list_of_products.size());
        System.out.println("Size of prices :" +list_of_products_price.size());

        for(int i=0;i<list_of_products.size();i++) {
            product_name = list_of_products.get(i).getText();//Iterate and fetch product name
            product_price = list_of_products_price.get(i).getText();//Iterate and fetch product price
            product_price = product_price.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers

            if(product_price.length() > 4) {
                product_price  = product_price.substring(4);
            }

            int_product_price = Integer.parseInt(product_price);//Convert to Integer
            map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
            System.out.println("Added :   " +int_product_price +" and    " +product_name);
        }

        //Get all the keys from Hash Map
        Set<Integer> allkeys = map_final_products.keySet();
        ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

        //Sort the Prices in Array List using Collections class
        //this will sort in ascending order lowest at the top and highest at the bottom
        Collections.sort(array_list_values_product_prices);

        //Low price is
        int low_price = array_list_values_product_prices.get(0);

        return map_final_products.get(low_price);
    }

    public int countItemsInWishList() {
        int count = 0;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[@class='product-name']"))));
        count = driver.findElements(By.xpath("//td[@class='product-name']")).size();
        return count;
    }

    public String getProductNameInCart(String cheapestProduct) {
        driver.findElement(By.xpath("//div[@class='header-right col-md-3 hidden-xs']//i[@class='la la-shopping-bag']")).click();
        String productName = " //a[contains(text(),'ProductName')]";
        String updateProductName = productName.replace("ProductName",cheapestProduct);
        System.out.println("Value : "+ driver.findElement(By.xpath(updateProductName)).getAttribute("LinkText"));
        return driver.findElement(By.xpath(updateProductName)).getText();

    }

    public void addSpecificProductToCart(String cheapestProduct) {
        String productCartbutton = "//a[@aria-label='Add “ProductName” to your cart']";
        String updatedCartButton = productCartbutton.replace("ProductName",cheapestProduct);
        scrollOnPage(driver.findElement(By.xpath(updatedCartButton)));
        driver.findElement(By.xpath(updatedCartButton)).click();
        driver.navigate().refresh();
        generateStep(cheapestProduct+" is added to the cart");
    }
}
