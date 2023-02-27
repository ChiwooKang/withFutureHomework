package test;

import java.util.Objects;

class Person {
	
	private String name;
	private int age;
	private String address;
	private char gender ;
	
	
	public Person() {
		
	}
	
	void cry() { System.out.println("ÈæÈæ"); }

	public Person(String name, int age, String address, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	

	

	@Override
	public int hashCode() {
		return Objects.hash(address, age, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && age == other.age && gender == other.gender
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + ", gender=" + gender + ", score="
				+  "]";
	}
	
	
	 
	 
}
