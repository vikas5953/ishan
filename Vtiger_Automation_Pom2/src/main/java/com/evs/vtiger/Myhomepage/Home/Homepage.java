package com.evs.vtiger.Myhomepage.Home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.Marketing.Accounts.Accountslandingpage;
import com.evs.vtiger.Marketing.Accounts.CreateAccountdetailspage;
import com.evs.vtiger.Marketing.leads.LeadLandingPage;
import com.evs.vtiger.genericlayer.WebDriverUtil;

public class Homepage {
	
//private WebDriverUtil webutil ;
	
// public Homepage(WebDriverUtil webutil) {
//this.webutil=webutil;
//PageFactory.initElements(webutil.getdriver(),Homepage.this);
//	
//}
	 @FindBy(linkText="Marketing")
	private WebElement Marketing;
	 
	 @FindBy(linkText="Accounts")
		private WebElement MkAccountbt;
	 
	 @FindBy(linkText="Leads")
		private WebElement Mkleadbt;
	 
	 @FindBy(linkText="Campaigns")
		private WebElement Mkcampaignbt;
	 
	 

	public Accountslandingpage gotoMarketingAccountlandingpage(WebDriverUtil webutil) {
		webutil.movetoelement(Marketing, "marketingtab");
		webutil.click(MkAccountbt, "Accounts");
		return PageFactory.initElements(webutil.getdriver(), Accountslandingpage.class);
		
		

	}
	public LeadLandingPage gotoMarketingLeadslandingpage(WebDriverUtil webutil) {
		webutil.movetoelement(Marketing, "marketingtab");
		webutil.click(Mkleadbt, "leadstab");
	return	PageFactory.initElements(webutil.getdriver(), LeadLandingPage.class);


	}
	public void gotoMarketingCampaignlandingpage(WebDriverUtil webutil) {
		webutil.movetoelement(Marketing, "marketingtab");
		webutil.click(Mkcampaignbt, "Campaignstab");


	}
}

