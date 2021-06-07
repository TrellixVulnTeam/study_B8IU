package day210202;

public class DogBirdTest {
	public static void main(String[] args) {
		Bird bird = new Bird();
		System.out.println(bird.power_bark);
		System.out.println(bird.power_fly);
		
		bird.teachFromHuman();
		bird.exercise(5);
		System.out.println(bird.power_bark);
		System.out.println(bird.power_fly);
	}
}
