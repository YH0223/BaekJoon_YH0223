package q10810;


import java.util.Scanner;

public class Main {

	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int sizeArray = sc.nextInt();
		int chance=sc.nextInt();
		int[] BallBox=new int[sizeArray];
		for(int i=0;i<chance;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			for(int j=a-1;j<b;j++) {
				BallBox[j]=c;
			}
		}
		for(int num:BallBox) {
			System.out.print(num+" ");
		}
	}

}
