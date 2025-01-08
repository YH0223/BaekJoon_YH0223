package q12100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] inp;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static List<Integer> res=new ArrayList<>();
	
	/*public static void roll(int p1, int p2) {
		int[] t1 = inp[p1];
		int[] t2 = inp[p2];

		inp[p1] = 0;
		inp[p2] = 0;

		// sum
		int sum = 0;
		for (int i = 0; i < inp.length; i++) {
			sum += inp[i];
		}
		if (sum == 100) {
			for (int i = 0; i < inp.length; i++) {
				if (inp[i] != 0)
					System.out.println(inp[i]);
			}
			return;
		} else {
			inp[p1] = t1;
			inp[p2] = t2;

			if (p2 + 1 < inp.length)
				p2++;
			else {
				p1++;
				p2 = 0;
			}

			rec(p1, p2);
		}
	}*/
	public static int calPowRoot2(int x) {
		int count=0;
		while(true) {
			if(x<1) {
				break;
			}
			x/=2;count++;
		}
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int countN=Integer.parseInt(st.nextToken());
        inp=new int [countN][countN];
        for(int i=0;i<countN;i++) {
        	st=new StringTokenizer(bf.readLine(), " ");
        	for(int j=0;j<countN;j++) {
        		
        		inp[i][j]=calPowRoot2(Integer.parseInt(st.nextToken()));
        	}
        }
        bw.flush();
        bw.close();
        bf.close();
	}
	
}
