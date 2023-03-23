package com.evs.vtiger.Marketing.Accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.genericlayer.WebDriverUtil;

public class Accountslandingpage {
	
	@FindBy(xpath ="//img[@title=\"Create Account...\"] ")
	private WebElement createbutton;
	//private WebDriverUtil webUtil;
 
//public Accountslandingpage(WebDriverUtil webUtil) {
//this.webUtil=webUtil;
//PageFactory.initElements(webUtil.getdriver(), Accountslandingpage.this);
//	
//	
//}
	
	public CreateAccountdetailspage  createaccount(WebDriverUtil webutil) {
		webutil.click(createbutton, "createaccountbutton");
		return PageFactory.initElements(webutil.getdriver(),CreateAccountdetailspage.class );
		
	}
}
