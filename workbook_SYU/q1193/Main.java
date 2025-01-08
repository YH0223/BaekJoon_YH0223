package q1193;

import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int cnt=1;
		for(int i=1;;i++) {
			if(input-i<=0) {
				break;
			}else {
				input-=i;
				cnt++;
			}
		}
		sc.close();
		//짝수층은 분모측이 큰쪽부터 시작. 홀수층은 분자쪽이 큰쪽부터 시작.
		if(cnt%2==0) {
			System.out.printf("%d/%d",input,cnt-(input-1));
		}else {
			System.out.printf("%d/%d",cnt-(input-1),input);
		}
		
	}
}
