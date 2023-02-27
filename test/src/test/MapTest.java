package test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	/* Map : kye와 value 한 쌍이 데이터가 되어 이를 모아둔 객체
	 * 
	 * -key : map에 저장된 데이터를 구분하는 용도
	 * 		-> set의 특징을 지님(순서 x, 중복x, 
	 * 			equals(), hashCode() 오버라이딩 필요)
	 * 
	 * -value : Map에 실제 저장된 값을 의미
	 *  	-> List의 특징을 지님 (중복o)
	 * 
	 */
	
	public void ex1() {
		
		Map<Integer, String> map = new HashMap<Integer, String> ();
		
		// Map.put(key, value) : Map에 추가
		
		map.put(1, "홍길동");
		map.put(2, "고길동");
		map.put(3, "김길동");
		map.put(4, "이길동");
		map.put(5, "박길동");
		map.put(6, "최길동");
		
		// key 중복 -> 덮어쓰기
		map.put(1, "홍홍홍");
		
		// value 중복
		map.put(7, "최길동");
		
		
		System.out.println(map.toString());
		
	}
	
	
	public void ex2() {
		
		// Map은 언제 사용하면 좋은가?
		
		// 1) 재사용이 적은 VO를 대체하는 경우
		// 2) 한번에 다량의 데이터를 전달하는 경우
		//	  데이터의 명확한 구분을 위해서 사용
		
		// Person - > Map으로 변경해서 사용
		
		Map<String, Object> person = new HashMap<String, Object>();
		Person ps = new Person();
		
		// 값 추가
		ps.setName("홍길동"); //vo
		person.put("name", "홍길동"); // map
		
		ps.setAge(15);
		person.put("age", 15);
		
		ps.setAddress("서울시 중구");
		person.put("address", "서울시 중구");
		
		ps.setGender('남');
		person.put("gender", "남");
		
	
		
		System.out.println(ps);
		System.out.println(person);
		
		
		// value 각각 얻어와서 출력하기
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
		
		//keySet() ; Map에서 key 부분만을 추출하여 Set 형태로 반환
		
		
		
		for(String key :person.keySet()) 
			System.out.println(person.get(key));
			//Set<String>
	}
	
}
