package com.framework.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.qa.baseTest.BaseTest;
import com.framework.qa.pages.SearchPage;
import com.framework.qa.utils.PropUtils;


public class ValidateSearchPageTestCases extends BaseTest {
	@Test(priority = 1)
	public void validateMovieReleaseDateAndCountry() {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.validateHeaderText("IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows");
		searchPage.searchForTheMovie(PropUtils.getPropValue(configProp, "movieTitleName"));
		String ExpectedDate = searchPage.getIMDBReleaseDate();
		String ExpectedCountry = searchPage.getIMDBCountry();
		searchPage.getWikiURL();
		searchPage.searchMovieInWiki(PropUtils.getPropValue(configProp, "movieTitleName"));
		String ActualDate = searchPage.getWikiReleaseDate();
		String ActualCountry = searchPage.getWikiCountry();
		Assert.assertEquals(ExpectedDate, ActualDate);
		Assert.assertEquals(ExpectedCountry, ActualCountry);
	}
}
