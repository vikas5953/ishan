package com.evs.vtiger.testscripts;

import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.Marketing.Accounts.Accountslandingpage;
import com.evs.vtiger.Marketing.Accounts.CreateAccountdetailspage;
import com.evs.vtiger.Myhomepage.Home.Homepage;
import com.evs.vtiger.genericlayer.WebDriverUtil;
import com.evs.vtiger.loginpage.Loginpage;

public class AccountTestScripts {


	public static void main(String[] args) {
		
	}

	public   void verifyaccountcreate() {
		WebDriverUtil wu= new WebDriverUtil("tc002", "accountreport");
		wu.launcbowser("chrome");
		Loginpage l=	wu.openurl("http:localhost:8888");
		//Loginpage l=PageFactory.initElements(wu.getdriver(),Loginpage.class);
		//Loginpage l= new Loginpage();
		Homepage hm=	l.validlogin(wu);
		Accountslandingpage acc=hm.gotoMarketingAccountlandingpage(wu);
		CreateAccountdetailspage cl	=acc.createaccount(wu);
		cl.accountdetailspage(wu);
		cl.savebutton(wu);
		wu.flushh();


	}

}

