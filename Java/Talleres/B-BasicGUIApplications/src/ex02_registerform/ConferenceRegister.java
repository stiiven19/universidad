package ex02_registerform;

import java.util.Scanner;

public class ConferenceRegister {
//----------------------------------------------------------------------------
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//------------------------------------------------------
		while (true) {
			System.out.println("There is a New Register?");
			String answer =scan.next();
			if (answer.equals("yes")) {
				new RegisterForm();
			}else if(answer.equals("no")){
				System.exit(0);
			}
			
		}
		
	}
}
