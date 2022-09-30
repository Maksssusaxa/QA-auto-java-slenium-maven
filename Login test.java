import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\777\\Documents\\DRIVER CHROME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://vk.com/");
        

        WebElement LoginInput = driver.findElement(By.xpath("//input[@class=\"VkIdForm__input\"]"));
        LoginInput.click();
        LoginInput.sendKeys("89101819329");

        driver.findElement(By.xpath("//input[@class=\"VkIdCheckbox__checkbox\"]")).click();

        driver.findElement(By.xpath("//button[@class=\"FlatButton FlatButton--primary FlatButton--size-l FlatButton--wide VkIdForm__button VkIdForm__signInButton\"]")).click();


    }
}
