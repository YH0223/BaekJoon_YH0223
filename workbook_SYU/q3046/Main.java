package q3046;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int R1=sc.nextInt();
		int S=sc.nextInt();
		
		checkR2(R1,S);
        sc.close();
    }
	
	public static void checkR2(int input, int sum) {
		int res=sum*2-input;
		System.out.println(res);
	}
}
