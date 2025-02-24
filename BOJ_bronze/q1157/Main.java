package q1157;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	public static void main(String[]args)  throws IOException {
		// 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input=bf.readLine().toUpperCase();
        char[] charInp=input.toCharArray();
        Arrays.sort(charInp);
        Map<Character, Integer> cntChar = new HashMap<>();
        char tempC=charInp[0];
        int cnt=0;
        for(int i=0;i<input.length();i++) {
        	tempC=charInp[i];
        	if(i!=0&&tempC!=charInp[i-1]) {
        		cntChar.put(charInp[i-1],cnt);
        		cnt=1;
        	}else {
        		cnt++;
        	}
        }
        cntChar.put(charInp[charInp.length - 1], cnt);
        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(cntChar.entrySet());
        Collections.sort(list, (entry2, entry1) -> entry1.getValue().compareTo(entry2.getValue()));
        int maximum = list.get(0).getValue();  
        if(list.size()<2) {
        	bw.write(list.get(0).getKey());
        }else{
        	int secondMaximum = list.get(1).getValue();  
            if(maximum==secondMaximum) {
            	bw.write("?");
            }
            else {
            	bw.write(list.get(0).getKey());
            }

        }
        
        
        bw.flush();
        bw.close();
        bf.close();
	}
}