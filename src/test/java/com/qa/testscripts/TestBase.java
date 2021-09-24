package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.MakeMyTripHotelPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase{
	public static WebDriver driver;
	public static MakeMyTripHotelPages mytrip;
	JavascriptExecutor js;
	@Parameters({"browser","url"})
	@BeforeClass
	public void setUp(String browser,String url) {
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		mytrip=new MakeMyTripHotelPages(driver);
		js=(JavascriptExecutor)driver;
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreenshot(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
	}
}
