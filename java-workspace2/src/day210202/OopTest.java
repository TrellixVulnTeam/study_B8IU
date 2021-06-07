package day210202;

public class OopTest {
	public static void main(String[] args) {
//		Animal animal = new Animal();
//		System.out.println(animal.age);
//		
//		animal.getOld();
//		System.out.println(animal.age);
		
		Human human = new Human();
		System.out.println(human.age);
		System.out.println(human.power_lang);
		
		human.getOld();
		human.gawe(5);
		System.out.println(human.age);
		System.out.println(human.power_lang);
	}
}
