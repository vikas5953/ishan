package com.evs.vtiger.testscripts;

import com.evs.vtiger.Marketing.leads.CreateLeadpage;
import com.evs.vtiger.Marketing.leads.LeadLandingPage;
import com.evs.vtiger.Myhomepage.Home.Homepage;
import com.evs.vtiger.genericlayer.WebDriverUtil;
import com.evs.vtiger.loginpage.Loginpage;

public class LeadTestScipts {

	
	
		
	
		public void verifycreatelead() {
			WebDriverUtil webutil =new WebDriverUtil("tc001","reports");
			webutil.launcbowser("chrome");
			Loginpage ln=	webutil.openurl("http:localhost:8888");
			//Loginpage ln= new Loginpage();
			Homepage hm=	ln.validlogin(webutil);
			LeadLandingPage l=	hm.gotoMarketingLeadslandingpage(webutil);
			CreateLeadpage cl=	l.clickcreateButton(webutil);
			cl.Enterleaddetailpage(webutil);
			cl.saveleads(webutil);
			webutil.flushh();
			
		
		
	}
	
	
}
