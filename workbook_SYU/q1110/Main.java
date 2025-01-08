package q1110;

import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if(input.length()<2) {
			input="0"+input;
		}
		int cnt=0;
		String inputchange="";
		String temp=input;
		while(!inputchange.equals(input)) {
			inputchange = Newnum(temp);
			temp=inputchange;
			cnt++;
		}
		
		System.out.print(cnt);
	}
	
	public static String Newnum(String str) {
		int sumres1=(Integer.parseInt(str.substring(0,1))+Integer.parseInt(str.substring(1)))%10;
		String result=str.substring(1)+sumres1;
		return result;
	}
}
