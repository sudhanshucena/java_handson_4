package hands_on_4;

import java.io.IOException;

public class JackJill {

	public static void main(String[] args) {
		int choice;
		Cards object = new Cards();
		try {
			object.fetchMessages();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		object.display(4);
	}

}
