import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    SearchBox searchBox;

    By loginLocator = new By.ByCssSelector("a[href='https://www.lcwaikiki.com/tr-TR/TR/giris'] span[class='dropdown-label']");
    By topMessageLocator = new By.ByCssSelector("div[class='div-header-container']");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public void clickLogin(){
        click(loginLocator);
    }
    public boolean isOnHomePage() {
        return isDisplayed(topMessageLocator);
    }
}
