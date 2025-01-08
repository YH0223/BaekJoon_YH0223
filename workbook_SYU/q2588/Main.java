package q2588;

import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		int B1=B%10;
        int B10=(B%100)/10;
        int B100=B/100;
        System.out.println(A*B1);
        System.out.println(A*B10);
        System.out.println(A*B100);
        System.out.println(A*B);
	}
}
