package com.framework.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.framework.qa.basepage.BasePage;
import com.framework.qa.utils.PropUtils;

public class SearchPage extends BasePage {
	@FindBy(xpath = "//input[@id='suggestion-search']")
	public WebElement searchBarInputTxtBox;
	@FindBy(xpath = "//button[@id='suggestion-search-button']")
	public WebElement btnToSearch;
	@FindBy(xpath = "//li[@id='react-autowhatever-1--item-1']")
	public WebElement searchResult;
	@FindBy(xpath = "//h3[contains(text(),'Details')]")
	public WebElement detailsHeaderText;
	@FindBy(xpath = "//div[@data-testid='title-details-section']//li[@data-testid='title-details-releasedate']/descendant::a[2]")
	public WebElement releaseData;
	@FindBy(xpath = "//div[@data-testid='title-details-section']//li[@data-testid='title-details-origin']/descendant::a")
	public WebElement country;
	@FindBy(xpath = "//input[@id='searchInput']")
	public WebElement wikiSearchInput;
	@FindBy(xpath = "//div[contains(text(),'Release date')]/following::li[1]")
	public WebElement wikiReleaseDate;
	@FindBy(xpath = "//td[@class='infobox-data'])[12]")
	public WebElement wikiCountry;

	public SearchPage(WebDriver driver) {
		super(driver);
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
		movieReleaseDate = getText(releaseData);
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

	public void getWikiURL() {
		driver.get(PropUtils.getPropValue(configProp, "wikiURL"));
	}

	public void searchMovieInWiki(String movieName) {
		isDisplayedThenEnterText(wikiSearchInput, "wiki search", movieName);
	}

}
