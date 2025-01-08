package q1002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[]args) throws NumberFormatException, IOException { 
		//BOJ1002_중심이 다른 두 원의 접점 찾기
		 // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

        int CountN=Integer.parseInt(bf.readLine());
        for(int i=0; i<CountN;i++) {
        	int rad1,rad2,t1x,t1y,t2x,t2y,disX,disY,rb,rs;
        	int disXY;
        	StringTokenizer st= new StringTokenizer(bf.readLine());
        	t1x=Integer.parseInt(st.nextToken());
        	t1y=Integer.parseInt(st.nextToken());
        	rad1=Integer.parseInt(st.nextToken());
        	t2x=Integer.parseInt(st.nextToken());
        	t2y=Integer.parseInt(st.nextToken());
        	rad2=Integer.parseInt(st.nextToken());
        	disX=Math.abs(t1x-t2x);
        	disY=Math.abs(t1y-t2y);
        	disXY=disX*disX+disY*disY;
        	rb=(rad1>rad2)?rad1:rad2;rs=(rad1<rad2)?rad1:rad2;
        	if((rad1==rad2&&disXY==0)) { //두 원이 만나지 않는 경우, 두 원의 중심과 반지름이 같은경우
        		bw.write(-1+"\n");
        	
        	}else if(disXY>(rb+rs)*(rb+rs)||disXY<(rb-rs)*(rb-rs)&&rad1!=rad2) { // 원이 포함관계
        		bw.write(0+"\n");
        	}else if(disXY==(rb+rs)*(rb+rs)||disXY==(rb-rs)*(rb-rs)) {//두원이 한점에서 만나는 경우
        		bw.write(1+"\n");
        	}else if(disXY<(rb+rs)*(rb+rs)) {//두 원의 중심 사이 거리가 두원이 반지름 합보다 작을때, 두점에서 만난다.
        		bw.write(2+"\n");
        	}else { 
        		bw.write("반례찾을 필요 있음\n");
        	}
        	
        }
        
		bw.flush();
		bf.close();
		bw.close();
	}
	
}
