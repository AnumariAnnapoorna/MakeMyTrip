package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeMyTripHotelPages {

	WebDriver driver;
	public MakeMyTripHotelPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/span[1]")
	WebElement hotels;
	
	public WebElement getHotels() {
		return hotels;
	}
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	WebElement city;

	public WebElement getCity() {
		return city;
	}
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement cityName;
	
	public WebElement getCityName() {
		return cityName;
	}
	
	@FindAll(@FindBy(className="react-autosuggest__suggestion"))
	List<WebElement> suggestionList;
	
	public List<WebElement> getSuggestionList() {
		return suggestionList;
	}
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]")
	WebElement checkIn;
	
	public WebElement getCheckIn() {
		return checkIn;
	}
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")
	WebElement calendar1;
	
	public WebElement getcalendar1() {
		return calendar1;
	}
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]")
	WebElement checkOut;
	
	public WebElement getCheckOut() {
		return checkOut;
	}
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
	WebElement calendar2;
	
	public WebElement getcalendar2() {
		return calendar2;
	}
	
	@FindAll(@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div/div"))
	List<WebElement> calendar2Dates;
	
	public List<WebElement> getcalendar2Dates() {
		return calendar2Dates;
	}
	
	@FindAll(@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div/div"))
	List<WebElement> calendar1Dates;
	
	public List<WebElement> getcalendar1Dates() {
		return calendar1Dates;
	}
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[2]")
	WebElement nextNav;
	
	public WebElement getNextNav() {
		return nextNav;
	}
	
	@FindBy(id="guest")
	WebElement RoomsndGuests;
	
	public WebElement getRoomsndGuests() {
		return RoomsndGuests;
	}
	
	@FindAll(@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li"))
	List<WebElement> noOfAdults;
	
	public List<WebElement> getNoOfAdults() {
		return noOfAdults;
	}
	
	@FindAll(@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[2]/li"))
	List<WebElement> noOfChildren;
	
	public List<WebElement> getNoOfChildren() {
		return noOfChildren;
	}
	
	@FindBy(xpath="//select[@class=\"ageSelectBox\"]")
	WebElement age;
	
	public WebElement getAge() {
		return age;
	}
	
	@FindBy(xpath="//button[contains(text(),'APPLY')]")
	WebElement apply;
	
	public WebElement getApplyButton() {
		return apply;
	}
	
	@FindBy(id="hsw_search_button")
	WebElement search;
	
	public WebElement getsearchResult() {
		return search;
	}
	
	@FindAll(@FindBy(id="hlistpg_hotel_name"))
	List<WebElement> hotelsNames;
	
	public List<WebElement> getHotelNames() {
		return hotelsNames;
	}
	
	@FindAll(@FindBy(id="hlistpg_hotel_shown_price"))
	List<WebElement> hotelprice;
	
	public List<WebElement> getHotelPrice() {
		return hotelprice;
	}
	
	@FindAll(@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li"))
	List<WebElement> starRatingList;
	
	public List<WebElement> getStarRatingList(){
		return starRatingList;
	}
	
	@FindAll(@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[7]/ul[1]/li"))
	List<WebElement> ratingList;
	
	public List<WebElement> getRatingList(){
		return ratingList;
	}
	
	@FindBy(xpath="//button[@id='detpg_multi_view_combo']")
	WebElement viewCombo;
	
	public WebElement getViewCombo() {
		return viewCombo;
	}
	
	@FindAll(@FindBy(xpath="//span[@id='detpg_book_combo_btn']"))
	List<WebElement> bookCombo;
	
	public List<WebElement> getbookCombo() {
		return bookCombo;
	}
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/select[1]")
	WebElement title;
	
	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(id="fName")
	WebElement firstName;
	
	public WebElement getfirstName() {
		return firstName;
	}
	
	@FindBy(id="lName")
	WebElement lastName;
	
	public WebElement getlastName() {
		return lastName;
	}
	
	@FindBy(id="email")
	WebElement email;
	
	public WebElement getemail() {
		return email;
	}
	
	@FindBy(id="mNo")
	WebElement phno;
	
	public WebElement getphno() {
		return phno;
	}
	
	@FindBy(partialLinkText="PAY")
	WebElement pay;
	
	public WebElement getPay() {
		return pay;
	}
}
