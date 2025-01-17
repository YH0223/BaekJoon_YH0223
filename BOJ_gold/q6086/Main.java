package q6086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int capacity[][]=new int[52][52];
	static int flow[][];
	static int path[]; // 
	static boolean visited[];
	static LinkedList<Integer> graph[];
	static int Source,Sink;
	
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Source=convertToInt('A');Sink=convertToInt('Z');
        int countN = Integer.parseInt(st.nextToken()); // 파이프 개수
        path=new int[countN];
        for(int i=0; i<countN;i++) {
        	st = new StringTokenizer(bf.readLine());
        	int tempA=convertToInt(st.nextToken().charAt(0));
        	int tempB=convertToInt(st.nextToken().charAt(0));
        	capacity[tempA][tempB]=Integer.parseInt(st.nextToken());
        	capacity[tempB][tempA]=0;
        }
        EdmondsKarp();
    
    }
    public static int convertToInt(char c) {
		if(c>='A'&&c<='Z') {
			return c-'A';
		}
		else {
			return c-'a'+26;
		}
	}
    //BFS-에드몬드 카퍼 방식으로 풀이하는 최대유량
    public static boolean bfs() {
        Arrays.fill(path, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(Source);

        while (!q.isEmpty()) {
            int from = q.poll();
            LinkedList<Integer> nexts = graph[from];

            for (int next: nexts) {
                if ( path[next] == -1 && (capacity[from][next] - flow[from][next]) > 0 ) {
                    path[next] = from;
                    q.add(next);

                    if (next == Sink) {
                        break;
                    }
                }
            }
        }

        if (path[Sink] == -1) {
            return false;
        }

        return true;
    }

    // O(VE^2)
    public static int EdmondsKarp() {
        int total = 0;
        while (bfs()) {
            // flow값 찾기
            int flowNum = Integer.MAX_VALUE;
            for(int i = Sink; i != Source; i = path[i]) {
                int from = path[i];
                int to = i;
                flowNum = Math.min(flowNum, (capacity[from][to]) - flow[from][to]);
            }

            // flow흘려 보내기, 역방향도 반드시!!!!
            for(int i = Sink; i != Source; i = path[i]) {
                int from = path[i];
                int to = i;

                flow[from][to] += flowNum;
                flow[to][from] -= flowNum;
            }

            total += flowNum;
        }
        return total;
    }
        
}


   

