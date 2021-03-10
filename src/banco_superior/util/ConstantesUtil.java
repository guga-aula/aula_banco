package banco_superior.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConstantesUtil {

	public final static String BANCO_SUPERIOR_DATABASE_PATH;
	public final static String BANCO_SUPERIOR_DATABASE_PORT;
	public final static String BANCO_SUPERIOR_DATABASE_IP;
	
	private static Properties prop; 
	private static FileInputStream fis; 
	
	static 
	{
		
		try 
		{
			prop = new Properties();
			fis = new FileInputStream("propriedades");
			prop.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BANCO_SUPERIOR_DATABASE_PATH = prop.getProperty("banco_superior_database_path");
		BANCO_SUPERIOR_DATABASE_PORT = prop.getProperty("banco_superior_database_port");
		BANCO_SUPERIOR_DATABASE_IP = prop.getProperty("ip");
	}
	
	public static boolean containsKey(String key)
	{
		return prop.containsKey(key);
	}
}
