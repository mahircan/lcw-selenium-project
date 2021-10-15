import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Login_Add_To_Product_Cart extends BaseTest{

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
  //  @Disabled("We have bugs in this test section")
    public void login_and_search_a_product() {
        homePage = new HomePage(driver);
        homePage.clickLogin();
        loginPage = new LoginPage(driver);
        Assertions.assertTrue(loginPage.isOnLoginPage(),
                "Not on Login Page!");
        loginPage.loginWith("mahirsahinkaya@gmail.com","anchor07111998");
        Assertions.assertTrue(homePage.isOnHomePage(),
                "Not on Home Page!");
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("pantolan"); // Verilen projede böyle yazılmış
               Assertions.assertTrue(productsPage.isOnProductsPage(),
                     "Not on product page!");
    }

    @Test
    @Order(2)
    //  @Disabled("We have bugs in this test section")
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.scrollDownClick();
        productsPage.clickSeeMore();
        productsPage.selectProduct(5);
        Assertions.assertTrue(productDetailPage.isOnCheckProductDetailPage(),
                      "Not on product detail page!");
    }

    @Test
    @Order(3)
    //  @Disabled("We have bugs in this test section")
    public void add_Product_to_Cart() throws InterruptedException {
        productDetailPage.selectSizes(1);
        productDetailPage.clickAdd();
        Thread.sleep(3000);
        productDetailPage.compareTwoPrice();
        productDetailPage.clickGoToBasket();
    }

    @Test
    @Order(4)
    //  @Disabled("We have bugs in this test section")
    public void go_to_Cart_and_Delete() throws InterruptedException {
       cartPage = new CartPage(driver);
       cartPage.checkIfProductAdded();
       cartPage.plusProduct();
       Assertions.assertTrue(cartPage.checkIfTwoProductAdd(),"Not we have two product now!");
       Thread.sleep(3000);
       cartPage.deleteProduct();
    }
}
