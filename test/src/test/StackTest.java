package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {

//	LIFO ����
//	STACK �������� ���
//	����Լ� ȣ��� ���
//  ArrayList ���� �迭�Լ��� ��뿡 ����
	
	/*
	 * ť�� FIFO���� ������ Ŭ������ �������� �ʾ� �������̽��� ���
	 * ť�� �����Ҷ��� LinkedList�� ����
	 */
	
	
	
	// ������ �Լ� ����Ҷ� ����
	// ť�� ���� ���� ����, �������� �ڷΰ��ⰰ�� ��ɵ� ��밡��
	
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
		
		System.out.println("ť");
		
		while (!que.isEmpty()) {
			System.out.println(que.poll());
		}
	}
	
	
}
