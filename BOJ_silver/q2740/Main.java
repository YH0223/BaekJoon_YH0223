package q2740;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine() );
        // 첫 번째 입력: 배열의 크기
        int countN = Integer.parseInt(st.nextToken()); 
        int countM = Integer.parseInt(st.nextToken()); 
        
        
        int[][] arrayMatrixA = new int[countN][countM]; 
       
        
        // 데이터 입력
        for (int i = 0; i < countN; i++) {
        	st = new StringTokenizer(bf.readLine() );
           
            for (int j = 0; j < countM; j++) {
            	arrayMatrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }
     
        st = new StringTokenizer(bf.readLine() );
        countM = Integer.parseInt(st.nextToken()); 
        int countK = Integer.parseInt(st.nextToken());
        int[][] arrayMatrixB = new int[countM][countK];
        for (int i = 0; i < countM; i++) {
        	st = new StringTokenizer(bf.readLine() );
           
            for (int j = 0; j < countK; j++) {
            	arrayMatrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] arrayAns=new int[countN][countK];
        for (int i = 0; i < countN; i++) {
           
            for (int j = 0; j < countK; j++) {
            	
            	for(int k=0;k<countM;k++) {
            		arrayAns[i][j] += arrayMatrixA[i][k]*arrayMatrixB[k][j];
            	}
            	
            }
        }
        
        
        for (int i = 0; i < countN; i++) {
            for (int j = 0; j < countK; j++) {
            	  bw.write(arrayAns[i][j]+" ");
            }
            bw.write("\n");
        }
        
      

        // 자원 정리 및 출력
        bw.flush();
        bw.close();
        bf.close();
    }

}
