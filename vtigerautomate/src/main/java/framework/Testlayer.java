package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testlayer {
	
	WebDriver driver;
	ExtentTest ext;
	 public static void main(String[] args) {
		 Testlayer obj= new Testlayer();
			obj.verifycreadlead();		
	}
	
	public void verifycreadlead()  {
		WebDriverUtil tt= new WebDriverUtil();
		tt. getreport("target");
		tt.createtest( "tc001");
		tt.launcbowser("chrome");
    	tt.openurl("http:localhost:8888");
	
		WebElement unmElement =tt. getwebelement("user_name", "name");

	    tt.entertextvalue(unmElement, "User Name", "admin");
		tt.getinnertext(unmElement, "User Name");
		tt.getattribute(unmElement, "user name", "name");

		WebElement pswElement =tt. getwebelement("user_password", "name");
		tt.entertextvalue(pswElement, "password box", "admin");
		tt.getinnertext(pswElement, "password box");
		tt.getattribute(pswElement, "passworbox", "name");

		WebElement selElement = tt.getwebelement("login_theme", "name");
		tt.Selectbyvalue(selElement, "colortheme", "bluelagoon");
		tt.Selectbyindex(selElement, "colortheme", 2);
		tt.Selectbyvisibletest(selElement, "colortheme", "woodspice");

		WebElement loginElement = tt.getwebelement("Login", "name");
		tt.click(loginElement, "Loginbutton");
		tt.getsnapshot("secondreport");
       tt.flushh();

	

	}



	
	
	
	

}
