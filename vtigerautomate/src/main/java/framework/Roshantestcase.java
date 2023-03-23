package framework;

import org.openqa.selenium.WebElement;

public class Roshantestcase {
	WebDriverUtil obj ;
	public static void main(String[] args) {
		Roshantestcase rr = new Roshantestcase();
		rr.obj= new WebDriverUtil();
		rr.obj.getreport("roshan");
//		rr.validateSize();
//		rr.validatelocation();
		rr.verifyleads();
		rr.obj.flushh();

	}

	public void validateSize() {
		try {
			obj.createtest( "tcoo1");

			obj.launcbowser("chrome");
			obj.openurl("http:localhost:8888");

			WebElement ubox = obj.getwebelement("name", "user_name");
			obj.validatesize(ubox, "username Box", 140, 22);

			WebElement pbox = obj.getwebelement("xpath", "//input[@name='user_password']");
			obj.validatesize(pbox, "passwor box", 140, 23);

			WebElement lbox = obj.getwebelement("name", "Login");
			obj.validatesize(lbox, "login box", 138, 40);

			obj.closetab();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validatelocation() {
		try {
			obj.createtest( "tcoo2");

			obj.launcbowser("chrome");
			obj.openurl("http:localhost:8888");

			WebElement ubox = obj.getwebelement("name", "user_name");
			obj.validategetlocation(ubox, "usernamebox", 632, 230);

			WebElement pbox = obj.getwebelement("xpath", "//input[@name='user_password']");
			obj.validategetlocation(pbox, "passworbox", 632, 262);

			WebElement loginbox = obj.getwebelement("name", "Login");
			obj.validategetlocation(loginbox, "loginbox", 632, 250);

			obj.closetab();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyleads() {
		try {
		obj.createtest( "tcoo3");
		
		obj.launcbowser("chrome");

		obj.openurl("http:localhost:8888");
		WebElement ubox = obj.getwebelement("name", "user_name");
		obj.entertextvalue(ubox, "userbox", "admin");

		WebElement pbox = obj.getwebelement("xpath", "//input[@name='user_password']");
		obj.entertextvalue(pbox, "passworbox", "admin");

		WebElement lbox = obj.getwebelement("name", "Login");
		obj.click(lbox, "login button");

		WebElement Marketing = obj.getwebelement("linktext", "Marketing");
		obj.click(Marketing, "marketing button");

		WebElement leads = obj.getwebelement("xpath", "//td[@class=\"level2UnSelTab\"]//a[text()='Leads']");
		obj.click(leads, "leadbutton");

		WebElement createleadicon = obj.getwebelement("xpath","//img[@title='Create Lead...']");
		obj.click(createleadicon, "create lead");

		WebElement firstname = obj.getwebelement("name", "firstname");
		obj.entertextvalue(firstname, "first name", "vikas");

		WebElement lastname=	obj.getwebelement("name", "lastname");
		obj.entertextvalue(lastname, "last name", "yadav");

		WebElement companyname=   obj.getwebelement("xpath", "//input[@name=\"company\"]");
		obj.entertextvalue(companyname, "company", "yadav");

		WebElement assigned=obj.getwebelement("xpath", "//input[@name=\"assigntype\"][2]");
		obj.click(assigned, "Group");

		WebElement phone=  obj.getwebelement("id", "phone");
		obj.entertextvalue(phone, "phone", "9619599256");

		WebElement title=  obj.getwebelement("id", "title");
		obj.entertextvalue(title, "title", "Hari");

		WebElement email= obj.getwebelement("id","email");
		obj.entertextvalue(email, "emailid", "vy057913@gmail.com");

		WebElement save=	obj.getwebelement("xpath","//textarea[@name=\"description\"]//parent::td//parent::tr//following-sibling::tr//input[@title=\"Save [Alt+S]\"]" );
		obj.click(save, "savebutton");

	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
