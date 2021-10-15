import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends BasePage{

    By seeMoreButtonLocator = new By.ByCssSelector("a[class='lazy-load-button']");
    By productsPicturesLocator = new By.ByCssSelector("div[class='picture-box']");
    By productsFilterLocator = By.id("filter-label");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void scrollDownClick(){
       wait(5,seeMoreButtonLocator);
        scrollDown("window.scrollBy(0,document.body.scrollHeight);");
    }
    public boolean isOnProductsPage(){
        return isDisplayed(productsFilterLocator);
    }
    public void clickSeeMore(){
        click(seeMoreButtonLocator);
    }
    public void selectProduct(int i){
        getAllProducts().get(i).click();
    }
    private List<WebElement> getAllProducts(){
        return findAll(productsPicturesLocator);
    }

}
