package godaddy;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class GodaddyAutomate {

	public static void main(String[] args) throws InterruptedException {

		GodaddyAutomate driver=new GodaddyAutomate();
		//driver.tc001();
		//	driver.tc002();
		driver.tc003();


	}

	private void tc001() throws InterruptedException {

		WebDriver chrome= new ChromeDriver();
		chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		chrome.get("https://www.godaddy.com/");
		Dimension size=chrome.manage().window().getSize();
		System.out.println(size);
		chrome.manage().window().setSize(new Dimension(800, 900));
		Thread.sleep(10000);
		chrome.manage().window().maximize();
		chrome.close();
		//Dimension size=chrome.manage().window().getSize();


	}
	private void tc002() {
		WebDriver driver=	 new ChromeDriver();
		driver.navigate().to("https://www.godaddy.com/");
		driver.manage().window().setSize(new Dimension(500, 500));
		driver.manage().window().maximize();
		String title=	driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getCurrentUrl());
		driver.close();

	}

	private void tc003() {
		WebDriver driver=	 new ChromeDriver();
		driver.navigate().to("https://www.godaddy.com/");
		driver.manage().window().setSize(new Dimension(500, 500));
		driver.manage().window().maximize();
		String title=	driver.getTitle();
		System.out.println(title);
		String expected ="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";

		if (title.equalsIgnoreCase(expected)){
			System.out.println(" title matched");


		} else {
			System.out.println("title mismatched");

		}
		String url=	driver.getCurrentUrl();
		System.out.println(url);
		if (url.equalsIgnoreCase("https://www.godaddy.com/en-in")) {
			System.out.println("url matched");

		} else {
			System.out.println(" url mismatched");

		}
		String actualsource=driver.getPageSource();
		
		if (actualsource.contains(title   )) {
			System.out.println("web page matched");

		} else {
			System.out.println("webpage mismatched");

		}



	}


}
