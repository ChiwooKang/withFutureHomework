package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {

//	LIFO 구조
//	STACK 영역에서 사용
//	재귀함수 호출시 사용
//  ArrayList 같은 배열함수가 사용에 적합
	
	/*
	 * 큐는 FIFO구조 별도의 클래스가 존재하지 않아 인터페이스로 사용
	 * 큐를 구현할때는 LinkedList로 구현
	 */
	
	
	
	// 스택은 함수 계산할때 유리
	// 큐는 버퍼 사용시 유리, 페이지의 뒤로가기같은 기능도 사용가능
	
	public void StackTest() {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		
		Queue<String> que = new LinkedList<>();
		que.add("0");
		que.add("1");
		que.add("2");
		
		System.out.println("stack");
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println();
		
		System.out.println("큐");
		
		while (!que.isEmpty()) {
			System.out.println(que.poll());
		}
	}
	
	
}
