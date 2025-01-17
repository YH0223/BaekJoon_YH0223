package q10828;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {

	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int sizeArray = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<sizeArray;i++) {
			 String command=sc.next();
			 if(command.equals("push")) {
				 stack.push(sc.nextInt());
			 }else if(command.equals("pop")) {
				 if(stack.isEmpty()) {
					 System.out.println(-1);
				 }else {
					 System.out.println(stack.pop());
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
					 System.out.println(stack.peek());
				 }
			 }
		}
		
	}

}
