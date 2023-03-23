package godaddy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Godaddy2 {

	public static void main(String[] args) {
	  
		Godaddy2 obj=new Godaddy2();
		obj.tc001();
	

	}
	public void tc001() {
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://godaddy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.findElement(By.xpath("//button[@id=\"id-d6f9deab-d554-45df-a52c-8a9ab53948b5\"]")).click();
	System.out.println(	driver.getTitle());
		driver.findElement(By.xpath("//a[@id=\"id-3a34578f-40f3-4d2f-aaa4-0a1320f3fe6a\"]")).click();
	String title=	driver.getTitle();
	System.out.println(title);
	if(title.equalsIgnoreCase("Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN")) {
		 System.out.println(" passed");
	}else {
		System.out.println("fail");
		
	}
			
		
		
		
	}

}
