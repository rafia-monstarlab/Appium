package Base;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class baseclass {
	
	static AppiumDriver<MobileElement> driver;
	
	@BeforeClass
	public static void openApplication() throws Exception {
		
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", "emulator-5558");
			cap.setCapability("platformName", "android");
			cap.setCapability("platformVersion", "12");
		
			cap.setCapability("appPackage", "com.jayway.contacts");
			cap.setCapability("appActivity", "com.jayway.contacts.MainActivity");
			cap.setCapability("app", "/Users/rafiatabassum/Documents/Contacts.apk");
		
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, cap);
		
			System.out.println("Application Started....");
			}
		
		catch (Exception exp) {
			System.out.println("Cause is :" +exp.getCause());
			System.out.println("Message is :" +exp.getMessage());
			exp.printStackTrace();
			}
	}
	@Test
	public void sampleTest() {
		System.out.println("Test Demo 1");
		MobileElement searchnameTxtFld = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.EditText");
		searchnameTxtFld.sendKeys("Jenny");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}

