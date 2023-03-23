package framework;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.management.AttributeValueExp;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerautomate.ExtentReport;

public class WebDriverUtil {
	WebDriver driver;
	ExtentTest exttest;

	public void launcbowser(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			exttest.log(Status.PASS, "chromedriver launched sucessfully");
		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			exttest.log(Status.PASS, "edgedriver launched sucessfully");

		} else {
			exttest.log(Status.FAIL, "browser is incorrect");
		}

	}

	public void openurl(String url) {
		try {
			driver.get(url);
			exttest.log(Status.PASS, url + "> url is navigated successfully");

		} catch (Exception e) {
			driver.navigate().to(url);
			exttest.log(Status.INFO, MarkupHelper.createLabel(url + "navigated with alternate method----- navigate.to",
					ExtentColor.RED));

			e.printStackTrace();
		}
	}

	public String timestamp() {
		DateFormat time = new SimpleDateFormat("MM_dd_yyyy_HH_mm_SS");
		String actualtime = time.format(new Date());
		return actualtime;
	}
 private	ExtentReports ext ;
	public void getreport( String locationreport) {
		File fileobj = new File("target/"+locationreport + timestamp() + ".html");
		ExtentSparkReporter esr = new ExtentSparkReporter(fileobj);
		ext= new ExtentReports();
		ext.attachReporter(esr);
	}
	public void createtest( String testcasename) {
		
	
	     exttest=  ext.createTest(testcasename);
		
	}
	public void flushh() {
		// TODO Auto-generated method stub
		
ext.flush();
	}

	public void getsnapshot(String filename) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File from = tss.getScreenshotAs(OutputType.FILE);
		File to = new File("target/" + filename + timestamp() + ".png");
		try {
			Files.copy(from, to);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkelement(WebElement we, String elementname) {
		boolean status = false;
		if (we.isDisplayed() == true) {
			exttest.log(Status.PASS, elementname + " text box is  visible");
			if (we.isEnabled() == true) {
				exttest.log(Status.PASS, elementname + "text box is enabled");
				status = true;
			} else {
				exttest.log(Status.FAIL, elementname + " text box is not enabled");
				System.out.println("enability fail");
			}

		} else {
			System.out.println("displey fail");

			exttest.log(Status.FAIL, elementname+" text box is not visible");
		}
		return status;
	}

	public void entertextvalue(WebElement we, String elementname, String elementValue) {
		try {
			checkelement(we, elementname);
			we.clear();
			we.sendKeys(elementValue);
		} catch (Exception e) {
			getsnapshot("filename");

		}

	}

	public void click(WebElement we, String elementname) {
		try {
			boolean statusel = checkelement(we, elementname);
			if (statusel == true) {
				we.click();
				exttest.log(Status.PASS, "clicked performed successfully");
			} else {
				exttest.log(Status.FAIL, "clicked not performed sucessfully");
			}
		} catch (Exception e) {
			Actions act =  new Actions(driver);
			act.click();
			exttest.log(Status.PASS, "clicked performed with action method");
			getsnapshot("filename");

		}

	}

	public WebElement getwebelement( String locatortype,String locatorvalue) {
		WebElement we = null;

//		System.out.println(locatortype + "--" + locatorvalue);
		try {
			if (locatortype.equalsIgnoreCase("xpath")) {
				we = driver.findElement(By.xpath(locatorvalue));

			} else if (locatortype.equalsIgnoreCase("name")) {
				we = driver.findElement(By.name(locatorvalue));

			} else if (locatortype.equals("id")) {
				we = driver.findElement(By.id(locatorvalue));
			} else if (locatortype.equalsIgnoreCase("class")) {
				we = driver.findElement(By.xpath(locatorvalue));
			} else if (locatortype.equals("class")) {
				we = driver.findElement(By.className(locatorvalue));
			} else if (locatortype.equals("linktext")) {
				we = driver.findElement(By.linkText(locatorvalue));
			} else {
				exttest.log(Status.INFO, locatortype + "locator type is wrong");
			}

		} catch (Exception e) {
			getsnapshot("filename");

		}
		return we;
	}

	public List<WebElement> getList(String locatorvalue, String locatortype) {
		List<WebElement> listwe = null;
		try {
			if (locatortype.equalsIgnoreCase("xpath")) {
				listwe = driver.findElements(By.xpath(locatorvalue));

			} else if (locatortype.equalsIgnoreCase("name")) {
				listwe = driver.findElements(By.name(locatorvalue));

			} else if (locatortype.equals("id")) {
				listwe = driver.findElements(By.id(locatorvalue));
			} else if (locatortype.equalsIgnoreCase("class")) {
				listwe = driver.findElements(By.xpath(locatorvalue));
			} else if (locatortype.equals("class")) {
				listwe = driver.findElements(By.className(locatorvalue));
			} else if (locatortype.equals("linktext")) {
				listwe = driver.findElements(By.linkText(locatorvalue));
			} else {
				exttest.log(Status.INFO, locatortype + "locator type is wrong");
			}

		} catch (Exception e) {
			getsnapshot("filename");

		}
		return listwe;
	}

	public String getinnertext(WebElement we, String elementname) {

		boolean st = checkelement(we, elementname);
		String inxtxt = we.getText();
		exttest.log(Status.PASS, "innertext derived sucessfully-->" + inxtxt);
		return inxtxt;

	}

	public String getattribute(WebElement we, String elementname, String attributename) {
		String attributevalue = null;
		boolean st = checkelement(we, elementname);
		if (st == true) {
			attributevalue = we.getAttribute(attributename);
			exttest.log(Status.PASS, " attribute name get sucessfully");
		} else {
			exttest.log(Status.FAIL, " attrubutename failed");
		}
		return attributevalue;

	}

	public void validateattribute(WebElement we, String elementname, String expectedattribute, String attributename) {
		String actualattribute = getattribute(we, elementname, attributename);
		if (actualattribute.equalsIgnoreCase(actualattribute)) {
			exttest.log(Status.PASS,
					MarkupHelper.createLabel(actualattribute + expectedattribute + "is matched", ExtentColor.GREEN));
		} else {
			exttest.log(Status.PASS, MarkupHelper.createLabel(actualattribute + expectedattribute + "is not matched",
					ExtentColor.GREEN));

		}

	}

	public void Selectbyvalue(WebElement we, String elementname, String selectvaluetext) {
		try {

			boolean st = checkelement(we, elementname);
			if (st == true) {
				Select selobj = new Select(we);
				selobj.selectByValue(selectvaluetext);
				exttest.log(Status.PASS, "select by value sucessfully");
			}

		} catch (Exception e) {
			exttest.log(Status.FAIL, "select by value unsucessfully");

		}

	}

	public void GetFirstSelectedoptin(WebElement we, String elementname, String selectvaluetext) {

		try {

			boolean st = checkelement(we, elementname);
			if (st == true) {
				Select selobj = new Select(we);
				WebElement selected = selobj.getFirstSelectedOption();
				String text = selected.getText();
				exttest.log(Status.PASS, "select by value sucessfully" + text);
			}

		} catch (Exception e) {
			exttest.log(Status.FAIL, "select by value unsucessfully");

		}

	}

	public String Getalloption(WebElement we, String elementname) {
		String intxt = null;
		try {
			List l = null;
			boolean st = checkelement(we, elementname);
			if (st == true) {
				Select selobj = new Select(we);
				List<WebElement> sel = selobj.getOptions();
				for (int i = 0; i <= l.size() - 1; i++) {
					WebElement listxt = sel.get(i);
					intxt = listxt.getText();
					l.add(intxt);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return intxt;
	}

	public void Selectbyindex(WebElement we, String elementname, int indexvalue) {
		try {

			boolean st = checkelement(we, elementname);
			if (st == true) {
				Select selobj = new Select(we);
				selobj.selectByIndex(indexvalue);
				exttest.log(Status.PASS, "selectbyvalue sucessfully");
			}
		} catch (Exception e) {
			exttest.log(Status.PASS, "select by value unsucessfully");
		}

	}

	public List<WebElement> getallselected(WebElement we, String elementname) {
		List<WebElement> lst = null;
		try {
			boolean st = checkelement(we, elementname);
			if (st == true) {
				Select selobj = new Select(we);
				lst = selobj.getAllSelectedOptions();
				for (WebElement text : lst) {
					String selectedtext = text.getText();
					exttest.log(Status.PASS, "getallselected sucessfully" + selectedtext);

				}
			} else {
				exttest.log(Status.FAIL, "not sucessfully get firstselected ");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return lst;
	}

	public void Selectbyvisibletest(WebElement we, String elementname, String selectvisibletext) {
		try {
			boolean st = checkelement(we, elementname);
			if (st == true) {
				Select selobj = new Select(we);
				selobj.selectByVisibleText(selectvisibletext);
				exttest.log(Status.PASS, "selectby visibletext sucessfully");
			}
		} catch (Exception e) {
			exttest.log(Status.FAIL, "selectby visibletext unsucessfully");
		}

	}

	public void close() {
		driver.close();
		exttest.log(Status.INFO, " browser closed sucessfully");
	}

	public void maximize() {
		driver.manage().window().maximize();
		exttest.log(Status.INFO, "browser maximize sucessfully");
	}

	public void minimize() {
		driver.manage().window().minimize();
		exttest.log(Status.INFO, "browser minimized sucessfully");
	}

	public void waitForVisiblElementLocated(By locator, int timeoutofsecond) {
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutofsecond));
		webWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void invisibilityofElementLocated(By locator, int timeoutofsecond) {
		WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(timeoutofsecond));
		webwait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	public void elementToBeClickable(By locator, int timeoutofsecond) {
		WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(timeoutofsecond));
		webwait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public void elementToBeSelected(By locator, int timeoutofsecond) {
		WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(timeoutofsecond));
		webwait.until(ExpectedConditions.elementToBeSelected(locator));

	}

	public void usingFrameIndex(int indexno) {
		driver.switchTo().frame(indexno);
	}

	public void usingStringNameorId(String name) {
		driver.switchTo().frame(name);
	}

	public void usingFramElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void clickmultipleElement(WebElement we, String locatorvalue, String locatortype) {
		try {
			List<WebElement> listwe = getList(locatorvalue, locatortype);
			for (WebElement clickmultiple : listwe) {
				String text = clickmultiple.getText();
				boolean st = checkelement(we, locatortype);
				if (st == true) {
					we.click();
					exttest.log(Status.PASS,
							MarkupHelper.createLabel("clicked on multiple elements", ExtentColor.GREEN));
				} else {
					exttest.log(Status.FAIL, "not sucessfully on multipleelements");

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Actions actionable(WebElement we, String elementname) {
		Actions act = null;

		try {
			boolean st = checkelement(we, elementname);
			if (st == true) {
				act = new Actions(driver);

			} else {

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return act;
	}

	public void movetoelement(WebElement we, String elementname, int x, int y) {

		Actions act = actionable(we, elementname);
		boolean st = checkelement(we, elementname);
		try {
			if (st == true) {
				act.moveToElement(we).build().perform();
				exttest.log(Status.PASS, MarkupHelper.createLabel("clicked performed sucessfully", ExtentColor.GREEN));
			} else {
				exttest.log(Status.FAIL,
						MarkupHelper.createLabel("clicked not performed sucessfully", ExtentColor.RED));

			}

		} catch (Exception e) {
			act.moveByOffset(x, y);
		}
		// TODO: handle exception
	}

	public Point getelementlocation(WebElement we, String elementname) {
		Point location=null;
		try {
		boolean st = checkelement(we, elementname);
		
			if (st == true) {
				location = we.getLocation();
				int  x=	location.getX();
				int  y=  location.getY();
			} else {
				exttest.log(Status.FAIL, MarkupHelper.createLabel("element is not enable or visible", ExtentColor.RED));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return location;
	}
	public void validategetlocation(WebElement we, String elementname,int x,int y) {
		Point excpectedocation= new Point(x, y);
		Point actuallocation=	   getelementlocation(we, elementname);
		try {
			if(actuallocation.equals(excpectedocation)) {
				exttest.log(Status.PASS,actuallocation+"is matched with "+excpectedocation);
			}

		}catch (Exception e) {
			exttest.log(Status.FAIL, actuallocation+"is not matched with"+ excpectedocation);
			e.printStackTrace();
		}



	}

	public void actionclick(WebElement we, String elementname) {
		Actions act = actionable(we, elementname);

		boolean st = checkelement(we, elementname);
		try {
			if (st == true) {
				act.click();

			} else {
				exttest.log(Status.FAIL, MarkupHelper.createLabel("element not visible", ExtentColor.RED));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actiondragdrop(WebElement we, String elementname, WebElement source, WebElement target) {
		Actions act = actionable(we, elementname);

		boolean st = checkelement(we, elementname);
		try {
			if (st == true) {
				act.dragAndDrop(source, target);
				exttest.log(Status.PASS, MarkupHelper.createLabel("draganddrop performed successful for " + elementname,
						ExtentColor.GREEN));
			} else {

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void gettitle() {
		try {
			String title = driver.getTitle();
			exttest.log(Status.INFO, MarkupHelper.createLabel(title + " derived sucessfully", ExtentColor.GREEN));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validategettitleMatch(String expectedtitle) {
		String actualtitle = driver.getTitle();
		if (actualtitle.equalsIgnoreCase(expectedtitle)) {
			exttest.log(Status.INFO, MarkupHelper.createLabel(expectedtitle + "is matched", ExtentColor.GREEN));
		} else {
			exttest.log(Status.INFO, MarkupHelper.createLabel(expectedtitle + "is not matched", ExtentColor.RED));
		}
	}

	public void validatetext(WebElement we, String elementname, String expectedtext) {
		String actualtext = getinnertext(we, elementname);
		if (actualtext.equalsIgnoreCase(expectedtext)) {
			exttest.log(Status.INFO,
					MarkupHelper.createLabel(expectedtext + " derived sucessfully", ExtentColor.GREEN));

		} else {
			exttest.log(Status.INFO,
					MarkupHelper.createLabel(expectedtext + " not derived sucessfully", ExtentColor.RED));
		}

	}

	public void validateElementisEnabled(WebElement we, String elementname) {

		boolean status = we.isEnabled();
		if (status == true) {
			exttest.log(Status.PASS, MarkupHelper.createLabel(elementname + "is enabled", ExtentColor.GREEN));

		} else {
			exttest.log(Status.PASS, MarkupHelper.createLabel(elementname + "is not enabled", ExtentColor.RED));

		}
	}

	public void validateElementisdisabled(WebElement we, String elementname) {

		boolean status = we.isEnabled();
		if (status == false) {
			exttest.log(Status.PASS, MarkupHelper.createLabel(elementname + "is disabled", ExtentColor.GREEN));

		} else {
			exttest.log(Status.PASS, MarkupHelper.createLabel(elementname + "is enabled", ExtentColor.RED));

		}
	}

	public void validateElementisvisible(WebElement we, String elementname) {

		boolean status = we.isDisplayed();
		if (status == false) {
			exttest.log(Status.PASS, MarkupHelper.createLabel(elementname + "is visibled", ExtentColor.GREEN));

		} else {
			exttest.log(Status.PASS, MarkupHelper.createLabel(elementname + "is not visibled", ExtentColor.RED));

		}
	}

	public void getWindowHandleByTitle(String expectetitle, String url) {
		try {
			Set<String> windowhandle = driver.getWindowHandles();
			for (String handlevalue : windowhandle) {
				driver.switchTo().window(handlevalue);
				String actualtitle = driver.getTitle();
				if (actualtitle.equalsIgnoreCase(expectetitle)) {
					break;

				}
			}
			if (driver.getCurrentUrl().equals(url)) {
				exttest.log(Status.INFO, "Switched to window whose url is :-" + driver.getCurrentUrl());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void getWindowHandleByurl(String expectetitle) {
		try {
			Set<String> windowhandle = driver.getWindowHandles();
			for (String handlevalue : windowhandle) {
				driver.switchTo().window(handlevalue);
				String actualtitle = driver.getCurrentUrl();
				if (actualtitle.equalsIgnoreCase(expectetitle)) {
					exttest.log(Status.INFO, "Switched to window whose url is :- " + driver.getCurrentUrl());
					break;

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Dimension getsize(WebElement we, String elementname) {
		Dimension sizeofelement = null;
		try {
			boolean status = checkelement(we, elementname);
			if (status == true) {
				sizeofelement = we.getSize();
				int height = sizeofelement.getHeight();
				int width = sizeofelement.getWidth();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sizeofelement;
	}

	public void validatesize(WebElement we, String elementname, int width, int height) {
		Dimension expextedsize = new Dimension(width, height);
		Dimension actualsize = null;

		try {
			actualsize = getsize(we, elementname);
			if (actualsize.equals(expextedsize)) {
				exttest.log(Status.PASS, actualsize + "actualsize is matched with expectedsize" + expextedsize);

			} else {
				exttest.log(Status.FAIL, "miss matched");
			}

		} catch (Exception e) {
			e.printStackTrace();
			exttest.log(Status.FAIL, actualsize + "actualsize is matched with expectedsize" + expextedsize);
		}
	}

	public void alertaccept() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void alertdismiss() {
		try {
			driver.switchTo().alert().dismiss();
			;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void alertaccept(String value) {
		try {
			driver.switchTo().alert().sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alertgetext() {
		try {
			driver.switchTo().alert().getText();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void checkboxstatus(WebElement we,String elementname) {
		try {
			boolean status=checkelement(we, elementname);
			if(status==true) {
				we.isSelected();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closetab() {
		try {
		driver.close();
		exttest.log(Status.PASS,MarkupHelper.createLabel("current open tabs are closed",ExtentColor.GREEN));
	}catch (Exception e) {
		e.printStackTrace();
		exttest.log(Status.PASS,MarkupHelper.createLabel("current open tabs are notclosed",ExtentColor.RED));

	}
	}
		public void quit() {
			try {
			driver.quit();
			exttest.log(Status.PASS,MarkupHelper.createLabel("all opened tabs in current session tabs are closed",ExtentColor.GREEN));

			
		}catch (Exception e) {
		e.printStackTrace();
		exttest.log(Status.PASS,MarkupHelper.createLabel("all opened tabs in current session tabs are not closed",ExtentColor.GREEN));

		}

}

}