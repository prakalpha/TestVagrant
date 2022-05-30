package com.framework.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.framework.qa.basePage.BasePage;
import com.framework.qa.utils.PropUtils;

public class SearchPage extends BasePage {
	@FindBy(xpath = "//input[@id='suggestion-search']")
	private WebElement searchBarInputTxtBox;
	@FindBy(xpath = "//button[@id='suggestion-search-button']")
	private WebElement btnToSearch;
	@FindBy(xpath = "//li[@id='react-autowhatever-1--item-1']")
	private WebElement searchResult;
	@FindBy(xpath = "//h3[contains(text(),'Details')]")
	private WebElement detailsHeaderText;
	@FindBy(xpath = "//div[@data-testid='title-details-section']//li[@data-testid='title-details-releasedate']/descendant::ul//a")
	private WebElement releaseDate;
	@FindBy(xpath = "//div[@data-testid='title-details-section']//li[@data-testid='title-details-origin']/descendant::a")
	private WebElement country;
	@FindBy(xpath = "//input[@id='searchInput']")
	private WebElement wikiSearchInput;
	@FindBy(xpath = "//div[contains(text(),'Release date')]/following::li[1]")
	private WebElement wikiReleaseDate;
	@FindBy(xpath = "//td[@class='infobox-data'])[12]")
	private WebElement wikiCountry;

	public SearchPage(WebDriver driver,ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void validateHeaderText(String title) {
		verifyPageTitle(title);
	}

	public void searchForTheMovie(String movieName) {
		isDisplayedThenEnterText(searchBarInputTxtBox, "Movie name search", movieName);
		MouseHover(searchResult);
		isDisplayedThenClick(searchResult, movieName + "first index");
		verifyPageTitle(movieName);
	}

	public String getIMDBReleaseDate() {
		String movieReleaseDate;
		movieReleaseDate = getText(releaseDate);
		return movieReleaseDate;
	}

	public String getIMDBCountry() {
		String countryName;
		countryName = getText(country);
		return countryName;
	}

	public String getWikiReleaseDate() {
		String movieReleaseDate;
		movieReleaseDate = getText(wikiReleaseDate);
		return movieReleaseDate;
	}

	public String getWikiCountry() {
		String countryName;
		countryName = getText(wikiCountry);
		return countryName;
	}

	public void wikiURL() {
	  getURL(PropUtils.getPropValue(configProp, "wikiURL"));
		
	}

	public void searchMovieInWiki(String movieName) {
		isDisplayedThenEnterText(wikiSearchInput, "wiki search", movieName);
	}

}
