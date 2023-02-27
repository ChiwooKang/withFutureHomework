package test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	/* Map : kye�� value �� ���� �����Ͱ� �Ǿ� �̸� ��Ƶ� ��ü
	 * 
	 * -key : map�� ����� �����͸� �����ϴ� �뵵
	 * 		-> set�� Ư¡�� ����(���� x, �ߺ�x, 
	 * 			equals(), hashCode() �������̵� �ʿ�)
	 * 
	 * -value : Map�� ���� ����� ���� �ǹ�
	 *  	-> List�� Ư¡�� ���� (�ߺ�o)
	 * 
	 */
	
	public void ex1() {
		
		Map<Integer, String> map = new HashMap<Integer, String> ();
		
		// Map.put(key, value) : Map�� �߰�
		
		map.put(1, "ȫ�浿");
		map.put(2, "��浿");
		map.put(3, "��浿");
		map.put(4, "�̱浿");
		map.put(5, "�ڱ浿");
		map.put(6, "�ֱ浿");
		
		// key �ߺ� -> �����
		map.put(1, "ȫȫȫ");
		
		// value �ߺ�
		map.put(7, "�ֱ浿");
		
		
		System.out.println(map.toString());
		
	}
	
	
	public void ex2() {
		
		// Map�� ���� ����ϸ� ������?
		
		// 1) ������ ���� VO�� ��ü�ϴ� ���
		// 2) �ѹ��� �ٷ��� �����͸� �����ϴ� ���
		//	  �������� ��Ȯ�� ������ ���ؼ� ���
		
		// Person - > Map���� �����ؼ� ���
		
		Map<String, Object> person = new HashMap<String, Object>();
		Person ps = new Person();
		
		// �� �߰�
		ps.setName("ȫ�浿"); //vo
		person.put("name", "ȫ�浿"); // map
		
		ps.setAge(15);
		person.put("age", 15);
		
		ps.setAddress("����� �߱�");
		person.put("address", "����� �߱�");
		
		ps.setGender('��');
		person.put("gender", "��");
		
	
		
		System.out.println(ps);
		System.out.println(person);
		
		
		// value ���� ���ͼ� ����ϱ�
		// ps
		System.out.println(ps.getName());
		System.out.println(ps.getAge());
		System.out.println(ps.getAddress());
		System.out.println(ps.getGender());

		
		System.out.println("------------------------------");
		
		// person(map)
		System.out.println(person.get("name"));
		System.out.println(person.get("age"));
		System.out.println(person.get("address"));
		System.out.println(person.get("gender"));
		System.out.println(person.get("score"));
		
		//keySet() ; Map���� key �κи��� �����Ͽ� Set ���·� ��ȯ
		
		
		
		for(String key :person.keySet()) 
			System.out.println(person.get(key));
			//Set<String>
	}
	
}
