package com.evs.vtiger.loginpage;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.Myhomepage.Home.Homepage;
import com.evs.vtiger.genericlayer.WebDriverUtil;

public class Loginpage {
 // private WebDriverUtil webutil;
	@FindBy(name="user_name")
  private WebElement usernameEd;
	
	@FindBy(name="user_password")
	private WebElement userpasswordEd;
	
	@FindBy(name="Login")
	private WebElement loginbt;
	
	@FindBy(name="login_theme")
	private WebElement logintheme;
	
	@FindBy(name="login_language")
	private WebElement loginlanguage;
	//	public Loginpage(WebDriverUtil webutil) {

//		this.webutil=webutil;
//		PageFactory.initElements(webutil.getdriver(),Loginpage.this);
//	
//}


	public Homepage validlogin(WebDriverUtil webutil) {
	
	webutil.entertextvalue(usernameEd, "usernamebox","admin");
	webutil.entertextvalue(userpasswordEd, "userpasswordbox", "admin");
    webutil.click(loginbt, "Loginbox");
    return PageFactory.initElements(webutil.getdriver(), Homepage.class);
     
	}
	public void invalidlogin(WebDriverUtil webutil) {
		
		webutil.entertextvalue(usernameEd, "usernamebox","admin1");
		webutil.entertextvalue(userpasswordEd, "userpasswordbox", "admin2");
	    webutil.click(loginbt, "Loginbox");


	}
	public void changecolour(int indexvalue,WebDriverUtil webutil) {
		webutil.Selectbyindex(logintheme, "themebox", indexvalue);
		


	}
	public void changelanguage(int indexvalue,WebDriverUtil webutil) {
		webutil.Selectbyindex(loginlanguage, "themebox", indexvalue);



	}
}

