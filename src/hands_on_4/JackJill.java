package hands_on_4;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JackJill {

	public static void main(String[] args) {
		Cards object = new Cards();
		Integer num = null;
		try {
			object.fetchMessages();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Jill please choose a random number between 0-9");
		Scanner in = new Scanner(System.in);
		try{
		num = in.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Please enter a valid integer");
		}
		try{
		object.display(num+1);}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(" Invalid index entered ");
			e.printStackTrace();
		}
	}

}
