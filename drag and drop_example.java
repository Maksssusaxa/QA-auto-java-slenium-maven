import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\777\\Documents\\DRIVER CHROME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        try{
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);

            WebElement element = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
            WebElement element2 = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));

            Actions actions = new Actions(driver);

            actions.moveToElement(element).clickAndHold().moveToElement(element2).release().build().perform();


        }catch (InterruptedException e) {

            e.printStackTrace();
        }finally {
            Thread.sleep(10000);
            driver.quit();
        }
        
    }
}