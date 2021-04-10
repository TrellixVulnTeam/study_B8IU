package f_OOP2;

public class Interface_01 {
	public static void main(String[] args) {
		
		Unit f1 = new Fight();
		
		Fightable f2= new Fight();
		
		Moveable f3 = new Fight();
		
		System.out.println(f1 instanceof Fight);
		System.out.println(f1 instanceof Unit);
		System.out.println(f1 instanceof Object);
		
		System.out.println(f1 instanceof Fightable);
//		f1은 Fightable의 구현체이다.
		Fightable f4 = (Fightable)f1;
		System.out.println(f1 instanceof Moveable);
	}
}

class Fight extends Unit implements Fightable {

	@Override
	public void attack(Unit u) {
		
	}

	@Override
	public void move(int x, int y) {
		
	}
	
	public void Method() {
		
	}
}

interface Fightable extends Moveable, Attackable{
	
}

interface Moveable {
	void move(int x, int y);
}

interface Attackable {
	void attack(Unit u);
}
