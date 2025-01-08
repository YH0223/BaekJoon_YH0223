package q8958;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        int[] score=new int[num];
        for(int i=0;i<num;i++) {
        	score[i]=countOX(sc.next());
        }
        for(int i=0;i<num;i++) {
        	System.out.println(score[i]);
        }
        sc.close();  
    }
	
	public static int countOX(String str) {
		 	String[] resArray=str.split("X");
	        int cnt=0;
	        for(int i=0;i<resArray.length;i++) {
	        	cnt+=stackO(resArray[i].length());
	        }
	        return cnt;
	}
	public static int stackO(int a) {
		int stack_O=0;
		for(int i=1;i<=a;i++) {
			stack_O+=i;
		}
		return stack_O;
	}
}
