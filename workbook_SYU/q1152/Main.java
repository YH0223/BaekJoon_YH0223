package q1152;

import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();
		String[] inputArray=input.split(" ");
		if(input.equals("")) {
			System.out.print(0);
		}else {
			System.out.print(inputArray.length);
		}
		
	}
}
