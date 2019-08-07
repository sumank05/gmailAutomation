package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qait.automation.gmail.automation.ReadingTheTxtData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	WebDriver driver;
	String nodeUrl;
	String subjectText;
	String  randomString;
	 String dynamicText;
	
	ReadingTheTxtData obj = new ReadingTheTxtData() ;
	HashMap<String,String> newMap,mapYml;
	
	
	@Given("^I launch Chrome browser and Enter gmail URL$")
   public void launchBrower() throws IOException
   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\sumankumawat\\Downloads\\chromedrivernew\\chromedriver.exe");
		driver = new ChromeDriver();
	   
	   
		
		driver.get("https://mail.google.com");
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		newMap = obj.readingDataFromTextFile();
		mapYml = obj.readingDataFromYamlFile();
	   
   }
   
  
   // Method for a random string
   
   protected String getSaltString() {
       String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
       StringBuilder salt = new StringBuilder();
       Random rnd = new Random();
       while (salt.length() < 18) { // length of the random string.
           int index = (int) (rnd.nextFloat() * SALTCHARS.length());
           salt.append(SALTCHARS.charAt(index));
       }
       String saltStr = salt.toString();
       return saltStr;

   }
   
   @When("^I Enter <Email> in Email Address and <password> in password field$")
   public void enterUserCredentials()
   {
	   
	    
		WebElement emailBox = driver.findElement(By.xpath(newMap.get("userEmailBox")));
		
	    emailBox.sendKeys("sumankumawat3334@gmail.com");
	   
	    
	    
	    WebElement nextButton1 = driver.findElement(By.xpath("//span[@class = 'RveJvd snByac']"));
	    String dynamicText = nextButton1.getText();
	    settingValuesInPropertiesFile(dynamicText); // Storing Text of Button In Properties file
	    nextButton1.click();
	    
	    WebElement passBox = driver.findElement(By.xpath("//input[@name = 'password']"));
	   
	    //Explicit Wait
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    wait.until(ExpectedConditions.visibilityOf(passBox));
	   
	    passBox.sendKeys("Sumsa@432");
	   
	    WebElement nextButton2 = driver.findElement(By.cssSelector(" #passwordNext > span > span"));
	    WebDriverWait wait1 = new WebDriverWait(driver,10);
	    wait1.until(ExpectedConditions.visibilityOf(nextButton2));
	    nextButton2.click();
	 
   }
   public void settingValuesInPropertiesFile(String str)
   {
	   Properties prop = new Properties();

       try {
               InputStream in = new FileInputStream("testdata/Data.properties");
               prop.load(in);
           } catch (IOException ex) {
              System.out.println(ex);
           }
       System.out.println(str);
//Setting the value to  our properties file.
      
//       for (Map.Entry<String,String> mapInstance : mapYml.entrySet())
//       {
//    	   prop.setProperty(mapInstance.getKey(), mapInstance.getValue());
//       }
       prop.setProperty("ButtonText", str);
    
//Getting the value from  our properties file.
//  String value = prop.getProperty("Suman").trim();

      try {
              prop.store(new FileOutputStream("testdata/Data.properties"), null);
          } catch (IOException ex) {
            System.out.println(ex);
           }
   }
   
   
   @Then("^I verify that the gmail inbox page is displayed$")
   public void composingMail()
   {
	   WebElement composeButton = driver.findElement(By.xpath("//div[@class = 'z0']"));
	   WebDriverWait wait2 = new WebDriverWait(driver,30);
	   wait2.until(ExpectedConditions.visibilityOf(composeButton));
	   
	    composeButton.click();
	    
	    WebElement Text =  driver.findElement(By.xpath("//textarea[@id = ':r7']"));
	    WebDriverWait wait3 = new WebDriverWait(driver, 10);
	    wait3.until(ExpectedConditions.visibilityOf(Text));
	   Text.sendKeys("sumankumawat3334@gmail.com");
	   randomString = getSaltString();
	   driver.findElement(By.xpath("//input[@id = ':qp']")).sendKeys(randomString);
	   driver.findElement(By.xpath("//div[@id = ':ru']")).sendKeys("Hi..This is my body");
	   driver.findElement(By.xpath("//div[@id = ':qf']")).click();
	   
	   // Clicking on tables first element
	   WebElement FirstTableElement =  driver.findElement(By.xpath("//div[@class='aDP']//following::tr"));
	    WebDriverWait wait4 = new WebDriverWait(driver, 10);
	    wait4.until(ExpectedConditions.visibilityOf(FirstTableElement));
	    FirstTableElement.click();
	    
	     subjectText = driver.findElement(By.xpath("//div[@class = 'ha']//child::h2")).getText();
	    
	    
   }
   
   public String getSubjectText()
   {
	   return subjectText;
   }
   


}
