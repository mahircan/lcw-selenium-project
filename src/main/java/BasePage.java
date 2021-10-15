import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void type(By locator, String text){
        find(locator).sendKeys(text);
    }

    //Kontrol amaçlı bir fonksiyon çoğunlukta hangi sayfada olduğumu görmek için kullandım
    public boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    //Sayfanın aşağısına inmek için
    public void scrollDown(String text){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(text);
    }
    //Bekleme için yazdığım fonksiyon
    public void wait(int i, By locator){
        WebDriverWait wait = new WebDriverWait(driver,i);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}
