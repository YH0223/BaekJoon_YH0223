package q2638;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static int count=0;
	
	static class Point{
		public int x,y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static boolean bfs_checkair(int x, int y) {
		boolean checktemp=false;
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(x,y));
		visited[x][y]=true;
		while(!Q.isEmpty()) {
			Point tmp=Q.poll();
			for(int i=0;i<4;i++) {
				int nx=tmp.x+dx[i];
				int ny=tmp.y+dy[i];
				if(nx<0||nx>=cheese.length||ny<0||ny>=cheese[0].length){
					continue;
				}
				if(visited[nx][ny]||cheese[nx][ny]==1) {
					continue;
				}
				cheese[nx][ny]=2;
				Q.offer(new Point(nx,ny));
				visited[nx][ny]=true;
			}
			for(int i=0;i<cheese.length;i++) {
				for(int j=0;j<cheese[0].length;j++) {
					
					if(cheese[i][j]==1) {
						checktemp=true;
					}
				}
				
			}
			
		}
		return checktemp;
	}
	// 치즈 녹이기 메서드
    public static void bfs_melting_cheese() {
       

        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[0].length; j++) {
                if (cheese[i][j] == 1) {
                    int countAir = 0;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        // 범위 벗어나는 값 제거
                        if (nx < 0 || nx >= cheese.length || ny < 0 || ny >= cheese[0].length)
                            continue;

                        if (cheese[nx][ny] == 2) {
                            countAir++;
                        }
                    }
                    if (countAir >= 2) {
                        cheese[i][j] = 0;
                    }
                }
            }
        }
    }
	public static void base_bfs() {
		while(bfs_checkair(0,0)) {
			bfs_melting_cheese();
			for (int i = 0; i < cheese.length; i++) {
	            for (int j = 0; j < cheese[0].length; j++) {
	                visited[i][j] = false;
	            }
	        }
			count++;
		}
	}
	
	
    public static void main(String[] args) throws IOException {
        // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int countX = Integer.parseInt(st.nextToken());
        int countY = Integer.parseInt(st.nextToken());
        cheese = new int[countX][countY];
        visited = new boolean[countX][countY];

        for (int i = 0; i < cheese.length; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < cheese[0].length; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }
        cheese[0][0] = 2; // 시작점 (0, 0)을 2로 설정

        base_bfs();
        
        // 결과 출력
        bw.write(count + "\n");
        bw.flush();
        bf.close();
        bw.close();
    }
}