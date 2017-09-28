package framework.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertiesFile {

	static Properties property;

	public static void loadPropertiesFile() throws IOException {
		property = new Properties();
		File fs = new File(System.getProperty("user.dir") + "\\resources\\English.properties");
		FileReader obj = new FileReader(fs);
		property.load(obj);
		
	}
	
	public static String getObject(String Data) throws IOException{
		loadPropertiesFile();
		String data = property.getProperty(Data);
		return data;
	}

}
