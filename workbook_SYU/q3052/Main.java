package q3052;
import java.util.Set;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new java.util.HashSet<>();
		for(int i=0;i<10;i++) {
			set.add(sc.nextInt()%42);
		}
		System.out.print(set.size());
    }
	
	
}
