package com.qa.testscripts;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.MakeMyTripHotelData;

public class TC_MakeMyTripHotelReservation_01 extends TestBase{

	@Test(dataProvider = "excelData1")
	public void enterDetails(String city,String location,String startDate,String endDate,String adults,String Children,String age) throws InterruptedException, IOException, ParseException {
		js.executeScript("arguments[0].click();",mytrip.getHotels());
		Actions ac=new Actions(driver);
		ac.doubleClick(mytrip.getCity()).build().perform();
		Thread.sleep(2000);
		mytrip.getCityName().sendKeys(city);
		Thread.sleep(2000);
		List<WebElement> cities=mytrip.getSuggestionList();
		for (WebElement element : cities) {
			if(element.getText().contains(location)) {
				js.executeScript("arguments[0].click()", element);
				break;
			}
		}
		js.executeScript("arguments[0].click();", mytrip.getCheckIn());
		Thread.sleep(3000);
		selectDate(startDate);
		
		Thread.sleep(1000);
		selectDate(endDate);

		js.executeScript("arguments[0].click();", mytrip.getRoomsndGuests());

		List<WebElement> noOfAdults=mytrip.getNoOfAdults();
		int noadults=Integer.parseInt(adults);
		if(noadults>=0 && noadults<12) {
			js.executeScript("arguments[0].click();", noOfAdults.get(noadults-1));
			Assert.assertTrue(true);
		}
		else {
			captureScreenshot("enterDetails");
			Reporter.log("no of adults should be less than 12");
			Assert.assertTrue(false);
		}

		List<WebElement> noOfChildren=mytrip.getNoOfChildren();
		int nochild=Integer.parseInt(Children);
		js.executeScript("arguments[0].click();", noOfChildren.get(nochild));
		if(nochild>0 && nochild<=4)
		{
			Select dropdown=new Select(mytrip.getAge());
			int childAge=Integer.parseInt(age);
			if(childAge>=1 && childAge<=12) {
				dropdown.selectByIndex(childAge);
			}
			else {
				captureScreenshot("enterDetails");
				Assert.assertTrue(false);
			}
		}
		
		mytrip.getApplyButton().click();
		mytrip.getsearchResult().click();
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("MakeMyTrip"))
			Assert.assertTrue(true);
		else {
			captureScreenshot("enterDetails");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);

		List<WebElement> starrating=mytrip.getStarRatingList();
		if(starrating.size()>0)
		js.executeScript("arguments[0].click();", starrating.get(1));
		Thread.sleep(3000);

		List<WebElement> rating=mytrip.getRatingList();
		if(rating.size()>0)
		js.executeScript("arguments[0].click();", rating.get(1));
		Thread.sleep(3000);

		/*
		 * js.executeScript("window.scrollBy(0,1500)"); Thread.sleep(3000);
		 * //driver.findElement(By.id("hlistpg_proptypes_show_more")).click();
		 * List<WebElement> property=mytrip.getPropertyType(); property.get(1).click();
		 * Thread.sleep(3000);
		 */

		/*
		 * js.executeScript("window.scrollBy(0,1800)"); Thread.sleep(3000);
		 * List<WebElement> language=mytrip.getHostLanguage(); language.get(4).click();
		 * Thread.sleep(3000);
		 */

		List<WebElement> hotels=mytrip.getHotelNames();
		List<WebElement> hotelPrices=mytrip.getHotelPrice();
		int size=hotels.size();
		if(size>0) {
			for(int i=0;i<size;i++) {
				Reporter.log(hotels.get(i).getText()+"  "+hotelPrices.get(i).getText().substring(2));
			}
			Thread.sleep(3000);
			WebElement hotel=mytrip.getHotelNames().get(0);
			js.executeScript("arguments[0].click();", hotel);
			//hotel.click();

			Set<String> handle = driver.getWindowHandles();
			for(String s:handle) {
				driver.switchTo().window(s);
			}
			Thread.sleep(5000);

			//Assert.assertEquals("The Westin Hyderabad Mindspace | Hotel Details Page | MakeMyTrip.com", driver.getTitle());
			Thread.sleep(3000);


			/*for(int i=0;i<10;i++) {
				js.executeScript("window.scrollBy(0,200)");
				Thread.sleep(3000); 
			}
			mytrip.getbookCombo().get(0).click();
			driver.manage().deleteAllCookies();
			Thread.sleep(3000);*/
			
			driver.navigate().to("https://www.makemytrip.com/");
		}
		else {
			captureScreenshot("enterDetails");
			Assert.assertTrue(false);
		}

	}

	@DataProvider(name="excelData1")
	public Object[][] getExcelDetails1() throws IOException
	{
		Object obj[][]=MakeMyTripHotelData.getDatas("HotelData","Sheet1");
		return obj;
	}

	public static void selectDate(String gDate) throws InterruptedException, ParseException {
		SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MMM-dd");
		String d1=sdfo.format(new Date());
		String d2=gDate;
		String[] givendate=d2.split("-");

		String[] ldate=d1.split("-");
		String lday=Integer.toString(Integer.parseInt(ldate[2])-1);
		String lyear=Integer.toString(Integer.parseInt(ldate[0])+1);
		String d3=lyear+"-"+ldate[1]+"-"+lday;

		Date date1 = sdfo.parse(d1);   
		Date date2 = sdfo.parse(d2);	
		Date date3 = sdfo.parse(d3);
		if ((date2.after(date1) && date2.before(date3)) || date1.equals(date2))
		{  
			System.out.println("pass");   
		}  
		else if (date2.before(date1))   
		{    
			Reporter.log("Select valid date");
			Assert.assertTrue(false);  
		}   

		WebElement m1;
		WebElement m2;
		boolean flag=true;
		int temp=1;
		while(flag) {
			m1=mytrip.getcalendar1();
			m2=mytrip.getcalendar2();                              
			if(m1.getText().contains(givendate[1]) && m1.getText().contains(givendate[0]))
			{
				temp=2;
				flag=false;
			}
			else if(m2.getText().contains(givendate[1]) && m1.getText().contains(givendate[0])) {
				temp=1;
				flag=false;
			}
			else {
				mytrip.getNextNav().click();
				Thread.sleep(3000);
			}
		}
		int count=0;
		List<WebElement> col=null;
		if(temp==1) {
		    col=mytrip.getcalendar1Dates();
		}
		else if(temp==2) {
			col=mytrip.getcalendar2Dates();
		}
		for(WebElement c:col) {
			if(c.getText().equals("1"))
			{
				break;
			}
			else {
				count++;
			}
		}

		col.get(Integer.parseInt(givendate[2])-1+count).click();

	}
}
