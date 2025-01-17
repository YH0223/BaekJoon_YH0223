package q12865_Important_dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int countN = Integer.parseInt(st.nextToken()); // 아이템 개수
        int maxWeight = Integer.parseInt(st.nextToken()); // 배낭 최대 무게
        
        int[] weights = new int[countN]; // 아이템 무게
        int[] values = new int[countN]; // 아이템 가치
        
        for (int i = 0; i < countN; i++) {
            st = new StringTokenizer(bf.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(maxValue(countN, maxWeight, weights, values));
    }

    public static int maxValue(int countN, int maxWeight, int[] weights, int[] values) {
        // DP 테이블 초기화
        int[][] dp = new int[countN + 1][maxWeight + 1];

        // DP 계산
        for (int i = 1; i <= countN; i++) { // i번째 아이템까지 고려
            for (int w = 0; w <= maxWeight; w++) { // 배낭의 무게, 0~maxweight까지 반복 배낭의 무게가 w로 제한되었을 경우 계산.
                if (weights[i - 1] > w) {
                    // 현재 아이템을 넣을 수 없는 경우, w보다 물건의 무게가 큰 경우.
                    dp[i][w] = dp[i - 1][w]; //이전 무게의 가치와 동일.
                } else {
                    // 현재 아이템을 넣는 경우와 넣지 않는 경우 비교
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                    //			해당 무게의 이전에 저장된 가치 , 이 - 이전 저장 가치 +가치  ex) w=1 i=1, dp[0][0]=value[0];
                }
            }
        }

        // 최적의 가치 반환
        return dp[countN][maxWeight];
    }
}
