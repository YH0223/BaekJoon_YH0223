package q10039;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		String[] temp=new String[num];
		for(int i=0;i<num;i++) {
			temp[i]=sc.next();
		}
		checkVal(temp);
        sc.close();
    }
	
	public static void checkVal(String[] str) {
		for(int i=0;i<str.length;i++) {
			int openP=1,closeP=0;
			if(str[i].charAt(0)==')'){
				System.out.println("NO");
				continue;
			}else {
				for(int j=1;j<str[i].length();j++) {
					if(str[i].charAt(j)=='(') {
						openP++;
					}else if(str[i].charAt(j)==')') {
						closeP++;
						if(closeP>openP) {
							System.out.println("NO");
							break;
						}
					}
				}
				if(openP==closeP) {
					System.out.println("YES");
				}else if(openP>closeP){
					System.out.println("NO");
				}
			}
		}
	}
}
