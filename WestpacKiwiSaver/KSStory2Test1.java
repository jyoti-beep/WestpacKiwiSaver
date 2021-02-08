package WestpacKiwiSaver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import java.util.List;

import org.openqa.selenium.*;		

//User Story 2 - - Scenario 1
//Acceptance Criteria
//User whose Current age is 30 is Employed @ a Salary 82000 p/a, contributes to KiwiSaver @ 4% and chooses a Defensive risk profile can calculate his projected balances at retirement.

public class KSStory2Test1 {
	static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {									
     
        String baseUrl = "https://www.westpac.co.nz/kiwisaver/calculators/kiwisaver-calculator/";					
        
        //Firefox driver
        //System.setProperty("webdriver.gecko.driver", "C:\\Selenium Browser Driver\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        //driver = new FirefoxDriver();		
        
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
        currentElement.sendKeys("30");	
            
        //EmploymentStatus	
        driver.findElement(By.xpath("//div[@ng-model='ctrl.data.EmploymentStatus']//div//div[@class='control-well']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Employed')]")).click(); 

        //Current Salary
        driver.findElement(By.xpath("//*[@id='widget']/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input")).sendKeys("8200"); 
        
        //KiwiSaver Contribution - 4%
        driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div/label/span[2]/span")).click(); 
        
        //Risk Profile-Defensive       
        driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[7]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[1]/div/label/span[2]/span")).click(); 
        
        //Click on Button
        driver.findElement(By.xpath("//*[@id='widget']/div/div[1]/div/div[2]/button/span[2]")).click();
        
           
       //driver.close();			
   }	
    
}



