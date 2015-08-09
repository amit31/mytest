package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	static Properties prop = new Properties();

	/**
	 * To load the property file "jdbc.properties"
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Properties getTestProperty()  {
		File file = new File("C:\\sel\\Suite1.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
		


		
			
	}

	

}
