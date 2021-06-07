package f_OOP2;

public class AbstractTest_01 {
	public static void main(String[] args) {
		
	}
}

abstract class Unit {
	int x;
	int y;
	
	abstract void move(int x, int y);
	
	void stop() {
		
	}
}

class Marine extends Unit {
	@Override
	void move(int x, int y) {
		
	}
	
	void stimPack() {
		
	}
}

class Tank extends Unit {
	@Override
	void move(int x, int y) {
		
	}
	
	void changeMode() {
		
	}
}

class DropShip extends Unit {
	@Override
	void move(int x, int y) {
		
	}
	
	void load() {
		
	}
	
	void unLoad() {
		
	}
}