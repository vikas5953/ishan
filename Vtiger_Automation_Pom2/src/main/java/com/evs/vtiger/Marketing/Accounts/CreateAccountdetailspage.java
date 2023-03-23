package com.evs.vtiger.Marketing.Accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.genericlayer.WebDriverUtil;

public class CreateAccountdetailspage{
	
	@FindBy(name="accountname")
	private WebElement accountnameed;	
	

	@FindBy(xpath ="//input[@value=\"T\"]")
	private WebElement assigntypeclick;	
	
	@FindBy(id="//input[@value=\"T\"]")
	private WebElement phonebookEd;	
	
	@FindBy(xpath ="//textarea[@name=\"description\"]//parent::td//parent::tr//following-sibling::tr//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveclickbt;	
	
	
	
	//private WebDriverUtil webUtil;
 
//public CreateAccountdetailspage(WebDriverUtil webUtil) {
//	this.webUtil=webUtil;
//	PageFactory.initElements(webUtil.getdriver(), CreateAccountdetailspage.this);
//	}

	
	public void savebutton(WebDriverUtil webutil) {
	
	 webutil.click(saveclickbt," savebutton");
	}
	
	public void accountdetailspage(WebDriverUtil webutil) {
		webutil.entertextvalue(accountnameed,"accountnamebox","vikas2");	
		webutil.click(assigntypeclick,"assigntype");
		webutil.entertextvalue(phonebookEd, "phonebox", "9619599256");
		
		
	}
}
