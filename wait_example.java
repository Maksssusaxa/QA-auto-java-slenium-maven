import org.openqa.selenium.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\777\\Documents\\DRIVER CHROME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        try{


            driver.get("https://pagination.js.org/");
            Thread.sleep(2000);

            List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"data-container\"]/ul/li"));
            List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));
            String text = elements.get(6).getText();
            System.out.println(text);


            pages.get(2).click();
            wait.until(ExpectedConditions.stalenessOf(elements.get(6)));


        }catch (InterruptedException e) {

            e.printStackTrace();
        }finally {
            Thread.sleep(10000);
            driver.quit();
        }

    }
}