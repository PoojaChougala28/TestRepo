package LocatorsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorDemo
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        driver.findElement(By.name("firstname")).sendKeys("Pooja");
        driver.findElement(By.name("lastname")).sendKeys("Chougala");
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-2")).click();
        driver.findElement(By.id("datepicker")).sendKeys("08/04/2025");
        driver.findElement(By.id("profession-0")).click();
        driver.findElement(By.id("profession-1")).click();
        WebElement checkbox=driver.findElement(By.className("control-group"));
        driver.findElement(By.id("tool-2")).click();
        driver.findElement(By.id("tool-1")).click();
        driver.findElement(By.className("input-xlarge")).sendKeys("Africa");
        driver.findElement(By.id("selenium_commands")).click();
        driver.findElement(By.xpath("//*[@id=\"photo\"]")).sendKeys("\"C:\\Users\\pchougal\\Pictures\\Capture.PNG\"");
//        driver.findElement(By.className("input-file")).click();
//        picker.sendKeys("\"C:\\Users\\pchougal\\Pictures\\skype.PNG\"");
//        driver.findElement(By.id("photo")).sendKeys();
        driver.wait(50);


        driver.quit();








    }
}
