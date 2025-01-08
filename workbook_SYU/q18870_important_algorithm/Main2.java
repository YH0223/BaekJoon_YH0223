package q18870_important_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) throws IOException {
        // 입력용 BufferedReader, 출력용 BufferedWriter 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 입력: 배열의 크기
        int countN = Integer.parseInt(bf.readLine());
        int[] arrayX = new int[countN];

        // 두 번째 입력: 배열의 요소
        String[] input = bf.readLine().split(" ");
        for (int i = 0; i < countN; i++) {
            arrayX[i] = Integer.parseInt(input[i]);
        }

        // 결과 계산 및 출력
        for (int i = 0; i < countN; i++) {
            int count = countUnderX(arrayX[i], arrayX);
            bw.write(count + " ");
        }
        
        // 자원 정리 및 출력
        bw.flush();
        bw.close();
        bf.close();
    }

    public static int countUnderX(int a, int[] arrX) {
        Set<Integer> temp = new HashSet<>();
        for (int value : arrX) {
            if (value < a) { // a보다 작은 값만 추가
                temp.add(value);
            }
        }
        return temp.size(); // 중복 제거 후 사이즈 반환
    }
}
