import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By loginContainerLocator = new By.ByCssSelector("input[name='LoginEmail']");
    By passwordContainerLocator = new By.ByCssSelector("input[data-tracking-label='GirişSifre']");
    By loginButtonLocator = new By.ByCssSelector("a[class='button bc-blue login-button-link bold']");
    By checkLoginLocator = new By.ByCssSelector("p[class='ul-title']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginWith(String userMail, String userPassword){
       wait(5,loginContainerLocator);
       driver.findElement(loginContainerLocator).sendKeys(userMail);
       driver.findElement(passwordContainerLocator).sendKeys(userPassword);
       driver.findElement(loginButtonLocator).click();
   }
   public boolean isOnLoginPage(){
       return isDisplayed(checkLoginLocator);
   }

}
