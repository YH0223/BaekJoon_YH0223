package q2738;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[]args) throws IOException {
		 // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(st.nextToken());int m=Integer.parseInt(st.nextToken());
		int[][] matrixA= new int[n][m];
		
		for(int i=0;i<2*n;i++) {
			st= new StringTokenizer(bf.readLine());
			if(i<n) {
				for(int j=0;j<m;j++) {
					matrixA[i][j]=Integer.parseInt(st.nextToken());
				}
			}else {
				for(int j=0;j<m;j++) {
					matrixA[i-n][j]+=Integer.parseInt(st.nextToken());
					bw.write(String.valueOf(matrixA[i-n][j])+" ");
				}
				bw.write("\n");
			}
		}
		
		
		bw.flush();
		bf.close();
		bw.close();
	}

}
