package vtigerautomate;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import practise.Loginscenario;

public class Screenshot {

	public static void main(String[] args) throws IOException {

//		WebDriver driver= new ChromeDriver();

  Loginscenario login=	 new Loginscenario();
	WebDriver driver=login.vtiger();
	
	
     TakesScreenshot str= (TakesScreenshot) driver;
      File fromscreenshot= str.getScreenshotAs(OutputType.FILE);
  File toScreenshot=  new File("AutomationReport//abc.png");
  Files.copy(fromscreenshot, toScreenshot);
  

	}

}
