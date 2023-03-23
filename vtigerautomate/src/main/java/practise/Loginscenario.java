package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginscenario {

	public static void main(String[] args) {

     vtiger();

	}

	public static WebDriver vtiger() {

		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
	
       return driver;


	}

}
