package q2638;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static boolean CheeseExists = true;

    // 치즈 배열 상태 출력 함수
    public static void printCheese() {
        System.out.println("현재 치즈 상태:");
        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[0].length; j++) {
                System.out.print(cheese[i][j] + " ");
            }
            System.out.println();
        }
    }

    // AirConnected 메서드 수정: 진행상황 출력
    public static boolean AirConnected() {
        boolean hasCheese = true;
        System.out.println("AirConnected() 시작");

        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[0].length; j++) {
                if (visited[i][j] || cheese[i][j] == 1) {
                    continue;
                } else if (!visited[i][j]) {
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        // 범위 벗어나는 값 제거
                        if (nx < 0 || nx >= cheese.length || ny < 0 || ny >= cheese[0].length)
                            continue;
                        cheese[nx][ny] = 2;
                        visited[nx][ny] = true;
                    }

                }

            }
        }

        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[0].length; j++) {
                if (cheese[i][j] == 1) {
                    hasCheese = false;
                }
            }
        }

        System.out.println("AirConnected() 종료, 치즈 상태: " + (hasCheese ? "남아있음" : "없음"));
        return hasCheese;
    }

    // 치즈 녹이기 메서드
    public static void choiceCheeseMelting() {
        System.out.println("choiceCheeseMelting() 시작");

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
                        cheese[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[0].length; j++) {
                if (cheese[i][j] == 3) {
                    cheese[i][j] = 2;
                }
            }
        }

        System.out.println("choiceCheeseMelting() 종료");
        printCheese();  // 치즈 배열 상태 출력
    }

    // BFS 메서드, 진행상황 출력
    public static void bfs() {
        while (true) {
            boolean air = AirConnected();
            System.out.println("AirConnected() 반환: " + air);
            System.out.println("현재 count: " + count);
            printCheese();  // 치즈 배열 상태 출력

            if (air) {
                break;
            }
            choiceCheeseMelting();
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

        // 진행상황 출력
        System.out.println("시작 상태:");
        printCheese();  // 초기 치즈 상태 출력

        bfs();

        // 결과 출력
        System.out.println("최종 count: " + count);
        bw.write(count + "\n");
        bw.flush();
        bf.close();
        bw.close();
    }
}
