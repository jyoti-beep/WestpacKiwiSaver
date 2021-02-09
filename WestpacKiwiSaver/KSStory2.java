package WestpacKiwiSaver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import java.util.List;

import org.openqa.selenium.*;		

//User Story 2 - 

public class KSStory2 {
	static WebDriver driver;
	static String baseUrl;
	
    public static void main(String[] args) throws InterruptedException {									
     
        baseUrl = "https://www.westpac.co.nz/kiwisaver/calculators/kiwisaver-calculator/";					
        
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
        
        driver.switchTo().frame(0);
        
       Scenario1();
        Scenario2();
        Scenario3();
    
       driver.close();			
   }	
    
    //Acceptance Criteria
    //User whose Current age is 30 is Employed @ a Salary 82000 p/a, contributes to KiwiSaver @ 4% and chooses a Defensive risk profile can calculate his projected balances at retirement.
    public static void Scenario1() {
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
      WebElement ele = driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[2]/button/span[2]")); 
      JavascriptExecutor js = (JavascriptExecutor) driver;      
      js.executeScript("arguments[0].click();", ele);
      //driver.findElement(By.xpath("//*[@id='widget']/div/div[1]/div/div[2]/button/span[2]")).click();
    }
    
    //Acceptance Criteria
    //User whose Current age is 30 is Employed @ a Salary 82000 p/a, contributes to KiwiSaver @ 4% and chooses a Defensive risk profile can calculate his projected balances at retirement.
    public static void Scenario2() {
  	
        WebElement age = driver.findElement(By.xpath("//*[@id='widget']/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/input"));
        age.clear();
        age.sendKeys("45");	
            
        //EmploymentStatus	
        driver.findElement(By.xpath("//div[@ng-model='ctrl.data.EmploymentStatus']//div//div[@class='control-well']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Self-employed')]")).click(); 

        //current KiwiSaver balance
        WebElement bal = driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"));
        bal.clear();
        bal.sendKeys("100000"); 
        
        //voluntary contributes
        WebElement vol = driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/div/input"));
        vol.clear();
        vol.sendKeys("90"); 
        
        //Fortnightly
        driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[1]/div")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Fortnightly')]")).click(); 
        
        
        //Risk Profile-Conservative       
        driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[5]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div/label/span[2]/span")).click(); 
        
        //saving goals
        WebElement goals = driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"));
        goals.clear();
        goals.sendKeys("290000"); 
        
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[2]/button/span[2]")); 
        JavascriptExecutor js = (JavascriptExecutor) driver;      
        js.executeScript("arguments[0].click();", ele);
        
        //Click on Button
        //driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[2]/button/span[2]")).click();
  	
    }
    
    
    //Acceptance Criteria
    //User whose current aged 55 is not employed, current KiwiSaver balance is $140000, voluntary contributes $10 annually and chooses Balanced risk profile with saving goals requirement of $200000 
    //is able to calculate his projected balances at retirement.
    public static void Scenario3() {
        WebElement age = driver.findElement(By.xpath("//*[@id='widget']/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/input"));
        age.clear();
        age.sendKeys("55");	
            
        //EmploymentStatus	
        driver.findElement(By.xpath("//div[@ng-model='ctrl.data.EmploymentStatus']//div//div[@class='control-well']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Not employed')]")).click(); 

        //current KiwiSaver balance
        WebElement bal = driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"));
        bal.clear();
        bal.sendKeys("140000"); 
        
        //voluntary contributes
        WebElement vol = driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/div/input"));
        vol.clear();
        vol.sendKeys("10"); 
        
        //Annually
        driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[1]/div")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Annually')]")).click(); 
        
        //Risk Profile-Balanced       
        driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[5]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[3]/div/label/span[2]/span")).click(); 
        
        //saving goals
        WebElement goals = driver.findElement(By.xpath("//*[@id=\'widget\']/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"));
        goals.clear();
        goals.sendKeys("200000"); 
        
        
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[2]/button/span[2]")); 
        JavascriptExecutor js = (JavascriptExecutor) driver;      
        js.executeScript("arguments[0].click();", ele);
        
        //Click on Button
        //driver.findElement(By.xpath("//*[@id=\"widget\"]/div/div[1]/div/div[2]/button/span[2]")).click(); 
    }
}



