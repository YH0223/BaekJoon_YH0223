package q10828;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int sizeArray = sc.nextInt();
		List<Integer> stack = new ArrayList<>();
		for(int i=0;i<sizeArray;i++) {
			 String command=sc.next();
			 if(command.equals("push")) {
				 stack.add(sc.nextInt());
			 }else if(command.equals("pop")) {
				 if(stack.isEmpty()) {
					 System.out.println(-1);
				 }else {
					 System.out.println(stack.get(stack.size()-1));
					 stack.remove(stack.size()-1);
				 }
			 }else if(command.equals("size")) {
				 System.out.println(stack.size());
			 }else if(command.equals("empty")) {
				 if(stack.isEmpty()) {
					 System.out.println(1);
				 }else {
					 System.out.println(0);
				 }
			 }else if(command.equals("top")) {
				 if(stack.isEmpty()) {
					 System.out.println(-1);
				 }else {
					 System.out.println(stack.get(stack.size()-1));
				 }
			 }
		}
		
	}

}
