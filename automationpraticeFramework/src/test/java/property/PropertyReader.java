package property;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	Properties properties = new Properties();
	InputStream inputStream = null;
	
	public PropertyReader() {
		loadProperties();
	}
	private void loadProperties(){
		try{
			inputStream = new FileInputStream("src/test/java/property/config.properties");
			properties.load(inputStream);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
		public String readProperty(String key){
			return properties.getProperty(key);
		}
	
}
