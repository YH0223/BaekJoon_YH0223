package q1913;

import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int matrixN=sc.nextInt();
		int target=sc.nextInt();
		sc.close();
		int[][] matrixResult=makematrix(matrixN);
		int targetX=0,targetY=0;
		for(int i=0;i<matrixResult.length;i++) {
			for(int j=0;j<matrixResult[0].length;j++) {
				System.out.print(matrixResult[i][j]+" ");
				if(matrixResult[i][j]==target) {
					targetX=i+1;
					targetY=j+1;
				}
			}
			System.out.println();
		}
		System.out.print(targetX+" "+targetY);
		
	}
	
	public static int[][] makematrix(int cnt){
		int med=cnt/2;
		int temp[][]=new int[cnt][cnt];
		int pointX = med,pointY=med;
		int layer = 0;
		temp[pointX][pointY]=1;
		for(int i=1;i<=cnt;i++) {
			if(i==1) {
				for(int j=1;j<=9;j++){
					if(j==1) {
						pointX--;
					}else if(j>1&&j<3) {
						temp[pointX][pointY]=j;
						pointY++;
					}else if(j>=3&&j<5) {
						temp[pointX][pointY]=j;
						pointX++;
					}else if(j>=5&&j<7) {
						temp[pointX][pointY]=j;
						pointY--;
					}else if(j>=7&&j<=(int)Math.pow(i+2, 2)) {
						temp[pointX][pointY]=j;
						pointX--;
					}	
					
				}
			}
			else if(i%2!=0&&pointX!=-1&&pointY!=-1) {
				layer=(int)Math.pow(i, 2);
				for(int j=layer+1;j<=(int)Math.pow(i+2, 2);j++){
					if(j>=layer+1&&j<layer+i+1) {
						temp[pointX][pointY]=j;
						pointY++;
					}else if(j>=layer+i+1&&j<layer+2*i+2) {
						temp[pointX][pointY]=j;
						pointX++;
					}else if(j>=layer+2*i+2&&j<layer+3*i+3) {
						temp[pointX][pointY]=j;
						pointY--;
					}else if(j>=layer+3*i+3&&j<=(int)Math.pow(i+2, 2)) {
						temp[pointX][pointY]=j;
						pointX--;
					}
					
				}
			}			
		}
		
		return temp;
	}
		
}
	