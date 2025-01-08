package q1004;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[]args) throws NumberFormatException, IOException { 
		//BOJ1004_여러원과의 거리측정, 반드시 지나야하는 원 찾기
		// 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int CountTestN=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());;
        int start[]= {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        int end[]= {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        for(int i=0; i<CountTestN;i++) {
        	int countStarN=Integer.parseInt(bf.readLine());
        	int[][]tempStar=new int[countStarN][5];
        	int passing=0;
        	for(int j=0;j<countStarN;j++) {
        		st=new StringTokenizer(bf.readLine());
        		for(int k=0;k<3;k++) {
        			tempStar[j][k]=Integer.parseInt(st.nextToken());
        		}
        	}
        	for(int j=0;i<countStarN;j++) {
        		int tempS=getDistance(start,tempStar[j][0],tempStar[j][1]);
        		int tempE=getDistance(end,tempStar[j][0],tempStar[j][1]);
        		if(tempS<(int)Math.pow(tempStar[j][2],2)&&(tempE<(int)Math.pow(tempStar[j][2],2))){
        			continue;
        		}else if(tempS<(int)Math.pow(tempStar[j][2],2)&&tempE>=(int)Math.pow(tempStar[j][2],2)){
        			passing++;
        		}else if(tempS>=(int)Math.pow(tempStar[j][2],2)&&(tempE<(int)Math.pow(tempStar[j][2],2))) {
        			passing++;
        		}
        	}
        }
        
		bw.flush();
		bf.close();
		bw.close();
	}
	public static int getDistance(int[]pointXY,int X,int Y) {
		int tempdistancepow=-1;
		int absX=Math.abs(pointXY[0]-X);
		int absY=Math.abs(pointXY[1]-Y);
		tempdistancepow=(int) Math.pow(absX, absY);
		return tempdistancepow;
	}
}
