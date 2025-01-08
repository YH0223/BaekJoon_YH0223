package q11718;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int i=0;
        while(i<100) {
        	String output=bf.readLine();
        	if(output==null) {
        		break;
        	}
        	bw.write(output+"\n");
        }
        bw.flush();
        bw.close();
        bf.close();
	}

}
