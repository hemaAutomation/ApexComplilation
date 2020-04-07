package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class configFileReader {
	
	private Properties properties;
	private final String propFilePath= "Config//Config.properties";
	
	public configFileReader(){
		BufferedReader reader;
		try{
			reader =new BufferedReader(new FileReader(propFilePath));
			properties = new Properties();
			try{
				properties.load(reader);
				reader.close();
			}
			catch (IOException e){
				e.printStackTrace();
				
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found at " +propFilePath);
		}
		
	}
public String getDriverPath(){
	String driverPath = properties.getProperty("driverPath");
	if(driverPath != null)
		return driverPath;
	else
		throw new RuntimeException("driverPath not specified");
		}
public long getImplicitlyWait(){
	String implicitlyWait = properties.getProperty("implicitlyWait");
	if(implicitlyWait != null)
		return Long.parseLong(implicitlyWait);
	else
		throw new RuntimeException("Wait not specified");
}

public String geturl(){
	String url = properties.getProperty("url");
	if(url != null)
		return url;
	else
		throw new RuntimeException("Url not specified");
}

public String getusername(){
	String username = properties.getProperty("username");
	if(username != null)
		return username;
	else 
		throw new RuntimeException("username not specified");
}
public String getpassword(){
	String password = properties.getProperty("password");
	if(password != null)
		return password;
	else 
		throw new RuntimeException("password not specified");
}
}
