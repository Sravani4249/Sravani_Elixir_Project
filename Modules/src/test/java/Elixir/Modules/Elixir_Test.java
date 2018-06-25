package Elixir.Modules;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Elixir_Test {
  
	static WebDriver driver;

  @BeforeTest
  public static void browser() throws Exception {
		//driver is an instance variable, which can be accessed by all methods
		System.setProperty("webdriver.chrome.driver","F:\\Selenium 3.12.0\\chromedriver.exe");
		driver=new ChromeDriver();
		//to insert URL in the browser
		driver.get("http://demo.elixiraid.com/index.php");
		//to maximize the browser window
		driver.manage().window().maximize();
	}
  
  @Test(priority=0)
  public void login() throws Exception{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"UserLogin_username\"]")).sendKeys("admin");
		//wait 5 seconds for password to be entered
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"UserLogin_password\"]")).sendKeys("admin");
      //wait 5 seconds to click on sign-in button
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/form/div[4]/input")).click();
	}
  
/*@Test(priority=1)
public void dashboard()throws Exception{
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/ul/li[6]/a")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/ul/li[6]/ul/li[1]/a")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"Doctorspecialization_specialization\"]")).sendKeys("cardiologist");
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id=\"doctorspecialization-form\"]/div/div[1]/div/div[2]/div[2]/input")).click();
}*/
  @Test
  public void phar_mgmt()throws Exception{
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
  	Thread.sleep(5000);
  	//to click on phar mgmt
  	driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/ul/li[9]/a/span")).click();
  	Thread.sleep(5000);
  	//to click on allvendors
  	driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/ul/li[9]/ul/li[2]/a")).click();
  	Thread.sleep(10000);
  	//to click on view details
  	driver.findElement(By.xpath("//html//tr[2]/td[7]/a[1]")).click();
  	//wait for dialog box to close
  	Thread.sleep(3000);
  	//to click on the close icon
  	driver.findElement(By.xpath("//button[@type='button']")).click();
  }
  
  
  @AfterTest
  public void logout() throws Exception{
	  
	  driver.quit();
  }

}
