package vtigerautomate;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport
{

	public static void main(String[] args) throws IOException {

		File fileobj=new File(System.getProperty("user.dir")+"//AutomationReport//bbc.html");
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(fileobj);

		ExtentReports extreport= new ExtentReports();
		extreport.attachReporter(htmlreport);

		ExtentTest extest = extreport.createTest("tc001");

		//WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		extreport.setSystemInfo("OSNAME",System.getProperty("os.name"));

		extest.log(Status.INFO, " chromedriver launched sucessfully");
		driver.get("http://localhost:8888");
		extest.log(Status.INFO, " Url Navigated http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		extest.log(Status.INFO,"usernmae entered sucessfully");

		driver.findElement(By.name("user_password")).sendKeys("admin");
		extest.log(Status.INFO," userpassword is entered sucessfully");

		driver.findElement(By.name("Login")).click();
		extest.log(Status.INFO,"login sucessfully");

		boolean visibility=   driver.findElement(By.xpath("//a[text()='Marketing']")).isDisplayed();
		if (visibility) {
			extest.log(Status.PASS, "Marketing button is visible");

		}else {
			extest.log(Status.FAIL,"Marketing button is visible");
		}	

		TakesScreenshot str= (TakesScreenshot) driver;
		Date datetime= new Date();
		long time= datetime.getTime();
		int date= datetime.getDate();

		// System.out.println(time);
		// System.out.println(date);
		System.out.println(datetime);
		File fromscreenshot= str.getScreenshotAs(OutputType.FILE);
		File toScreenshot=  new File("AutomationReport//abc"+datetime.toString().replace(":", "_")+".png");
		Files.copy(fromscreenshot, toScreenshot);
		extest.addScreenCaptureFromPath(toScreenshot.getAbsolutePath());



		extreport.flush();
		//	Socket Exception;
		driver.close();

	}

}
