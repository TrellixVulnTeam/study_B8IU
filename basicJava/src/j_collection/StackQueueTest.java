package j_collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		stack.push("0");
		stack.push("1");
		stack.push("2");
		
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println("============================");
		
		LinkedList<String> queue = new LinkedList<>();
		
		queue.offer("0");
		queue.offer("1");
		queue.offer("2");
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}
}
