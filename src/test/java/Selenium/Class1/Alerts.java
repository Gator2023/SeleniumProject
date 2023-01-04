package Selenium.Class1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //JavaScripts alerts
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        //confirm alert
        driver.findElement(By.id("confirmButton")).click();
        System.out.println(driver.switchTo().alert().getText());
        // driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        //prompts alart
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Saima");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.navigate().refresh();

//JavaScripts alerts
        driver.findElement(By.id("alertButton")).click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(4000);
        alert.accept();

        //confirm alert
        driver.findElement(By.id("confirmButton")).click();
        System.out.println(alert.getText());
        Thread.sleep(4000);
        alert.dismiss();

        //prompts alert
        driver.findElement(By.id("promtButton")).click();
        System.out.println(alert.getText());
        Thread.sleep(4000);
        alert.sendKeys("Saima");
        Thread.sleep(4000);
        alert.accept();

        driver.quit();

    }
}
