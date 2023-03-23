package com.evs.vtiger.Marketing.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.genericlayer.WebDriverUtil;

public class CreateLeadpage {
	
	@FindBy(name="salutationtype")
	private WebElement selectbt;
	
	@FindBy(name="firstname")
	private WebElement nameed;
	
	@FindBy(name="lastname")
	private WebElement lastnameed;
	
	@FindBy(name="company")
	private WebElement companyed;
	
	@FindBy(id="designation")
	private WebElement employeeed;
	
	@FindBy(id="phone")
	private WebElement phoneed;
	
	@FindBy(name="email")
	private WebElement emailed;
	
	@FindBy(xpath = "//textarea[@name=\"description\"]//parent::td//parent::tr//following-sibling::tr//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebt;
	@FindBy(xpath = "//textarea[@name=\"description\"]//parent::td//parent::tr//following-sibling::tr//input[@title=\"Save [Alt+S]\"]")
	private WebElement cancelbt;
	
	
//	private WebDriverUtil webutil;
//	public CreateLeadpage(WebDriverUtil webutil) {
//		this.webutil=webutil;
//		PageFactory.initElements(webutil.getdriver(), CreateLeadpage.this);
//		
//	}


	public void saveleads(WebDriverUtil webutil) {
		webutil.click(savebt, "savebutton");

	}

	public void cancelleads(WebDriverUtil webutil) {
		webutil.click(cancelbt, "savebutton");


	}

	public void Enterleaddetailpage(WebDriverUtil webutil) {
		webutil.Selectbyindex(selectbt,"selectbox", 1);
		webutil.entertextvalue(nameed,"namebox","vikas55" );
		webutil.entertextvalue(lastnameed, "lastnamebox", "yadav");
		webutil.entertextvalue(companyed, "companyname", "yadav enterprises");
		webutil.entertextvalue(employeeed, "title", "emplyoee1");
		webutil.entertextvalue(phoneed,"phoneno" , "9619599256");
		webutil.entertextvalue(emailed, "emailbox", "vy057913@gmail.com");
		

	}














}
