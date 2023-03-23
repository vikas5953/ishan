package com.evs.vtiger.Marketing.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.genericlayer.WebDriverUtil;

public class LeadLandingPage {
	
	@FindBy(xpath="//img[@title='Create Lead...']")
    private WebElement clickbt;
	//private WebDriverUtil webutil;
	
//	public LeadLandingPage(WebDriverUtil webutil) {
//		this.webutil=webutil;
//		PageFactory.initElements(webutil.getdriver(), LeadLandingPage.this);
//		
//	}

	
	public CreateLeadpage clickcreateButton(WebDriverUtil webutil) {
		System.out.println("hii");
		webutil.click(clickbt, "leadbutton");
		System.out.println("hiieee");

		 return PageFactory.initElements(webutil.getdriver(), CreateLeadpage.class);
		
	}
}
