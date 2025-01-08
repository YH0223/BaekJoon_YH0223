package q1149_important_dynamic_progamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 입력: 배열의 크기
        int countN = Integer.parseInt(bf.readLine()); 
        
        int[][] arrayRGB = new int[countN][3]; // RGB 값 저장

        // 데이터 입력
        for (int i = 0; i < countN; i++) {
            String[] input = bf.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arrayRGB[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        // DP 방식으로 계산하여 최소 합을 구하는 함수 호출
        ArrayList<Integer> optimal = findOptimalCombination(arrayRGB, countN);
        bw.write(optimal+"");
        // 최적 조합에 해당하는 값들의 합 구하기
        int totalSum = 0;
        for (int i = 0; i < countN; i++) {
            int colorIdx = optimal.get(i);  // 해당 행의 최적 인덱스
            totalSum += arrayRGB[i][colorIdx];  // 해당 색의 값을 더함
        }

        bw.write(totalSum+"");

        // 자원 정리 및 출력
        bw.flush();
        bw.close();
        bf.close();
    }

    // DP 방식으로 최적의 RGB 조합을 찾는 함수
    public static ArrayList<Integer> findOptimalCombination(int[][] arrayRGB, int countN) {
        // dp[i][j]는 i번째 행에서 j번째 색을 선택했을 때, 최소 합을 저장-<다이나믹 프로그래밍 핵심
        int[][] dp = new int[countN][3];
        // 선택된 색 인덱스를 추적할 배열
        int[][] choice = new int[countN][3];

        // 첫 번째 행 초기화 (첫 번째 행은 선택에 제약이 없으므로 그대로 저장)
        for (int j = 0; j < 3; j++) {
            dp[0][j] = arrayRGB[0][j];
        }

        // 두 번째 행부터 마지막 행까지
        for (int i = 1; i < countN; i++) {
            for (int j = 0; j < 3; j++) {
                // 이전 행에서 j와 다른 색을 선택할 때 최소값을 찾음
                int minPrev = Integer.MAX_VALUE;
                int minIdx = -1;
                for (int k = 0; k < 3; k++) {
                    if (k != j && dp[i-1][k] < minPrev) {
                        minPrev = dp[i-1][k];
                        minIdx = k;
                    }
                }
                // 현재 dp값을 갱신
                dp[i][j] = arrayRGB[i][j] + minPrev;
                // 선택된 색을 기록
                choice[i][j] = minIdx;
            }
        }

        // 마지막 행에서 최소값을 찾고, 그 값이 선택된 색을 추적
        int minSum = Integer.MAX_VALUE;
        int lastIdx = -1;
        for (int j = 0; j < 3; j++) {
            if (dp[countN-1][j] < minSum) {
                minSum = dp[countN-1][j];
                lastIdx = j;
            }
        }
        // 최적의 조합을 추적하여 저장
        ArrayList<Integer> optimalCombination = new ArrayList<>();
        for (int i = countN - 1; i >= 0; i--) {
            optimalCombination.add(lastIdx);
            lastIdx = choice[i][lastIdx];
        }

        // 최적의 조합을 반대로 뒤집음
        ArrayList<Integer> optimalReversed = new ArrayList<>();
        for (int i = optimalCombination.size() - 1; i >= 0; i--) {
            optimalReversed.add(optimalCombination.get(i));
        }

        return optimalReversed;
    }
}
