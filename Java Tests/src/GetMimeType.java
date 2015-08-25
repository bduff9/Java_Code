import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class GetMimeType {

	public static void main(String[] pVals) {
		
		try {
			URL url = new URL("http://www.mrcwebapps.com:8011/mrcjava/servlet/NFL.I00030s?pageName=I00030s.json&slnk=1&key=trinitron&USERID=TEST");
			URLConnection connection = url.openConnection();
			connection.connect();
			String contentType = connection.getContentType();
			System.out.println(contentType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
