package com.framework.qa.utils;

public class Constants {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	// Getting the current Project Directory
		public static final String USER_DIR = System.getProperty("user.dir");

		// Folder Names
		public static final String RESOURCES_FOLDER_NAME = "Resources";
		public static final String CONFIG_FOLDER_NAME = "Configuration";
		public static final String REPORT_FOLDER_NAME = "Report";

		// File Name
		public static final String CONFIG_FILE_NAME = "config.properties";

		// Directories Path
		public static final String RESOURCES_DIR = USER_DIR + FILE_SEPARATOR + RESOURCES_FOLDER_NAME + FILE_SEPARATOR;
		public static final String CONFIG_DIR = RESOURCES_DIR + CONFIG_FOLDER_NAME + FILE_SEPARATOR;
		public static final String REPORTS_DIR = RESOURCES_DIR + REPORT_FOLDER_NAME + FILE_SEPARATOR;
	
}
