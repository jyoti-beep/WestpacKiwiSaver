package WestpacKiwiSaver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.*;		

//User Story 2 - Scenario 3
//Acceptance Criteria
//User whose current aged 55 is not employed, current KiwiSaver balance is $140000, voluntary contributes $10 annually and chooses Balanced risk profile with saving goals requirement of $200000 
//is able to calculate his projected balances at retirement.

public class KSStory2Test3 {
	static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {									
     
        String baseUrl = "https://www.westpac.co.nz/kiwisaver/calculators/kiwisaver-calculator/";					
              
        //Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Browser Driver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();	

        driver.get(baseUrl);	
            
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   
        
        JavascriptExecutor js = (JavascriptExecutor) driver;        
 
        driver.switchTo().frame(0);
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys("55");	
            
        //EmploymentStatus	
        driver.findElement(By.xpath("//div[@ng-model='ctrl.data.EmploymentStatus']//div//div[@class='control-well']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Not employed')]")).click(); 

        //current KiwiSaver balance
        driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input")).sendKeys("140000"); 
        
        //voluntary contributes
        driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/div/input")).sendKeys("10"); 
        
        //Annually
        driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[1]/div")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Annually')]")).click(); 
        
        //Risk Profile-Balanced       
        driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[5]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[3]/div/label/span[2]/span")).click(); 
        
        //saving goals
        driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input")).sendKeys("200000"); 
        
        //Click on Button
        driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[2]/button/span[2]")).click();
       
         
       driver.close();			
   }	
    
}



