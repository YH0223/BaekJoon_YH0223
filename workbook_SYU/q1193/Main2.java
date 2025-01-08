package q1193;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		List<Integer> numerator=new ArrayList<>();
		List<Integer> denominator=new ArrayList<>();
		int numsig=0,densig=1;
		for(int i=0;i<input;i++) {
			if(i==0) {
				numerator.add(1);
				denominator.add(1);
			}else if(densig==1&&numsig==0&&numerator.get(i-1)==1) { //분자1인상태. 분모+1,이후 분자 증가,분모감소 A
				denominator.add(denominator.get(i-1)+1);
				numerator.add(numerator.get(i-1));
				densig=0;numsig=1;
			}else if(densig==0&&numsig==1&&denominator.get(i-1)==1) {//분모 1인상태. 분자+1,이후 분모증가,분자감소 B
				numerator.add(numerator.get(i-1)+1);
				denominator.add(denominator.get(i-1));
				densig=1;numsig=0;
			}else if(densig==0&&numsig==1&&denominator.get(i-1)!=1) {//분모감소,분자증가 기준 A
				denominator.add(denominator.get(i-1)-1);
				numerator.add(numerator.get(i-1)+1);
			}else if(densig==1&&numsig==0&&numerator.get(i-1)!=1) {//분모증가,분자감소 기준 B
				numerator.add(numerator.get(i-1)-1);
				denominator.add(denominator.get(i-1)+1);
			}
		}
		System.out.printf("%d/%d",numerator.get(input-1),denominator.get(input-1));
		
	}
}
