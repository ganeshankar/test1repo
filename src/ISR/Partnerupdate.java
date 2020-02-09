package ISR;

	import java.util.List;
	import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

	        public class Partnerupdate {
	        public WebDriver driver;

			@BeforeMethod
			public void setup() throws InterruptedException {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\Chrome\\chromedriver.exe");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				driver.get("https://staging.abillionhopes.com/");
				driver.manage().window().maximize();
		        Thread.sleep(8000);
		 
		        driver.findElement(By.xpath("//span[text()='Sign in/Sign up']")).click();
		        Thread.sleep(10000);
		 
		}
			   
			@Test (priority =0)
			public void login() throws InterruptedException {
				// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 Actions at = new Actions(driver);
			   
			   driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ganesh.shankar+119@navyuginfo.com");
			   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ganesh@1920");
			   Thread.sleep(15000);
			   
			   driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/form/div[4]/button/span")).click();
			   
	           Thread.sleep(5000);
	           
			   List<WebElement> L1= driver.findElements(By.xpath("//div[@class='userCollapseClass']"));
			   int i = L1.size();
			   L1.get(i-1).click();
		       WebElement web10= driver.findElement(By.xpath("//span[text()='Edit Organization']"));
		       at.click(web10).build().perform();
		       Thread.sleep(5000);
		       driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[4]/div/div/ul/a[8]/li/div/span")).click();
	        	
	        	WebElement web36 =driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[1]/div/div/div/form/div[1]/div[2]/div/div/div/div/div/select"));
	        	Select se36 = new Select(web36);
	        	se36.selectByValue("any_angel");
	        	
	        	driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[1]/div/div/div/form/div[2]/button")).click();
	        	
	        	Thread.sleep(5000);
			   }	
			
	      @Test(priority =1, dependsOnMethods ="login")
	        public void login_angel() throws InterruptedException {

			   driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ganesh.shankar+118@navyuginfo.com");
			   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ganesh@1920");
			   
               Thread.sleep(15000);
			   
			   driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/form/div[4]/button/span")).click();
			   
	           Thread.sleep(5000);
			   
	           driver.get("https://staging.abillionhopes.com/beneficiary-profile/anjali-need-money-for-eye-test-1226-1");
	           
		/*
		 * driver.findElement(By.
		 * xpath("//span[text()='Find a poor family (Beneficiary)']")).click();
		 * 
		 * WebElement web1 =driver.findElement(By.xpath(
		 * "//div[@class='profile-search__left-panel']/div/form/child::div[4]/child::div[2]/div/div/div/child::div/div/select"
		 * )); Select se1 = new Select(web1); se1.selectByVisibleText("Help center 1");
		 * 
		 * List<WebElement> L40 =
		 * driver.findElements(By.xpath("//*[@id=\"undefined\"]")); int e =L40.size();
		 * L40.get(e-21).click();
		 */
	           
	           Thread.sleep(5000);
	           driver.findElement(By.xpath("//span[text()='Adopt this family']")).click();
	           driver.findElement(By.xpath("//span[text()='Yes, send request']")).click();
	           Thread.sleep(5000);
      
	      }
	
	       @Test(priority =2, dependsOnMethods ="login_angel")
	        public void login_facilitator() throws InterruptedException {

			   driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ganesh.shankar+303@navyuginfo.com");
			   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ganesh@1920");
			   Thread.sleep(15000);
			   
			   driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/form/div[4]/button/span")).click();
			   
	           Thread.sleep(5000);
	           driver.findElement(By.xpath("//*[@id=\"target\"]/div[2]/div/a[3]/span/span[1]")).click();
	           driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/ul/li[1]/div/div[4]/span")).click();
	       }
	      
	       @AfterMethod
	       public void print_line() {
	    	   System.out.println("completed");
	       }
	     
	        }