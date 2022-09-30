import org.openqa.selenium.*;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\777\\Documents\\DRIVER CHROME\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        JavascriptExecutor js = (JavascriptExecutor)driver;

        try{

            driver.get("https://vk.com/");
            Thread.sleep(5000);

            String window1 = driver.getWindowHandle();

            js.executeScript("window.open()");

            Set<String> currentWindows = driver.getWindowHandles();

            String window2 = null;

            for (String window : currentWindows) {
                if (!window.equals(window1)) {
                    window2 = window;
                    break;
                }
            };

            driver.switchTo().window(window2);
            driver.get("https://vk.com/");
            driver.close();

            driver.switchTo().window(window1);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }




    }
}
