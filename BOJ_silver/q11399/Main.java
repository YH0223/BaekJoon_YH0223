package q11399;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[]args)  throws IOException {
		// 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(bf.readLine());
        Integer[]arrinp=new Integer[N];
        StringTokenizer st= new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
        	arrinp[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrinp,Collections.reverseOrder());
        int sum=0;
        for(int i=0;i<arrinp.length;i++) {
        	sum+=arrinp[i]*(i+1);
        }
        bw.write(String.valueOf(sum));
        
        
        bw.flush();
        bw.close();
        bf.close();
	}
}