import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RedBusLogin {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.redbus.in/");
        WebElement logo= driver.findElement(By.className("rb_logo"));
        boolean stat=logo.isDisplayed();
        System.out.printf("Status "+stat);
        driver.findElement(By.id("src")).sendKeys("Pune");
        driver.findElement(By.id("dest")).sendKeys("Belgavi");

//        String year="2025";
//        String month="Apr";
//        String date="10";
        driver.findElement(By.id("onwardCal")).click();
        WebElement datepick= (WebElement) driver.findElements(By.id("onwardCal"));
        datepick.click();
        while(true){
            String date=driver.findElement(By.xpath("#onwardCal > div > div > text.yearText")).getText();
            String year=driver.findElement(By.xpath("#onwardCal > div > div > text.yearText")).getText();
         if(year.equals("2025") && date.equals("10 Apr")){
             driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div/text[2]")).click();
             driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div/text[3]")).click();
             break;



         }
          }







    }
}
