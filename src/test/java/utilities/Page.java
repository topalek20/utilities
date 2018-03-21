package utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Page {
	private static WebDriver driver;
	
	public static void close() {
		driver.close();
	}
	
	@Test
	public static void verifyTite(String title) {
		Assert.assertTrue(driver.getTitle().equals(title));
	}
	
	@Test static void verifyURL(String url) {
		Assert.assertTrue(driver.getCurrentUrl().equals(url));
	}
	
	public static void closeAndSwitchPrevious(WebDriver driver) {
		String handle = driver.getWindowHandle();
		String newWindowHandle="";
		Set<String> windowHandles = driver.getWindowHandles();
		driver.close();
		// capture the handle of the tab which is not the current tab
		for (String each : windowHandles) {
			if (!each.equals(handle)) {
				newWindowHandle = each;
			}
		}
		// switch to new window using the handle of the new window
		driver.switchTo().window(newWindowHandle);
	}
	public static void switchNextWindow(WebDriver driver) {
		String handle = driver.getWindowHandle();
		String newWindowHandle="";
		Set<String> windowHandles = driver.getWindowHandles();
		// capture the handle of the tab which is not the current tab
		for (String each : windowHandles) {
			if (!each.equals(handle)) {
				newWindowHandle = each;
			}
		}
		// switch to new window using the handle of the new window
		driver.switchTo().window(newWindowHandle);
	}

}
