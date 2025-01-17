package q6086;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	public static int capacity[][]=new int[52][52];
	public static int flow[][];
	public static int path[]; // 
	public static boolean visited[]= new boolean[52];;
	public static LinkedList<Integer> graph[];
	public static int Source=0,Sink=52;
	
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int countN = Integer.parseInt(st.nextToken()); // 파이프 개수
        for(int i=0; i<countN;i++) {
        	st = new StringTokenizer(bf.readLine());
        	int tempA=convertToInt1(st.nextToken().charAt(0));
        	int tempB=convertToInt1(st.nextToken().charAt(0));
        	capacity[tempA][tempB]=Integer.parseInt(st.nextToken());
        	capacity[tempB][tempA]=0;
        }
        FordFulkerson();
    
    }
    public static int convertToInt1(char c) {
		if(c>='A'&&c<='Z') {
			return c-'A';
		}
		else {
			return c-'a'+26;
		}
	}
    //DFS / 포드 풀커슨으로 풀이하는 최대유량
     public static boolean dfs(int start) {
           if (start == Sink) {
               return true;
           }

           visited[start] = true;
           LinkedList<Integer> nexts = graph[start];
           for (int next: nexts) {
               if ( !visited[next] && capacity[start][next] - flow[start][next] > 0) {
                   path[next] = start;

                   if (dfs(next)) { // 경로를 끝까지 찾으면 탈출, 아니면, 끝까지 찾기 재시도
                       return true;
                   }
               }
           }
           return false;
       }
    // O((V+E)F)
     // Ford-Fulkerson 알고리즘으로 최대 유량 계산
     public static int FordFulkerson() {
         int total = 0;

         while (true) {
             Arrays.fill(path, -1);
             Arrays.fill(visited, false);

             if (!dfs(Source)) { // 증가 경로가 없으면 종료
                 break;
             }

             // 경로에서의 최소 유량 찾기
             int flowNum = Integer.MAX_VALUE;
             for (int i = Sink; i != Source; i = path[i]) {
                 int from = path[i];
                 flowNum = Math.min(flowNum, capacity[from][i] - flow[from][i]);
             }

             // 유량을 해당 경로에 추가
             for (int i = Sink; i != Source; i = path[i]) {
                 int from = path[i];
                 flow[from][i] += flowNum;
                 flow[i][from] -= flowNum;
             }

             total += flowNum;
         }

         return total;
     }
       public static int convertToInt(char c) {
   		if(c>='A'&&c<='Z') {
   			return c-'A';
   		}
   		else {
   			return c-'a'+26;
   		}

   }
        
}


   

