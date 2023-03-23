package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.chrome.ChromeDriver;

public class PrivateMethod {
	static int a=2/0;;
	public static void main(String[] args) throws FileNotFoundException {
		int a=2/0;;
		System.out.println(a);
		String s=null;
		System.out.println(s);
		
		int b=2/5;
		int c;
		try{
			new FileInputStream("dhgd");
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
			new ChromeDriver().get("dgdhdhd");;
			
	}

	

}
