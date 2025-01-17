package q18870_important_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 입력: 배열의 크기
        int countN = Integer.parseInt(bf.readLine()); //배열이들어온순서,값 순의 2차원배열
        int[][] arrayX = new int[countN][2];
        int[] ansX=new int[countN]; //결과값

        // 두 번째 입력: 배열의 요소
        String[] input = bf.readLine().split(" ");
        for (int i = 0; i < countN; i++) {
        	arrayX[i][0] = i;
            arrayX[i][1] = Integer.parseInt(input[i]);
        }
     // 비교, 정렬, 오름차순
        Arrays.sort(arrayX, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] a, int[]b) {
				return a[1]-b[1];
				
			}
		});
        // 결과 계산 및 출력
        int cnt=0;
        ansX[arrayX[0][0]]=cnt;//인덱스값이 달라진 배열, 첫번째부터 
        for (int i = 1; i < countN; i++) {
            if(arrayX[i][1]!=arrayX[i-1][1]) { //i번째 value값에 따른 비교, 오름차순이므로 이전값과 다르면 cnt++
            	cnt++;
            }
            ansX[arrayX[i][0]]=cnt; //인덱스값 추출, 해당 인덱스에 cnt 값 저장, 중복값은 조건문 안거치고 이전 값 출력.
        }
        for(int i=0;i<countN;i++) {
        	bw.write(ansX[i]+" ");
        }
        // 자원 정리 및 출력
        bw.flush();
        bw.close();
        bf.close();
    }

}
