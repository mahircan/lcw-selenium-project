import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By searchBoxLocator = new By.ByCssSelector("input[class='searchBox']");
    By searchButtonLocator = new By.ByCssSelector("button[class='searchButton']");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String searchText){
        click(searchBoxLocator);
        type(searchBoxLocator,searchText);
        click(searchButtonLocator);
    }
}
