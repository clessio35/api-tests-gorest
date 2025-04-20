package api.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Token {
	
	public String getApiToken() throws IOException {
		Properties prop = new Properties();
		try(InputStream input = Token.class.getClassLoader().getResourceAsStream("application.properties")) {
			if(input == null) {
				throw new IOException("File 'application.properties' not found");
			}
			prop.load(input);
		} 
		String token = prop.getProperty("api.token");
		if(token == null) {
			throw new IllegalStateException("Authentication Token not found");
		}
		return token;
	}

}
