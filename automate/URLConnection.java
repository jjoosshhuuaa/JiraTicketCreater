package automate;

import java.net.*;
import java.io.*;

public class URLConnection {
	
	public String executePost(String targetURL) {
		HttpURLConnection connection = null;
		
		try {
			//Create connection
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			//connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			
			//send request
			DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
			//wr.writeBytes(urlParameters);
			wr.close();
			
			//get response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) 
			{
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		} finally
		{
			if (connection != null)
				connection.disconnect();
		}
	}

}
