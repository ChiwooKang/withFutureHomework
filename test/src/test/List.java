package test;

import java.util.ArrayList;

public class List {

	/*
	 * List : �ڷ���� ���������� ������ �ڷᱸ��(�迭�� �����)
	 * 
	 * - �ε����� �̿��� ������ ����
	 * - �ߺ� �� ���� ����(�ε��� ��ȣ�� ���� �����ϱ� ������)
	 * 
	 * - List�� ��ӹٴ� ������ Ŭ����
	 *  -> ArrayList, LinkedList,Vector
	 * 
	 * 
	 * */

public void ex1() {
	// �÷���(List) ����
	// - Ư¡
	// 1)ũ�� ������ ����
	// 2) �߰�, ����, ����, ���� ���� ����� �����Ǿ� �ִ�
	// 3) ���� Ÿ���� ��ü�� ������ �� �ִ�.
	//		-> Object ���� ������ ����
	
	// java.util ��Ű��
	//ArrayList list = new ArrayList(); //�⺻ ������ -> 10ĭ¥��
	
	ArrayList list = new ArrayList(3); //3ĭ¥�� ����
	
	//add(E e) : ����Ʈ�� ������ ��ġ�� ��ü �߰�
	list.add( new Object());
	list.add( new Person());
	list.add( new String());
	
	// ArrayList�� ũ�� 3�� �ʰ��ؼ� �߰�
	list.add(new String("�ʰ�")); //ũ�Ⱑ �ڵ����� ������ Ȯ��
	
	// add(int index, E e) : index ��ġ�� E ��ü�� �߰�
	list.add(1, new Person("ȫų��", 15, "������", '��'));
	
	//set(int index, E e) : index ��ġ�� ����
	Object str = list.set(4, new String("������ ���ڿ�"));
	
	// remove(int index) :  index ��ġ�� ��ü�� ������ ��ȯ
	Object person = list.remove(2);
	
	
	// size() : List�� ����� ����� ������ ��ȯ 
	// get(int index) :  index�� ��ġ�� ��ü�� ����
	
	
	
	
	System.out.println("����");
}


}
