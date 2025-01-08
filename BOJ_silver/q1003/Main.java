package q1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] fibonacci01=new int [41][2];
	public static void main(String[]args) throws NumberFormatException, IOException { 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        
        int CountN=Integer.parseInt(bf.readLine());
        fiboDP(40);
        for(int i=0; i<CountN;i++) {
        	int input=Integer.parseInt(bf.readLine());
        	System.out.println(fibonacci01[input][0]+" "+fibonacci01[input][1]);
        }
        
        
		bf.close();

	}
	
	public static void fiboDP(int A) {
		fibonacci01[0][0]=1;
		fibonacci01[0][1]=0;
		fibonacci01[1][0]=0;
		fibonacci01[1][1]=1;
		createFibo(40);
	}
	public static void createFibo(int N) {
		for(int i=2;i<N+1;i++) {
			fibonacci01[i][0]=fibonacci01[i-1][0]+fibonacci01[i-2][0];
			fibonacci01[i][1]=fibonacci01[i-1][1]+fibonacci01[i-2][1];
		}
	}
	
}