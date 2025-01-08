package q10951;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
       
        
        while(true) {
        	String temp=bf.readLine();
        	if(temp==null) {
        		break;
        	}
        	StringTokenizer st= new StringTokenizer(temp);
        	int sum= Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
        	bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
        bf.close();
	}

}