import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BasePage{

    By sizeButtonLocator = new By.ByCssSelector("div[class='option-size'] a[data-tracking-label='BedenSecenekleri']");
    By addButtonLocator = new By.ByCssSelector("a[class='add-to-cart button-link add-to-cart-button']");
    By basketIconLocator = new By.ByCssSelector("i[class='header-bag-icon bndl-shopping-bag bndl-shopping-bag-dims'] ");
    By paymentPanelLocator = new By.ByCssSelector("h4[class='payment-options-panel-title']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void compareTwoPrice(){
        String cashPriceValueString = driver.findElement(new By.ByCssSelector("div[style='display: flex'] span[class='price']")).getText();
        String basketPriceValueString = driver.findElement(By.id("cartLastTotal")).getText();
        Assertions.assertEquals(cashPriceValueString,basketPriceValueString,"Ürün Sayfasındaki Fiyat Sepetteki Fiyat İle Farlı! ");
        System.out.println("Ürün Sayfasındaki Fiyat Sepetteki Fiyat İle Aynı... ");

    }

    public void clickAdd(){
        click(addButtonLocator);
    }

    public void clickGoToBasket(){
        click(basketIconLocator);
    }

    public boolean isOnCheckProductDetailPage(){
        return isDisplayed(paymentPanelLocator);
    }

    public void selectSizes(int i){
        getAllSizes().get(i).click();
    }

    private List<WebElement> getAllSizes(){
        return findAll(sizeButtonLocator);
    }
}
