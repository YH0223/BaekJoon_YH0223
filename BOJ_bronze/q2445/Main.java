package q2445;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
public class Main {
	public static void main(String[]args) throws IOException {
		Scanner sc= new Scanner(System.in);
		int inp=sc.nextInt();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[]st= new String[2*inp-1];
		for(int i=0;i<inp;i++) {
			String temp="";
			for(int j=0;j<=i;j++) {
				temp+="*";
			}
			for(int k=i+1;k<inp;k++) {
				temp+=" ";
			}
			for(int l=inp-1;l>=0;l--) {
				temp+=String.valueOf(temp.charAt(l));
			}
			st[i]=temp;
		}
		for(int o=0;o<inp-1;o++) {
			st[inp+o]=st[inp-o-2];
		}
		for(int i=0;i<st.length;i++) {
			bw.write(st[i]+"\n");
		}
		bw.flush();
		sc.close();
		bw.close();
	}

}
