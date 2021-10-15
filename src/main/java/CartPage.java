import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By cartPageProductLocator = new By.ByCssSelector("div[class='bottom']");
    By plusButtonLocator = new By.ByCssSelector("a[class='oq-up plus']");
    By productValueLocator = new By.ByCssSelector("input[value='2']"); // check for two products
    By deleteIconLocator = new By.ByCssSelector("a[title='Sil']");
    By verifiedDeleteButton = new By.ByCssSelector("a[class='inverted-modal-button sc-delete ins-init-condition-tracking']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

        public void plusProduct(){
            click(plusButtonLocator);
        }
        public boolean checkIfTwoProductAdd(){
             return isDisplayed(productValueLocator);
        }
        public void deleteProduct() throws InterruptedException {
            click(deleteIconLocator);
            Thread.sleep(3000);
            click(verifiedDeleteButton);
        }
        //Bu kısımı kullanmadım ama sepete girildiğinde ürünün eklenip eklenmediğini teyit etmek için var
        public boolean checkIfProductAdded() {
        // return isDisplayed(cartPageProductLocator);
             return getProducts().size()>0;
         }
         private List<WebElement> getProducts(){
        return findAll(cartPageProductLocator);
    }
}
