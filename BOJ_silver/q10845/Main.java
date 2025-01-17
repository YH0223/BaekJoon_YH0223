package q10845;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int last=-1;

	public static void main(String[]args) {
		
		Scanner sc = new Scanner(System.in);
		int sizeArray = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<sizeArray;i++) {
			 String command=sc.next();
			 if(command.equals("push")) {
				 int temp=sc.nextInt();
				 queue.offer(temp);
				 last=temp;
			 }else if(command.equals("pop")) {
				 if(queue.isEmpty()) {
					 System.out.println(-1);
				 }else {
					 System.out.println(queue.poll());
				 }
			 }else if(command.equals("size")) {
				 System.out.println(queue.size());
			 }else if(command.equals("empty")) {
				 if(queue.isEmpty()) {
					 System.out.println(1);
				 }else {
					 System.out.println(0);
				 }
			 }else if(command.equals("front")) {
				 if(queue.isEmpty()) {
					 System.out.println(-1);
				 }else {
					 System.out.println(queue.peek());
				 }
			 }else if(command.equals("back")) {
				 if(queue.isEmpty()) {
					 System.out.println(-1);
				 }else {
					 System.out.println(last);
				 }
			 }
		}
		
	}

}
