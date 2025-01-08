package q15922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int X=0,Y=0,sum=0;
		for(int i=0;i<count;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int tempX=Integer.parseInt(st.nextToken());
			int tempY=Integer.parseInt(st.nextToken());
			if(i==0||tempX>=Y) {
				X=tempX;Y=tempY;
				sum+=tempY-tempX;
			}else if(Y>=tempX&&Y<=tempY) {
				sum+=tempY-Y;
				Y=tempY;
			}else if(X<=tempX&&Y>=tempY) {
				continue;
			}
				
		}
		System.out.println(sum);
	}
	

}
