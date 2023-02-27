package test;

public class OverridingTest {

	public static void main(String[] args) {
		Person person = new Person();
		Person child = new Child(); // 차일드에서 가져온 메서드가 재정의됨을 보여줌
		Person senior = new Senior();
		
		person.cry();
		child.cry(); // 메서드 오버라이딩함  차일드에 있는 cry() 메서드를 오버라이딩하여  person에 재정의한것 , 다형성 예시
		senior.cry();
	}
}