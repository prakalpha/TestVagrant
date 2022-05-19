package com.framework.qa.utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {
	public static File getPropFile(final String FILE_PATH, final String FILE_NAME) {
		// Returns the Properties File
		return new File(FILE_PATH, FILE_NAME);
	}

	public static Properties getProps(final File file) {
		Properties properties = null;
		try {

			properties = new Properties();
			// Reading the properties file
			properties.load(new FileInputStream(file));
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println(fileNotFoundException);
		} catch (IOException ioException) {
			System.err.println(ioException);
		}
		return properties;
	}

	public static String getPropValue(Properties properties, String key) {
		// Returning the Property value depends on Key
		return properties.getProperty(key);
	}

	public static void setProps(Properties properties, String key, String value, File fileDirectory) {
		Properties props = new Properties();
		try {
			// First load old one:
			FileInputStream configStream = new FileInputStream(fileDirectory);
			props.load(configStream);
			configStream.close();
			// Modifies existing or adds new property
			props.setProperty(key, value);
			// Saving modified property file
			FileOutputStream output = new FileOutputStream(fileDirectory);
			props.store(output, "This description goes to the header of a file");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
