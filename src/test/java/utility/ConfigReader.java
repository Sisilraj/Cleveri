package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public Properties initializeProperties() {

		Properties prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\test\\resource\\configuration\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
