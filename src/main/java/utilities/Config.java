package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Config {
	
	private static InputStream input;
	private static OutputStream output;
	private static Properties properties;
	
	//function to read from properties files
	public static String getConfigValue(String key) {
		try {
			properties = new Properties();
			input = new FileInputStream("config.properties");
			properties.load(input);
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	//function to write from properties files
	public static void setConfigValue(String key, String value) {
		try {
			output = new FileOutputStream("config.properties");
			properties.setProperty(key, value);
			properties.store(output, null);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
