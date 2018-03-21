package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDown {
	
	
	/**
	 * This Test verifies Default Option in a dropDown List
	 * 
	 * It takes WebElement element that is Drop Down List
	 * For assertion takes argument of String expectedOption
	 * @param element
	 * @param expectedOption
	 */
	@Test
	public static void dropDownDefaultTest(WebElement element, String expectedOption) {
		Select options = new Select(element);
		String actualOption = options.getFirstSelectedOption().getText();
		Assert.assertEquals(actualOption, expectedOption);
	}
	
	/**
	 * This Test clicks on an expectedOption and verifies that expected Element is selected.
	 * 
	 * It takes WebElement element that is Drop Down List
	 * For assertion verifies selectedOption is selected.
	 * @param element
	 * @param expectedOption
	 */
	@Test
	public static void dropDownSelectedTest(WebElement element, String expectedOption) {
		Select options = new Select(element);
		options.selectByVisibleText(expectedOption);
		System.out.println(options.getFirstSelectedOption());
		System.out.println(expectedOption);
		Assert.assertTrue(options.getFirstSelectedOption().getText().equals(expectedOption));
	}
	
	/**
	 * This Test verifies for all Options if they exist in configuration.properties file
	 * 
	 * Takes WebElement element that is DropDown List
	 * For List verifying it takes argument "allOptions" from Config.getProperty() and puts in a List.
	 * Note: expected List must be separated by comma and two spaces ",  ": *Reason is sometimes drop down has comma in the list
	 * @param element
	 */
	@Test
	public static void dropDownAllOptionsTest(WebElement element) {
		List<String> expectedOptions = Arrays.asList(Config.getProperty("allOptions").split(",  "));
		Select options = new Select(element);
		List<WebElement> listOfOptions = options.getOptions();
		for(int i = 0; i < listOfOptions.size(); i++) {
			Assert.assertEquals(listOfOptions.get(i).getText(), expectedOptions.get(i));
		}
		
	}
	
}
