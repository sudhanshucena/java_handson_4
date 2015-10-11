package hands_on_4;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class Cards {
		private Vector<String> cards = new Vector<String>();
		private String sURL = "http://api.icndb.com/jokes/random/10"; //the URL with JSON api
		
		void fetchMessages() throws IOException{
	    // Connect to the URL using java's native library
	    URL url = new URL(sURL);
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();
		
	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    JsonElement root = null;

	    //root level of json data
	    root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
	    
	    //parsing of the root level data by first converting to JsonObject and then
	    // to JsonArray get the "value" field and then 
	    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
	    JsonArray messages = rootobj.get("value").getAsJsonArray();
	    
	    for (JsonElement message: messages){
	    	JsonObject msg = message.getAsJsonObject();
	    	cards.add(msg.get("joke").getAsString());
	    	}
		}

		public Vector<String> getCards() {
			return cards;
		}
		
		public void display(int choice){
			System.out.println(cards.get(choice));
		}
}
	    
