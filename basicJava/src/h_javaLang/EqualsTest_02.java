package h_javaLang;

public class EqualsTest_02 {
	public static void main(String[] args) {
		Person p1 = new Person(9706111384111L);
		Person p2 = new Person(9706111384111L);
		Person p3 = null;
		
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
	}
}

class Person {
	long id;
	
	public Person(long id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Person)) {
			return false;
		}
		return this.id == ((Person)o).id;
	}
}
