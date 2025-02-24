package q1005_important_dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[]args) throws NumberFormatException, IOException { dadsadad
		//BOJ1004_여러원과의 거리측정, 반드시 지나야하는 원 찾기
		// 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int CountTestN=Integer.parseInt(bf.readLine());
        
        for(int i=0; i<CountTestN;i++) { 
        	StringTokenizer st=new StringTokenizer(bf.readLine());;
            int countBD=Integer.parseInt(st.nextToken());
        	int countCOM=Integer.parseInt(st.nextToken());
        	
        	int[]tempBD=new int[countBD]; //빌딩 짓는 시간 저장,
        	int[][]tempCommand=new int[countCOM][2];//커맨드 저장
        	st=new StringTokenizer(bf.readLine());
    		for(int k=0;k<2;k++) {
    			tempBD[k]=Integer.parseInt(st.nextToken());
    		}
        	
        	for(int j=0;j<countCOM;j++) {
        		st=new StringTokenizer(bf.readLine());
        		for(int k=0;k<2;k++) {
        			tempCommand[j][k]=Integer.parseInt(st.nextToken());
        		}
        	}
        	int tempEndPoint=Integer.parseInt(bf.readLine());
        	
        	int tempBuildT=0;
        	ArrayList<Integer> optimal = findOptimalOrder(tempCommand,tempBD); //인덱스만 받아옴
        	for(int A:optimal) {
        		System.out.print(A);
        		tempBuildT+=tempBD[A];
        		if(A+1==tempEndPoint) {
        			System.out.println();
        			break;
        		}
        	}
        	 bw.write(tempBuildT+"\n");
        }
       
        
		bw.flush();
		bf.close();
		bw.close();
	}
	 public static ArrayList<Integer> findOptimalOrder(int[][] ArrayCOM, int[] time) {
	        int n = time.length; // 건물의 수 (0-based 배열)

	        // 그래프 초기화
	        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	        int[] indegree = new int[n]; // 진입 차수 배열
	        for (int i = 0; i < n; i++) {
	            graph.add(new ArrayList<>());
	        }

	        // 중복 관계 처리 및 그래프 구성
	        Map<String, Integer> edgeMap = new HashMap<>(); // "from,to" -> time[from]
	        for (int[] command : ArrayCOM) {
	            int from = command[0] - 1; // 0-based index
	            int to = command[1] - 1;
	            String key = from + "," + to;

	            // 중복된 관계 처리
	            if (edgeMap.containsKey(key)) {
	                if (time[from] > edgeMap.get(key)) {
	                    edgeMap.put(key, time[from]); // 더 큰 값만 유지
	                }
	            } else {
	                edgeMap.put(key, time[from]);
	            }
	        }

	        // 최종 그래프 구성 및 진입 차수 계산
	        for (String key : edgeMap.keySet()) {
	            String[] nodes = key.split(",");
	            int from = Integer.parseInt(nodes[0]);
	            int to = Integer.parseInt(nodes[1]);
	            graph.get(from).add(to);
	            indegree[to]++;
	        }

	        // DP 배열 초기화
	        int[] dp = new int[n];
	        for (int i = 0; i < n; i++) {
	            dp[i] = time[i];
	        }

	        // 위상 정렬 수행
	        Queue<Integer> queue = new LinkedList<>();
	        for (int i = 0; i < n; i++) {
	            if (indegree[i] == 0) {
	                queue.add(i);
	            }
	        }

	        while (!queue.isEmpty()) {
	            int current = queue.poll();

	            // 연결된 건물 업데이트
	            for (int next : graph.get(current)) {
	                dp[next] = Math.max(dp[next], dp[current] + time[next]);
	                indegree[next]--;
	                if (indegree[next] == 0) {
	                    queue.add(next);
	                }
	            }
	        }

	        // 결과 반환: dp 배열을 사용해 최적 순서 계산
	        ArrayList<Integer> buildOrder = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            buildOrder.add(i); // 1-based index
	        }

	        return buildOrder;
	    }
}
