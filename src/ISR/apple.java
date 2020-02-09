package ISR;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

    public class apple {
	public WebDriver driver;
	
			@BeforeTest
			public void setup() throws InterruptedException, IOException {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\Chrome\\chromedriver.exe");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
				Properties prop =new Properties();
				FileInputStream ip = new FileInputStream("C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\config.properties");
				prop.load(ip);
				
				Properties prop1 = new Properties();
				FileInputStream ip1 = new FileInputStream("C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\path.properties");
				prop1.load(ip1);
				
				driver.get("url");
				driver.manage().window().maximize();
				Thread.sleep(8000);
	            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Actions at = new Actions(driver);
			    driver.findElement(By.xpath(prop1.getProperty("user_signin_signup"))).click();
			   
			    Thread.sleep(10000);
			    driver.findElement(By.xpath(prop1.getProperty("user_email_field"))).sendKeys(prop.getProperty("user_email_id"));
			    driver.findElement(By.xpath(prop1.getProperty("user_password_field"))).sendKeys(prop.getProperty("user_password"));
			    driver.findElement(By.xpath(prop1.getProperty("login_button_of_user"))).click();
			   
	            Thread.sleep(5000);
	           
			   List<WebElement> L1= driver.findElements(By.xpath(prop1.getProperty("user_edit_profile_link_on_header']")));
			   int i = L1.size();
			   L1.get(i-1).click();
		       WebElement web10= driver.findElement(By.xpath(prop1.getProperty("user_edit_organization_link_from_profile_dropdown")));
		       at.click(web10).build().perform();
		       Thread.sleep(5000);
			   }	

            @Test (priority =1)
			public void Verify_organization_name() throws InterruptedException, IOException {
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	
			Properties prop1 = new Properties();
			FileInputStream ip1= new FileInputStream("C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\path.properties");
			prop1.load(ip1);
		    WebElement web0 = driver.findElement(By.xpath(prop1.getProperty("orga_name_of_orga_on_org_detail_page")));
		    
		    boolean actual_result = web0.isEnabled();
		    boolean expected_result = false;
		    
		    Assert.assertEquals(actual_result, expected_result);
		    }
		    
            @Test(priority =2)
            public void test2_edit_organization_personal_details() throws IOException, InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Properties prop = new Properties();
    		FileInputStream ip= new FileInputStream("C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\path.properties");
    		prop.load(ip);
            Properties prop1 = new Properties();
    		FileInputStream ip1= new FileInputStream("C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\path.properties");
    		prop1.load(ip1);
    		
	        WebElement web1 = driver.findElement(By.xpath(prop1.getProperty("org_area_of_activity_on_org_detail_page ")));
	        Select se1 =new Select(web1);
	        se1.selectByValue("1");
	        
	        WebElement web2 = driver.findElement(By.xpath(prop1.getProperty("org_office_address_on_org_detail_page")));
	        web2.sendKeys(Keys.CONTROL + "a");
	        web2.sendKeys(Keys.DELETE);
	        web2.sendKeys("noida, uttar pradesh, India");
	        
	        WebElement scl1 =driver.findElement(By.xpath(prop1.getProperty("scroll_page_on_org_detail_page")));
	        scl1.click();
	        
	        WebElement web3 =driver.findElement(By.xpath(prop1.getProperty("org_country_hq_on_org_detail_page")));
	        Select se3 = new Select(web3);
	        se3.selectByValue("103");
	        Thread.sleep(2000);
	        
	        WebElement web4 =driver.findElement(By.xpath(prop1.getProperty("org_state_on_org_detail_page")));
	        Select se4 = new Select(web4);
	        se4.selectByValue("824");
	        
	        scl1.click();

	        WebElement web5 =driver.findElement(By.xpath(prop1.getProperty("org_country_of_operation_on_org_detail_page")));
	        Select se5 = new Select(web5);
	        se5.selectByVisibleText("Antarctica");
	        Thread.sleep(2000);
	        
	        js.executeScript("arguments[0].scrollIntoView();", scl1);
	        
	        WebElement web6 = driver.findElement(By.xpath(prop1.getProperty("org_preferred_currency_on_org_detail_page")));
	        Select se6 =new Select(web6);
	        se6.selectByValue("2");
	        
	        WebElement web7 =driver.findElement(By.xpath(prop1.getProperty("org_preffered_language_org_detail_page")));
	        Select se7 =new Select(web7);
	        se7.selectByValue("2");
	        
	        WebElement web8 =driver.findElement(By.xpath(prop1.getProperty("org_preferred_timezone_on_org_detail_page")));
	        Select se8 = new Select(web8);
	        se8.selectByVisibleText("GMT+01:00(Europe/Bratislava)");
	       
	        WebElement web9 = driver.findElement(By.xpath(prop1.getProperty("org_org_description_on_org_detail_page")));
	        web9.sendKeys(Keys.CONTROL + "a");
	        web9.sendKeys(Keys.DELETE);
	        web9.sendKeys("this is an automation test123");
            
	        scl1.click();
	        js.executeScript("arguments[0].scrollIntoView();", scl1);
	        
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/form/div[13]/button")).click();
            }
            
            @Test(priority = 3)
            public void organization_document() throws InterruptedException, IOException {
	        WebElement web11= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/form/div[10]/div/div[2]/div[1]/div/div/div/div/button"));
	        WebElement web12= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/form/div[11]/div/div[2]/div[1]/div/div/div/div/button"));
	        WebElement web13= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/form/div[12]/div/div[1]/span/a/button"));
	        WebElement web14= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/form/div[12]/div/div[2]/span/a/button"));
	        
	        if (web11.isEnabled())
	        {
	        web11.click();
	        Thread.sleep(2000);
	        Runtime.getRuntime().exec("C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\data\\FCRA.exe");
	        }
	        else
	        {
	        web13.click();
	        }
	        
	        if (web12.isEnabled())
	        {
	        web12.click();
	        Thread.sleep(2000);
	        Runtime.getRuntime().exec("C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\data\\FCRA.exe");
	        }
	        else
	        {
	        web14.click();
	        }
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/form/div[13]/button")).click();
	        
	        Thread.sleep(10000);
	      
			}
			
	              }