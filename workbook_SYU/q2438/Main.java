package q2438;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int S=sc.nextInt();
		
		makeTree(S);
        sc.close();
    }
	
	public static void makeTree(int input) {
		for(int i=1;i<=input;i++) {
			for(int j=0; j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
