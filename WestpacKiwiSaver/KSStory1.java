package WestpacKiwiSaver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.*;	

//User Story 1
//Acceptance Criteria
//Given User Clicks information icon besides Current age the message “This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver.” 
//is displayed below the current age field


public class KSStory1 {
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
        currentElement.sendKeys("65");	
        
        // click on information icon of Current age		
        WebElement  ageIcon = driver.findElement(By.xpath("//div[@help-id='CurrentAge']//button[@type='button']"));
        //Perform Click on Age Icon button using JavascriptExecutor		
        js.executeScript("arguments[0].click();",ageIcon);
        
        WebElement  ageIconMsg = driver.findElement(By.xpath("//*[@id='widget']/div/div[1]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/p"));
        String actualTooltip = ageIconMsg.getText();
        System.out.println(actualTooltip);
        
        String expectedTooltip = "This calculator has an age limit of 64 years old as you need to be under the age of 65 to join KiwiSaver." ;
        
        //Assert the tooltip's value is as expected 		
        System.out.println("Actual Title of Tool Tip"+actualTooltip);							
        if(actualTooltip.equals(expectedTooltip)) {							
           System.out.println("Test Case Passed - Title matched");					
        }	
        else {
        	System.out.println("Test Case Failed - Title not matched");
        }
        	
       driver.close();			
   }	
    
}


