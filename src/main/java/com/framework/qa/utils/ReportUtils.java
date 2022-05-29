package com.framework.qa.utils;

import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.framework.qa.baseTest.BaseTest;

public class ReportUtils {
	public static void createResultsFolder(String folderPath) {
		File dirInfo = new File(folderPath);
		// creating the folder which is holding the test reports
		if (!dirInfo.exists()) {
			dirInfo.mkdir();
		}
	}

	public static void createIndexFile() {
		// Creating Index file
		File source = new File(BaseTest.resultFile);
		File destination = new File(BaseTest.indexFile);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
