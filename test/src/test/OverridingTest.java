package test;

public class OverridingTest {

	public static void main(String[] args) {
		Person person = new Person();
		Person child = new Child(); // ���ϵ忡�� ������ �޼��尡 �����ǵ��� ������
		Person senior = new Senior();
		
		person.cry();
		child.cry(); // �޼��� �������̵���  ���ϵ忡 �ִ� cry() �޼��带 �������̵��Ͽ�  person�� �������Ѱ� , ������ ����
		senior.cry();
	}
}