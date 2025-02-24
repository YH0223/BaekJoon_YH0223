package q1031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		int matrixX=Integer.parseInt(st.nextToken());
		int matrixY=Integer.parseInt(st.nextToken());
		int[] matrixXcount=new int[matrixX];
		int[] matrixYcount=new int[matrixY];
		boolean makeboard=true;
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<matrixX;i++) {
			matrixXcount[i]=Integer.parseInt(st.nextToken());
			if(matrixXcount[i]>matrixY) {
				makeboard=false;
			}
		}
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<matrixY;i++) {
			matrixYcount[i]=Integer.parseInt(st.nextToken());
			if(matrixYcount[i]>matrixX) {
				makeboard=false;
			}
		}
		if(makeboard) {
			GameBoard(matrixXcount,matrixYcount);
		}else {
			System.out.println(-1);
		}
		bf.close();
	}
	public static void GameBoard(int[]X,int[] Y){
		int[][] matrix=new int[X.length][Y.length];
		int[]
		for(int i=0;i<X.length;i++) {
			for(int j=0;j<Y.length;j++) {
					
				}
		}
		
		
		
		for(int i=0;i<X.length;i++) {
			for(int j=0;j<Y.length;j++) {
					System.out.println(matrix[i][j]+" ");
				}
			System.out.println();
		}
		
	}

}
