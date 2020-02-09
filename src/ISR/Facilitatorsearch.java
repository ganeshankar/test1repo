package ISR;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Facilitatorsearch {
	public WebDriver driver;
	String account = null;
	
	
	@BeforeTest
	public void setup() throws AWTException, InterruptedException, AWTException   {	
	   ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganesh\\eclipse-workspace\\Selenium\\Chrome\\chromedriver.exe");
	driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("http://staging.abillionhopes.com/");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	  driver.findElement(By.xpath("//span[text()='Sign in/Sign up']")).click();
	  driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ganesh.shankar123456+1140@gmail.com");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ganesh@1920");
	  
	  Thread.sleep(5000);
      driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/form/div[4]/button/span[1]")).click();

	  driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[3]/a[2]/span")).click();
	}

	@Test(priority =0)
	public void searchbyname() throws AWTException, InterruptedException, ClassNotFoundException, SQLException {
	driver.findElement(By.xpath("//*[@id=\"responsiveFilterForm\"]/div[1]/form/div/div/input")).sendKeys("Ganesh");
	Thread.sleep(2000);
	Robot rob = new Robot();
	rob.keyPress(KeyEvent.VK_ENTER);  
	rob.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(5000);

	List<WebElement> L1= driver.findElements(By.xpath("//*[@id=\"undefined\"]/div[2]/div"));
	  int s11 = L1.size();
	  String actualresult =String.valueOf(s11);
	  System.out.println("number of user:" +actualresult);
	  
	  String expectedresult =account;
	  System.out.println(expectedresult);
	  Assert.assertEquals(actualresult,expectedresult);
	 
	}
	
	  public void database() throws ClassNotFoundException, SQLException {
		 
		  Class.forName("org.postgresql.Driver");
			Connection con =DriverManager.getConnection("jdbc:postgresql://staging.abillionhopes.com:5432/isr_uat","navyug","navyug");
			Statement stmt =con.createStatement();
			String s ="SELECT count(id) FROM users where role =1 and lower(firstname) LIKE 'ganesh' or lastname LIKE 'ganesh'";
			ResultSet rs =stmt.executeQuery(s);

			
			   while(rs.next()){
			     account = rs.getString("count");

			       System.out.println("BAID: " + account);
		       }	                             
			   
				con.close();
			  
			  
	  }
	}
	