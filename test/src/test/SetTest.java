package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	/*set(����)
	 * - ������ �������� ����(�ε��� x)
	 * - �ߺ� ������ ���� �Ұ�(null�� 1���� ���� ����)
	 * */
	
	public void ex1() {
		
		Set<String> set = new HashSet<String>();
		
		set.add("���̹�");
		set.add("īī��");
		set.add("����");
		set.add("����");
		set.add("����ǹ���");
		set.add("��ٸ���");
		set.add("�佺");
		set.add("����");
		set.add("�߳���");
		set.add("�߳���");
		set.add("�߳���");
		set.add("�߳���");
		set.add("�߳���");
		set.add("�߳���");
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		
		
		// remove(String value) : Set�� ����� ��ü �� Value�� ���� ��ü ����
		// -> boolean ��ȯ
		// 	  ���ŵǸ� true / �ȵǸ� false
		
		set.remove("����");
		
		
		System.out.println(set.toString());
		
		
		// Set�� ����� ��� �ϳ��� ������
		
		//1. Iterator(�ݺ���)
		
		// - �÷��ǿ��� �����ϴ� �÷��� ��ü �ݺ� ������
		// -> �÷��ǿ� ����� ��ü�� ������ ������ �ϳ��� ������ ����
		
		Iterator<String> it = set.iterator();
		
		// Set.iterator(); 
		// Set�� ����� ��ü�� �̿��ؼ� Iterator ��ü�� ����� ��ȯ
		
		while( it.hasNext() ) {
			
			// hasNext() : ���� ���� �����ϸ� true
			String temp = it.next();
			//next() : ���� ���� ����
			
			System.out.println(temp);
		
		}
		
		System.out.println("------------------------------------");
		
		
		for(String temp : set) {
			System.out.println(temp);
		
	}

	}
	
	public void ex2() {
		
		/* Set�� ����� ��ü�� �ߺ����� �Ǵ��ϴ� ���
		 *  
		 *  - �ʵ忡 ����� ���� ��� ��ġ�ϸ� �ߺ����� �Ǵ�
		 *   -> �ߺ� �Ǵܿ� ����ϴ� �޼���
		 *    Object.equals() �޼����� �������̵��� �޼���
		 *    -> Person �������̵�
		 *    
		 *    
		 * Hash��� �ܾ ���� �÷����� �ߺ��� �Ǵ��ϴ� ���
		 *  -> Object.hashCode() �������̵�   
		 *  
		 *  Hash �Լ� : �Էµ� �ܾ ������ ������ ������ ���ڿ��� ��ȯ�ϴ� �Լ�
		 *  
		 *  hashCode() : ��ü�� ����� �ʵ带 �̿��ؼ� ������� ������ ��ȯ 
		 *  
		 * HashSet - > equals(), hashCode() �� �� �������̵� �Ǿ� �־�� ��
		 *   
		 *   ->equals()�Ǵ� hashCode�� �������̵� �ϸ�
		 *   	������ �ϳ��� �ݵ�� �������̵��� �����ض�!!
		 *    
		 *    
		 * */
		
		
		
		Set<Person> set = new HashSet<Person>();
		
		
		set.add(new Person("ȫ�浿", 15, "����� �߱�", 'M') );
		set.add(new Person("ȫ�浿", 15, "����� �߱�", 'M') );
		
		Person s1 = new Person("����", 17, "����� ���α�", 'M');
		Person s2 = new Person("����", 17, "����� ���α�", 'M');
		
		System.out.println(s1.equals(s2));
		
		for (Person s : set) {
			
			System.out.println(s);
		}
		
	}
	
}
