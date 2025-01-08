package q2720;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int riam=sc.nextInt();
        int[] bill=new int[riam];
        for(int i=0;i<riam;i++) {
			bill[i]=sc.nextInt();
		}
        sc.close();
        int[][] result=calcRiam(bill,riam);
        for(int i=0;i<result.length;i++) {
        	for(int j=0;j<result[0].length;j++) {
        		System.out.print(result[i][j]+" ");
        	}
        	System.out.println();
        }
    }
	
	public static int[][] calcRiam(int[] array,int riam) {
		int[][] res= new int[riam][4];
		for(int i=0;i<riam;i++) {
			res[i][0]=array[i]/25;
			res[i][1]=(array[i]%25)/10;
			res[i][2]=((array[i]%25)%10)/5;
			res[i][3]=((array[i]%25)%10)%5;
		}
		return res;
	}
	
	
}
